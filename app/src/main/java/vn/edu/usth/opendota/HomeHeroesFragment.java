package vn.edu.usth.opendota;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vn.edu.usth.opendota.adapter.HeroAdapter;
import vn.edu.usth.opendota.adapter.MatchAdapter;
import vn.edu.usth.opendota.model.HeroModel;
import vn.edu.usth.opendota.model.MatchModel;

public class HomeHeroesFragment extends Fragment {

    public HomeHeroesFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    ArrayList<HeroModel> heroModelArrayList;
    HeroAdapter heroAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_heroes, container, false);

        String player_id = "339941742";
        heroModelArrayList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = String.format("https://opendota.com/api/players/%s/heroes", player_id);

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < 20; i++) {
                                JSONObject hero = response.getJSONObject(i);
                                Integer hero_id = hero.getInt("hero_id");
                                Long last_played = hero.getLong("last_played");
                                Integer games = hero.getInt("games");
                                Integer win = hero.getInt("win");

                                heroModelArrayList.add(new HeroModel(hero_id, getEndedTime(last_played), games, getWinRate(games, win)));


                                recyclerView = view.findViewById(R.id.recent_heroes);
                                recyclerView.setHasFixedSize(true);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
                                recyclerView.setLayoutManager(linearLayoutManager);
                                heroAdapter = new HeroAdapter(getContext(), heroModelArrayList);
                                recyclerView.setAdapter(heroAdapter);

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

        return view;
    }

    @NonNull
    private String getEndedTime(Long start_time) {
        Long now = System.currentTimeMillis() / 1000L;
        Long ended = (now - start_time);

        if (ended / 31536000 == 1) {
            return String.format("%d year ago", ended/31536000);
        } else if (ended / 31536000 > 1) {
            return String.format("%d years ago", ended/31536000);
        } else if (ended / 2592000 == 1) {
            return String.format("%d month ago", ended/2592000);
        } else if (ended / 2592000 > 1) {
            return String.format("%d months ago", ended/2592000);
        } else if (ended / 604800 == 1) {
            return String.format("%d week ago", ended/604800);
        } else if (ended / 604800 > 1) {
            return String.format("%d weeks ago", ended/604800);
        } else if (ended / 86400 == 1) {
            return String.format("%d day ago", ended/86400);
        } else if (ended / 86400 > 1) {
            return String.format("%d days ago", ended/86400);
        } else if (ended / 3600 == 1) {
            return String.format("%d hour ago", ended/3600);
        } else if (ended / 3600 > 1) {
            return String.format("%d hours ago", ended/3600);
        } else if (ended / 60 == 1) {
            return String.format("%d minute ago", ended/60);
        } else if (ended / 60 > 1) {
            return String.format("%d minutes ago", ended/60);
        } else {
            return String.format("%d seconds ago", ended);
        }
    }

    private String getWinRate(Integer games, Integer wins) {
        Double game = Double.valueOf(games);
        Double win = Double.valueOf(wins);
        Double win_rate = win*100/game;
        return String.format("%.2f%%", win_rate);
    }

}