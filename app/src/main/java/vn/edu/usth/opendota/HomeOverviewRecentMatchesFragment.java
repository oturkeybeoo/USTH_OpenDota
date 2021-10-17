package vn.edu.usth.opendota;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.fragment_home_overview_recent_matches, container, false);
        // Inflate the layout for this fragment
        LinearLayout linearTest = (LinearLayout) view.findViewById(R.id.recentMatch);
        linearTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MatchDetailsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}