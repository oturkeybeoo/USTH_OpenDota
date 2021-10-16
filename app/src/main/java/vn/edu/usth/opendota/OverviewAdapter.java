package vn.edu.usth.opendota;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OverviewAdapter extends FragmentStateAdapter {
    public OverviewAdapter(@NonNull MatchDetailsActivity fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            default:
                return new OverviewFragment();
            case 0:
                return new OverviewFragment();
            case 1:
                return new BenchmarkFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
