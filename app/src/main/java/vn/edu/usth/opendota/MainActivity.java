package vn.edu.usth.opendota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_HOME = 0;

    private int mCurrentFragment = FRAGMENT_HOME;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer_navigation, R.string.close_drawer_navigation);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navgation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder_fragment,
                        new HomeFragment()).commit();
                break;
            case R.id.heroes:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder_fragment,
                        new HeroOverviewFragment()).commit();
                break;
//            case R.id.search:
//                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder_fragment,
//                        new SearchActivity()).commit();
//                break;

        }
//        int id = item.getItemId();
//        if (id == R.id.home) {
//            if (mCurrentFragment != FRAGMENT_HOME) {
//
//
//            }
//
//        } else if (id == R.id.heroes) {
//
//        } else if (id == R.id.search) {
//
//        } else if (id == R.id.settings) {
//
//        } else if (id == R.id.logout) {
//
//        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.placeholder_fragment, fragment);
        fragmentTransaction.commit();
    }
}