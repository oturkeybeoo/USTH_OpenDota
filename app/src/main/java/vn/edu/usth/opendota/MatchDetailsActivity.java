package vn.edu.usth.opendota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.usth.opendota.databinding.ActivityMatchDetailsBinding;

public class MatchDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);

        String match_id = getIntent().getStringExtra("match_id");

        TabLayout match_details_tab_layout = findViewById(R.id.match_details_tab_layout);
        ViewPager2 match_details_view_pager = findViewById(R.id.match_details_view_pager);

        MatchOverviewAdapter overview_adapter = new MatchOverviewAdapter(this);
        match_details_view_pager.setAdapter(overview_adapter);

        new TabLayoutMediator(match_details_tab_layout, match_details_view_pager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Overview");
                    break;
                case 1:
                    tab.setText("Benchmark");
                    break;
            }
        }).attach();

    }

}