package vn.edu.usth.opendota.model;

import androidx.lifecycle.ViewModel;

import org.json.JSONArray;

public class MatchOverviewModel extends ViewModel {

    private Boolean radiant_win;
    private String match_id;
    private Integer region;
    private Integer radiant_score;
    private Integer dire_score;
    private Integer game_mode;
    private String duration;
    private String radiant_team_name;
    private String dire_team_name;

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
