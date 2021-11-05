package vn.edu.usth.opendota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    Context context;
    ArrayList<Match> listMatch;

    public MatchAdapter(Context context, ArrayList<Match> listMatch) {
        this.context = context;
        this.listMatch = listMatch;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(context).inflate(R.layout.match_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán dữ liêuk
        Match match = listMatch.get(position);
        holder.matchHero.setImageResource(match.getHero());
        holder.matchMode.setText(match.getMode());
        holder.matchLength.setText(match.getLength());
        holder.matchEnd.setText(match.getEnded());
        holder.matchKda.setText(match.getKda());
    }

    @Override
    public int getItemCount() {
        return listMatch.size(); // trả item tại vị trí postion
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView matchHero;
        TextView matchMode, matchLength, matchEnd, matchKda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            matchHero = itemView.findViewById(R.id.matchHero);
            matchMode = itemView.findViewById(R.id.matchMode);
            matchEnd = itemView.findViewById(R.id.matchEnd);
            matchLength = itemView.findViewById(R.id.matchLength);
            matchKda = itemView.findViewById(R.id.matchKda);

        }
    }
}
