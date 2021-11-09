package vn.edu.usth.opendota;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vn.edu.usth.opendota.adapter.MatchAdapter;
import vn.edu.usth.opendota.databinding.FragmentHomeOverviewBinding;
import vn.edu.usth.opendota.databinding.FragmentMatchOverviewBinding;
import vn.edu.usth.opendota.model.MatchModel;

public class HomeOverviewFragment extends Fragment {

    private FragmentHomeOverviewBinding binding;

    public HomeOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeOverviewBinding.inflate(inflater, container, false);

        View view = binding.getRoot();
        fetchData();
        return view;
    }

    private void fetchData() {
        String match_id = "339941742";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = String.format("https://opendota.com/api/players/%s", match_id);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Integer leaderboard_rank = response.getInt("leaderboard_rank");
                            Integer solo_competitive_rank = response.getInt("solo_competitive_rank");
                            Integer competitive_rank = response.getInt("competitive_rank");
                            Integer mmr = response.getJSONObject("mmr_estimate").getInt("estimate");
                            String name = response.getJSONObject("profile").getString("personaname");
                            String avatar = response.getJSONObject("profile").getString("avatar");

                            binding.homeOverviewName.setText(name);
                            binding.leaderboardRank.setText(String.format("#%d",leaderboard_rank));
                            binding.soloCompetitiveRank.setText(String.format("#%d",solo_competitive_rank));
                            binding.competitiveRank.setText(String.format("#%d",competitive_rank));
                            binding.mmr.setText(mmr.toString());
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}