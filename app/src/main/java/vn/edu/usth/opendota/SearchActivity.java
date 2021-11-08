package vn.edu.usth.opendota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.adapter.SearchAdapter;
import vn.edu.usth.opendota.model.SearchUser;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView search_recycler;
    private SearchAdapter search_adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_recycler = findViewById(R.id.search_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        search_recycler.setLayoutManager(linearLayoutManager);

        search_adapter = new SearchAdapter(getListUser());
        search_recycler.setAdapter(search_adapter);

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

    private List<SearchUser> getListUser() {
        List<SearchUser> list = new ArrayList<>();

        list.add(new SearchUser(R.drawable.dire_logo, "hieu", "1111111111"));
        list.add(new SearchUser(R.drawable.dire_logo, "nguyen", "222222222"));
        list.add(new SearchUser(R.drawable.dire_logo, "quan", "333333333"));
        list.add(new SearchUser(R.drawable.dire_logo, "quynh", "444444444"));
        list.add(new SearchUser(R.drawable.dire_logo, "vinh", "5555555555"));

        return list;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}