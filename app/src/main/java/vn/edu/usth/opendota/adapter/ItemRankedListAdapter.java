package vn.edu.usth.opendota.adapter;

import android.app.Activity;
import android.content.Context;
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
    private Context context;
    private List<HeroRanked> heroRankedList;

// Contructor de truyen du lieu tu fragment
    public ItemRankedListAdapter (Context context, List<HeroRanked> heroRankedList){
        this.context = context;
        this.heroRankedList = heroRankedList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ranked_item_list, parent, false);
        return new ViewHolder(view);
    }

    // De set du lieu vao item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (heroRankedList == null){

        }else {
            HeroRanked heroRanked = new HeroRanked(heroRankedList.get(position).getHero_name(),heroRankedList.get(position).getWin_rate(), heroRankedList.get(position).getBan());
//            heroRanked = heroRankedList.get(position);
            holder.hero.setText(heroRanked.getHero_name());
            holder.wind_rate.setText(heroRanked.getWin_rate());
            holder.bans.setText(heroRanked.getBan());
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
        TextView bans = itemView.findViewById(R.id.bans);
        TextView wind_rate = itemView.findViewById(R.id.win_rate);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
