package vn.edu.usth.opendota.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.MainActivity;
import vn.edu.usth.opendota.MatchDetailsActivity;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.model.SearchUser;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.UserViewHolder> implements Filterable {

    private Context context;
    private List<SearchUser> mListUsers;
    private List<SearchUser> mListUsersAll;

    public SearchAdapter(List<SearchUser> mListUsers, Context context) {
        this.context = context;
        this.mListUsers = mListUsers;
        this.mListUsersAll = mListUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_result, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SearchUser user = mListUsers.get(position);
        if (user == null) {
            return;
        }

        holder.user_avatar.setImageResource(user.getAvatar());
        holder.user_name.setText(user.getName());
        holder.user_id.setText(user.getId().toString());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("player_id", user.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String search_string = charSequence.toString();
                if (search_string.isEmpty()) {
                    mListUsers = mListUsersAll;
                } else {
                    List<SearchUser> list = new ArrayList<>();
                    for (SearchUser user : mListUsersAll) {
                        if (user.getName().toLowerCase().contains(search_string.toLowerCase())) {
                            list.add(user);
                        }
                    }
                    mListUsers = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListUsers;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListUsers = (List<SearchUser>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        if (mListUsers != null) {
            return mListUsers.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView user_avatar;
        private TextView user_name;
        private TextView user_id;
        private RelativeLayout layout;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            user_avatar = itemView.findViewById(R.id.user_avatar);
            user_name = itemView.findViewById(R.id.user_name);
            user_id = itemView.findViewById(R.id.user_id);
            layout = itemView.findViewById(R.id.search_layout);
        }
    }
}
