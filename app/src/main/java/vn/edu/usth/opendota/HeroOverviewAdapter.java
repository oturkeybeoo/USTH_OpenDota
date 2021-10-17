package vn.edu.usth.opendota;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HeroOverviewAdapter extends FragmentStateAdapter {
    public HeroOverviewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            default:
                return new HeroRankedFragment();
            case 0:
                return new HeroRankedFragment();
            case 1:
                return new HeroPubFragment();
            case 2:
                return new HeroTurboFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
