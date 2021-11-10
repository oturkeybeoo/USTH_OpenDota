package vn.edu.usth.opendota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.adapter.PeerAdapter;
import vn.edu.usth.opendota.adapter.SearchAdapter;
import vn.edu.usth.opendota.model.PeerModel;
import vn.edu.usth.opendota.model.SearchUser;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchAdapter search_adapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String player_id = "339941742";
        List<SearchUser> peerModelArrayList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = String.format("https://opendota.com/api/players/%s/peers", player_id);

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < 20; i++) {
                                JSONObject peer = response.getJSONObject(i);
                                String name = peer.getString("personaname");
                                Long account_id = peer.getLong("account_id");


                                peerModelArrayList.add(new SearchUser(R.drawable.dire_logo, name, account_id));

                                recyclerView = findViewById(R.id.search_recycler);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                                recyclerView.setLayoutManager(linearLayoutManager);
                                search_adapter = new SearchAdapter(peerModelArrayList, getBaseContext());
                                recyclerView.setAdapter(search_adapter);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);



        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.search_bar);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search_adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search_adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}