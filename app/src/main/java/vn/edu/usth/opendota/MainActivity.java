package vn.edu.usth.opendota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);
        // setting up the adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new HomeOverviewFragment(), "HANOI, VIETNAM");
        viewPagerAdapter.add(new HomeOverviewFragment(), "PARIS, FRANCE");


        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);
    }
}