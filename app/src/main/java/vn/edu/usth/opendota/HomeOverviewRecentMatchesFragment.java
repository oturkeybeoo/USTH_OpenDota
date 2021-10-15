package vn.edu.usth.opendota;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeOverviewRecentMatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeOverviewRecentMatchesFragment extends Fragment {

    public HomeOverviewRecentMatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_overview_recent_matches, container, false);
    }
}