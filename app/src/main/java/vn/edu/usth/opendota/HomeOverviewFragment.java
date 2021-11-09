package vn.edu.usth.opendota;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

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
        String player_id = "339941742";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = String.format("https://opendota.com/api/players/%s", player_id);
        String win_lose_url = String.format("https://opendota.com/api/players/%s/wl", player_id);



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
                            String avatar = response.getJSONObject("profile").getString("avatarfull");
                            String steam_url = response.getJSONObject("profile").getString("profileurl");

                            binding.homeOverviewName.setText(name);
                            binding.leaderboardRank.setText(String.format("#%d",leaderboard_rank));
                            binding.soloCompetitiveRank.setText(String.format("#%d",solo_competitive_rank));
                            binding.competitiveRank.setText(String.format("#%d",competitive_rank));
                            binding.mmr.setText(mmr.toString());
                            ImageView imageView = getView().findViewById(R.id.home_overview_avatar);
                            Picasso.with(getContext()).load(avatar).into(imageView);
                            binding.homeOverviewSteamUrl.setText(steam_url);

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

        JsonObjectRequest winLoseRequest = new JsonObjectRequest(Request.Method.GET, win_lose_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Integer wins = response.getInt("win");
                            Integer loses = response.getInt("lose");
                            Integer games = wins + loses;

                            binding.homeOverviewWin.setText(wins.toString());
                            binding.homeOverviewGames.setText(games.toString());
                            binding.homeOverviewWinRate.setText(getWinRate(games, wins));

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

        queue.add(winLoseRequest);
        queue.add(jsonObjectRequest);

    }

    private String getWinRate(Integer games, Integer wins) {
        Double game = Double.valueOf(games);
        Double win = Double.valueOf(wins);
        Double win_rate = win*100/game;
        return String.format("%.2f%%", win_rate);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}