package gamingsquare.vtune.com.gamingsquare.GamingSquareHome;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentExclusives.GamingSquareExclusivesAll;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentTop100.GamingSquareTop100Fragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentYoutubers.GamingSquareYoutubersFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentsAll.Main_List_Home;
import gamingsquare.vtune.com.gamingsquare.HomeFragmentGamesSearch.GamingSquareGamesSearch;
import gamingsquare.vtune.com.gamingsquare.R;

public class GamingSquareHome extends AppCompatActivity {

    private Toolbar main_list_toolbar;
    private DrawerLayout main_list_drawer_layout;
    private NavigationView main_list_nav_view;
    private ActionBarDrawerToggle main_list_actionBarDrawerToggle;
    private boolean onFirstLaunch = false;
    private GamingSquareHelper gamingSquareHelper;
    private SearchView gamesSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_square_home);

        main_list_toolbar = (Toolbar) findViewById(R.id.main_list_toolbar);
        setSupportActionBar(main_list_toolbar);
        main_list_drawer_layout = (DrawerLayout) findViewById(R.id.main_list_drawer_layout);
        main_list_nav_view = (NavigationView) findViewById(R.id.main_drawer_nav_view);

        gamingSquareHelper = new GamingSquareHelper();

        setSupportActionBar(main_list_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        main_list_actionBarDrawerToggle = new ActionBarDrawerToggle(this, main_list_drawer_layout, R.string.string_open, R.string.string_close);
        main_list_drawer_layout.addDrawerListener(main_list_actionBarDrawerToggle);
        main_list_actionBarDrawerToggle.syncState();

        final Main_List_Home main_list_fragment = new Main_List_Home();
        mainListFragmentTransaction(R.id.main_list_frame, main_list_fragment, gamingSquareHelper.GAMING_SQAURE_ALL_FRAGMENT);
        main_list_nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);

                switch (item.getTitle().toString()) {
                    case "Home":
                        Main_List_Home main_list_home = new Main_List_Home();
                        mainListFragmentTransaction(R.id.main_list_frame, main_list_home, gamingSquareHelper.GAMING_SQAURE_ALL_FRAGMENT);
                        break;
                    case "Top 100":
                        GamingSquareTop100Fragment gamingSquare_list_top_100 = new GamingSquareTop100Fragment();
                        mainListFragmentTransaction(R.id.main_list_frame, gamingSquare_list_top_100, gamingSquareHelper.GAMING_SQAURE_TOP_FRAGMENT);
                        break;
                    case "Exclusives":
                        GamingSquareExclusivesAll gamingSquareExclusivesAll = new GamingSquareExclusivesAll();
                        mainListFragmentTransaction(R.id.main_list_frame, gamingSquareExclusivesAll, gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_FRAGMENT);
                        break;
                    case "Youtubers":
                        GamingSquareYoutubersFragment gamingSquareYoutubersFragment = new GamingSquareYoutubersFragment();
                        mainListFragmentTransaction(R.id.main_list_frame, gamingSquareYoutubersFragment, gamingSquareHelper.GAMING_SQAURE_YOUTUBERS_FRAGMENT);
                        break;
                }
                main_list_drawer_layout.closeDrawers();
                return true;
            }
        });

        Intent intent = getIntent();
        Uri game_id = intent.getData();

        if (game_id != null) {
            if (game_id.getQueryParameter("game_id") != null) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "The data is : " + game_id, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void mainListFragmentTransaction(int containerViewId, Fragment fragment, String tagName) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.add(containerViewId, fragment,tagName);
        if (onFirstLaunch == true) {
            fragmentTransaction.addToBackStack(null);
            //Toast.makeText(this, ""+getSupportFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
        }
        onFirstLaunch = true;
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();

//        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//
//        } else {
//            super.onBackPressed();
//        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {

            // TODO Auto-generated method stub
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // builder.setCancelable(false);
            builder.setTitle("We have so much game info!");
            builder.setMessage("Do you really wannna go?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    //Toast.makeText(this, "Yes i wanna exit", Toast.LENGTH_LONG).show();

                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    //Toast.makeText(mContext, "i wanna stay on this page", Toast.LENGTH_LONG).show();
                    dialog.cancel();

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            //super.onBackPressed()
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this, "conf changed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mainMenuInflater = this.getMenuInflater();
        mainMenuInflater.inflate(R.menu.menu, menu);


//        gamesSearchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (main_list_actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.games_search:
                Toast.makeText(this, "Games Search", Toast.LENGTH_SHORT).show();
                GamingSquareHome.this.startActivity(new Intent(GamingSquareHome.this, GamingSquareGamesSearch.class));
                break;
            case R.id.option1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.option3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.option4:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}