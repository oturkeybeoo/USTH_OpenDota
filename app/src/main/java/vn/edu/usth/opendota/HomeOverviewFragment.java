package vn.edu.usth.opendota;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.usth.opendota.adapter.MatchAdapter;
import vn.edu.usth.opendota.model.MatchModel;

public class HomeOverviewFragment extends Fragment {

    public HomeOverviewFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    ArrayList<MatchModel> matchList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_overview, container, false);
        recyclerView = view.findViewById(R.id.recentmatch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        recyclerView.setAdapter(new MatchAdapter(getContext(), initData()));
        return view;
    }

    private ArrayList<MatchModel> initData() {
        matchList = new ArrayList<>();
        matchList.add(new MatchModel(R.drawable.dire_logo,"All Draft", "2/6/2", "26.43", "5 days"));
        matchList.add(new MatchModel(R.drawable.dire_logo,"All Draft", "2/6/2", "26.43", "5 days"));

        return matchList;
    }

//    @Override
//    public void onItemClicked() {
//        Intent intent = new Intent(getActivity(), MatchDetailsActivity.class);
//        startActivity(intent);
//    }
}