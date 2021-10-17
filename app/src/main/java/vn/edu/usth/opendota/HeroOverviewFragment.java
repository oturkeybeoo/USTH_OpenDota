package vn.edu.usth.opendota;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class HeroOverviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_overview, container, false);

        TabLayout hero_overview_tab_layout = view.findViewById(R.id.hero_overview_tab_layout);
        ViewPager2 hero_overview_view_pager = view.findViewById(R.id.hero_overview_view_pager);

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

        return view;
    }



//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_hero_overview);
//
//
//
//        TabLayout hero_overview_tab_layout = findViewById(R.id.hero_overview_tab_layout);
//        ViewPager2 hero_overview_view_pager = findViewById(R.id.hero_overview_view_pager);
//
//        HeroOverviewAdapter overview_adapter = new HeroOverviewAdapter(this);
//        hero_overview_view_pager.setAdapter(overview_adapter);
//
//        new TabLayoutMediator(hero_overview_tab_layout, hero_overview_view_pager, (tab, position) -> {
//            switch (position) {
//                case 0:
//                    tab.setText("Ranked");
//                    break;
//                case 1:
//                    tab.setText("Public");
//                    break;
//                case 2:
//                    tab.setText("Turbo");
//                    break;
//            }
//        }).attach();
//    }
}