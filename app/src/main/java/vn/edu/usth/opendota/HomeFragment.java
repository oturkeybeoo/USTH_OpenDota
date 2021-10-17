package vn.edu.usth.opendota;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.activity_home, parent, false);
        AddViewPager(view);
        return view;
    }

    private void AddViewPager(View view) {
        ViewPager viewPager = view.findViewById(R.id.viewpager);
        // setting up the adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new HomeOverviewFragment(), "Overview");
        viewPagerAdapter.add(new HomeMatchesFragment(), "Matches");
        viewPagerAdapter.add(new HomeHeroesFragment(), "Heroes");
        viewPagerAdapter.add(new HomePeersFragment(), "Peers");

        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);
    }


}