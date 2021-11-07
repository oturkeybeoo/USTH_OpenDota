package vn.edu.usth.opendota;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.usth.opendota.adapter.MatchAdapter;


public class HomeOverviewRecentMatchesFragment extends Fragment implements SelectListener{

    public HomeOverviewRecentMatchesFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    ArrayList<Match> matchList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_overview_recent_matches, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recentmatch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        recyclerView.setAdapter(new MatchAdapter(getContext(), initData(), this));
        return view;
    }
    private ArrayList<Match> initData() {
        matchList = new ArrayList<>();
        matchList.add(new Match(R.drawable.dire_logo,"All Draft\n Ranked", "5 days", "26.43", "2/6/2"));

        return matchList;
    }

    @Override
    public void onItemClicked() {
        Intent intent = new Intent(getActivity(), MatchDetailsActivity.class);
        startActivity(intent);
    }
}