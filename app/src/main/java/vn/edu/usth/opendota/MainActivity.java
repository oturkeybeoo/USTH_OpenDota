package vn.edu.usth.opendota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddViewPager();
    }

    private void AddViewPager() {
        ViewPager viewPager = findViewById(R.id.viewpager);
        // setting up the adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new HomeOverviewFragment(), "Overview");
        viewPagerAdapter.add(new HomeMatchesFragment(), "Matches");
        viewPagerAdapter.add(new HomeHeroesFragment(), "Heroes");
        viewPagerAdapter.add(new HomePeersFragment(), "Peers");


        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);
    }
}