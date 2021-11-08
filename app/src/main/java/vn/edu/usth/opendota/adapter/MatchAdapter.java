package vn.edu.usth.opendota.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.opendota.MatchDetailsActivity;
import vn.edu.usth.opendota.model.MatchModel;
import vn.edu.usth.opendota.R;


public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MatchModel> listMatch;
//    private SelectListener listener;

    public MatchAdapter(Context context, ArrayList<MatchModel> listMatch) {
        this.context = context;
        this.listMatch = listMatch;
//        this.listener = listener;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.match_item, parent, false);
        return new MatchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchModel match = listMatch.get(position);
        holder.matchHero.setImageResource(match.getHero());
        holder.matchMode.setText(match.getMode());
        holder.matchLength.setText(match.getLength());
        holder.matchEnd.setText(match.getEnded());
        holder.matchKda.setText(match.getKda());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClicked();
                listMatch.get(position);
                context.startActivities(new Intent[]{new Intent(context, MatchDetailsActivity.class)});

            }
        });
    }

    @Override
    public int getItemCount() {
        return listMatch.size(); // trả item tại vị trí postion
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView matchHero;
        TextView matchMode, matchLength, matchEnd, matchKda;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            matchHero = itemView.findViewById(R.id.matchHero);
            matchMode = itemView.findViewById(R.id.matchMode);
            matchEnd = itemView.findViewById(R.id.matchEnd);
            matchLength = itemView.findViewById(R.id.matchLength);
            matchKda = itemView.findViewById(R.id.matchKda);
            layout = itemView.findViewById(R.id.match_item);
        }
    }
}
