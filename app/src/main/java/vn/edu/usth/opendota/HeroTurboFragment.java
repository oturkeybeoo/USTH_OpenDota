package vn.edu.usth.opendota;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class HeroTurboFragment extends Fragment {
        private ItemRankedListAdapter adapter;
        // Lay du lieu tu API truyen vao danh sach heroRankedList
        public List<HeroRanked> heroRankedLst = new ArrayList<>();
        public HeroTurboFragment() {
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
//        LayoutInflater localInflater = getActivity().getLayoutInflater();
            View mView = inflater.inflate(R.layout.fragment_hero_ranked, container, false);
            unit(mView);
            return mView;

        }


        @Override
        public void onResume() {
            super.onResume();

        }

        @SuppressLint("NotifyDataSetChanged")
        private void unit(View view) {
            HeroRanked hero1 = new HeroRanked("Abadon", "50.00%", "20.08%");
            HeroRanked hero2 = new HeroRanked("Zeus", "40.00%", "30.08%");
            HeroRanked hero3 = new HeroRanked("Lina", "20.00%", "20.08%");
            HeroRanked hero4 = new HeroRanked("Mars", "30.00%", "50.08%");
            HeroRanked hero5 = new HeroRanked("Marci", "80.00%", "60.08%");
            heroRankedLst.add(hero1);
            heroRankedLst.add(hero2);
            heroRankedLst.add(hero3);
            heroRankedLst.add(hero4);
            heroRankedLst.add(hero5);
            // Anh xa map layout voi code
            RecyclerView heroRankedList = view.findViewById(R.id.HeroRankedList);
            // Khoi tao layout
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            heroRankedList.setLayoutManager(layoutManager);
            // Truyen tham so vào adapter
            adapter = new ItemRankedListAdapter(getActivity(), heroRankedLst);
            heroRankedList.setAdapter(adapter);
            // thay doi list khi du lieu thay doi
            adapter.notifyDataSetChanged();
        }
}