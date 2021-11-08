package vn.edu.usth.opendota;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.usth.opendota.databinding.FragmentMatchOverviewBinding;

public class MatchOverviewFragment extends Fragment {

    private FragmentMatchOverviewBinding binding;

    public MatchOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMatchOverviewBinding.inflate(inflater, container, false);

        View view = binding.getRoot();
        fetchData();
        return view;
    }

    private void fetchData() {
        String match_id = "6258984257";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = String.format("https://opendota.com/api/matches/%s", match_id);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Boolean radiant_win = response.getBoolean("radiant_win");
                            String match_id = response.getString("match_id");
                            Integer region = response.getInt("region");
                            Integer radiant_score = response.getInt("radiant_score");
                            Integer dire_score = response.getInt("dire_score");
                            Integer game_mode = response.getInt("game_mode");
                            String duration = getTime(response.getInt("duration"));
                            String radiant_team_name = response.getJSONObject("radiant_team").getString("name");
                            String dire_team_name = response.getJSONObject("dire_team").getString("name");
                            JSONArray players = response.getJSONArray("players");

                            if (radiant_win) {
                                binding.matchOverviewVictoryTeam.setText("Radiant Victory");
                                binding.matchOverviewVictoryTeamIcon.setImageResource(R.drawable.radiant_logo);
                            } else {
                                binding.matchOverviewVictoryTeam.setText(("Dire Victory"));
                                binding.matchOverviewVictoryTeamIcon.setImageResource(R.drawable.dire_logo);
                            }
                            binding.matchOverviewMatchId.setText(match_id);
                            binding.matchOverviewRegion.setText(region.toString());
                            binding.matchOverviewDireKills.setText(dire_score.toString());
                            binding.matchOverviewRadiantKills.setText(radiant_score.toString());
                            binding.matchOverviewGameMode.setText(game_mode.toString());
                            binding.matchOverviewDuration.setText(duration);
                            binding.matchOverviewRadiantTeamName.setText(radiant_team_name);
                            binding.matchOverviewDireTeamName.setText(dire_team_name);

                            JSONObject player_1 = players.getJSONObject(0);
                            binding.matchOverviewRadiantPlayer1.setText(player_1.getString("personaname"));
                            binding.matchOverviewRadiantKda1.setText(String.format("%d/%d/%d", player_1.getInt("kills"), player_1.getInt("deaths"), player_1.getInt("assists")));

                            JSONObject player_2 = players.getJSONObject(1);
                            binding.matchOverviewRadiantPlayer2.setText(player_2.getString("personaname"));
                            binding.matchOverviewRadiantKda2.setText(String.format("%d/%d/%d", player_2.getInt("kills"), player_2.getInt("deaths"), player_2.getInt("assists")));

                            JSONObject player_3 = players.getJSONObject(2);
                            binding.matchOverviewRadiantPlayer3.setText(player_2.getString("personaname"));
                            binding.matchOverviewRadiantKda3.setText(String.format("%d/%d/%d", player_3.getInt("kills"), player_3.getInt("deaths"), player_3.getInt("assists")));

                            JSONObject player_4 = players.getJSONObject(3);
                            binding.matchOverviewRadiantPlayer4.setText(player_4.getString("personaname"));
                            binding.matchOverviewRadiantKda4.setText(String.format("%d/%d/%d", player_4.getInt("kills"), player_4.getInt("deaths"), player_4.getInt("assists")));

                            JSONObject player_5 = players.getJSONObject(4);
                            binding.matchOverviewRadiantPlayer5.setText(player_5.getString("personaname"));
                            binding.matchOverviewRadiantKda5.setText(String.format("%d/%d/%d", player_5.getInt("kills"), player_5.getInt("deaths"), player_5.getInt("assists")));

                            JSONObject player_6 = players.getJSONObject(5);
                            binding.matchOverviewDirePlayer1.setText(player_6.getString("personaname"));
                            binding.matchOverviewDireKda1.setText(String.format("%d/%d/%d", player_6.getInt("kills"), player_6.getInt("deaths"), player_6.getInt("assists")));

                            JSONObject player_7 = players.getJSONObject(6);
                            binding.matchOverviewDirePlayer2.setText(player_7.getString("personaname"));
                            binding.matchOverviewDireKda2.setText(String.format("%d/%d/%d", player_7.getInt("kills"), player_7.getInt("deaths"), player_7.getInt("assists")));

                            JSONObject player_8 = players.getJSONObject(7);
                            binding.matchOverviewDirePlayer3.setText(player_8.getString("personaname"));
                            binding.matchOverviewDireKda3.setText(String.format("%d/%d/%d", player_8.getInt("kills"), player_8.getInt("deaths"), player_8.getInt("assists")));

                            JSONObject player_9 = players.getJSONObject(8);
                            binding.matchOverviewDirePlayer4.setText(player_9.getString("personaname"));
                            binding.matchOverviewDireKda4.setText(String.format("%d/%d/%d", player_9.getInt("kills"), player_9.getInt("deaths"), player_9.getInt("assists")));

                            JSONObject player_10 = players.getJSONObject(9);
                            binding.matchOverviewDirePlayer5.setText(player_10.getString("personaname"));
                            binding.matchOverviewDireKda5.setText(String.format("%d/%d/%d", player_10.getInt("kills"), player_10.getInt("deaths"), player_10.getInt("assists")));

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

    private String getTime(Integer time) {
        int h, m, s;

        h = time/3600;
        time %= 3600;
        m = time/60;
        time %= 60;
        s = time;

        return String.format("%02d:%02d:%02d", h, m, s);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}