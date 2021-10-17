package vn.edu.usth.opendota;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class HeroOverviewFragment extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hero_overview);

        TabLayout hero_overview_tab_layout = findViewById(R.id.hero_overview_tab_layout);
        ViewPager2 hero_overview_view_pager = findViewById(R.id.hero_overview_view_pager);

        HeroOverviewAdapter overview_adapter = new HeroOverviewAdapter(this);
        hero_overview_view_pager.setAdapter(overview_adapter);

        new TabLayoutMediator(hero_overview_tab_layout, hero_overview_view_pager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Ranked");
                    break;
                case 1:
                    tab.setText("Public");
                    break;
                case 2:
                    tab.setText("Turbo");
                    break;
            }
        }).attach();
    }
}