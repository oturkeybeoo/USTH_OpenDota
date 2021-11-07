package vn.edu.usth.opendota.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.opendota.HeroRanked;
import vn.edu.usth.opendota.R;

public class ItemRankedListAdapter extends RecyclerView.Adapter<ItemRankedListAdapter.ViewHolder> {
    private Activity activity;
    private List<HeroRanked> heroRankedList;

// Contructor de truyen du lieu tu fragment
    public ItemRankedListAdapter (FragmentActivity activity, List<HeroRanked> heroRankedList){
        this.activity = activity;
        this.heroRankedList = heroRankedList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.ranked_item_list, parent, false);
        return new ViewHolder(view);
    }

    // De set du lieu vao item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (heroRankedList == null){

        }else {
            HeroRanked heroRanked = new HeroRanked(heroRankedList.get(position).getHero_name(), heroRankedList.get(position).getPick_rate(),heroRankedList.get(position).getWin_rate());
//            heroRanked = heroRankedList.get(position);
            holder.hero.setText(heroRanked.getHero_name());
            holder.pick_rate.setText(heroRanked.getPick_rate());
            holder.wind_rate.setText(heroRanked.getWin_rate());
            //set icon hero
            holder.icon_hero.setImageResource(R.drawable.dire_logo);
        }
    }

    @Override
    public int getItemCount() {
        return heroRankedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon_hero = itemView.findViewById(R.id.icon_hero);
        TextView hero = itemView.findViewById(R.id.Hero);
        TextView pick_rate = itemView.findViewById(R.id.pick_rate);
        TextView wind_rate = itemView.findViewById(R.id.win_rate);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
