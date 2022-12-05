package com.letsdowebsite.mydelhi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.letsdowebsite.mydelhi.Fragment.*;
import com.letsdowebsite.mydelhi.Fragment.PoliceFragment;

public class dashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment = null;
    private TextView tvTitle;
    private ViewPager viewPager;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        tvTitle=(TextView)findViewById(R.id.tvTitle);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = new FeedFragment();
        fragmentReplace(fragment);
        navigationView.setItemIconTintList(null);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(this, "Press once again to exit!", Toast.LENGTH_SHORT).show();
            }
            back_pressed = System.currentTimeMillis();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Feed) {
            fragment = new FeedFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Feed");
            // Handle the camera action
        } else if (id == R.id.nav_Fort) {
            fragment = new FortFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Fort");

        } else if (id == R.id.nav_Temple) {
            fragment = new TempleFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Temple");


        } else if (id == R.id.nav_park) {
            fragment = new ParkFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Park");
        } else if (id == R.id.nav_Delhimetro) {
            fragment = new MetroFragment();
            fragmentReplace( fragment );
            tvTitle.setText("Delhi Metro");
        }
            else if (id == R.id.nav_Delhi_transport) {
                fragment = new DicFragment();
                fragmentReplace( fragment );
            tvTitle.setText("Delhi Transport");

        } else if (id == R.id.nav_PoliceStation) {
            fragment = new PoliceFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Police Station");

        } else if (id == R.id.nav_Fire) {
            fragment = new FireFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Fire");

        } else if (id == R.id.nav_Hospital) {
            fragment = new HospitalFragment();
            fragmentReplace(fragment);
            tvTitle.setText("Hospital");

        }else if (id == R.id.nav_listMetro) {
                fragment = new ListFragment();
                fragmentReplace( fragment );
            tvTitle.setText("List Metro");
            }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }


    public void fragmentReplace(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }
}
