package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameExtraFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameInfoFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameOverviewFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameRatingFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameScreenshotsFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameStoryFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.R;

public class GamingSquareGameInfo extends AppCompatActivity {

    private String game_id, game_name;
    private GamingSquareHelper gamingSquareHelper;
    private Toolbar gameInfoToolbar;
    private CollapsingToolbarLayout gamingSquareInfoCollapsingToolbar;
    private TabLayout gamingSquareInfoTabs;
    private ViewPager gamingSquareInfoTabsPager;
    private ImageView gaming_square_info_main_img;
    private String url = "api/getgamingsquaregamenameimg";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_square_game_detail);
        gamingSquareHelper = new GamingSquareHelper();
        game_name = getIntent().getStringExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME);
        gaming_square_info_main_img = (ImageView) findViewById(R.id.gaming_square_info_main_img);

        gamingSquareInfoTabs = (TabLayout) findViewById(R.id.gaming_square_info_tabs);
        gamingSquareInfoTabsPager = (ViewPager) findViewById(R.id.gaming_square_info_tabs_pager);
        gamingSquareInfoTabsPager.setOffscreenPageLimit(6);

        gameInfoToolbar = (Toolbar) findViewById(R.id.gaming_square_info_toolbar);
        setSupportActionBar(gameInfoToolbar);

        gamingSquareInfoCollapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.gaming_square_info_collapsing_toolbar);

        gamingSquareInfoCollapsingToolbar.setTitle("Gaming Square");

        gamingSquareInfoCollapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // getGameDetailMainImg("prototype");

        setupViewPager(gamingSquareInfoTabsPager);
        gamingSquareInfoTabs.setupWithViewPager(gamingSquareInfoTabsPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new GamingSquareGameInfoFragment(), "INFO");
        viewPagerAdapter.addFragment(new GamingSquareGameOverviewFragment(), "OVERVIEW");
        viewPagerAdapter.addFragment(new GamingSquareGameRatingFragment(), "RATINGS");
        viewPagerAdapter.addFragment(new GamingSquareGameStoryFragment(), "STORY");
        viewPagerAdapter.addFragment(new GamingSquareGameExtraFragment(), "EXTRA");
        viewPagerAdapter.addFragment(new GamingSquareGameScreenshotsFragment(), "SCREENSHOTS");

        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mainMenuInflater = this.getMenuInflater();
        mainMenuInflater.inflate(R.menu.menu_detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        case android.R.id.home:
            Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show();
            onBackPressed();
            break;
        case R.id.games_share:
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello Gamers");
            shareIntent.setType("text/*");
            startActivity(Intent.createChooser(shareIntent, "Let The World See it..."));
            break;
        case R.id.games_search:
            Toast.makeText(this, "Games Search", Toast.LENGTH_SHORT).show();
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

    public void setGameDetailMainImg(String imgUrl) {
        Picasso.with(GamingSquareGameInfo.this)
                .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL + imgUrl)
                .placeholder(R.drawable.exclusives)
                .error(R.mipmap.ic_launcher)
                .fit()
                .into(gaming_square_info_main_img);
    }

    // public void getGameDetailMainImg(String game_id) {

    //     requestQueue = Volley.newRequestQueue(GamingSquareGameInfo.this);

    //     HashMap<String, String> gameNameImgParams = new HashMap<String, String>();

    //     gameNameImgParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);

    //     JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gameNameImgParams), new Response.Listener<JSONObject>() {
    //         @Override
    //         public void onResponse(JSONObject response) {
    //             try{
    //                 gamingSquareInfoCollapsingToolbar.setTitle(response.getString("game_name"));

    //                 Picasso.with(GamingSquareGameInfo.this)
    //                         .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+response.getString("game_img"))
    //                         .placeholder(R.drawable.exclusives)   // optional
    //                         .error(R.mipmap.ic_launcher)      // optional
    //                         .fit()                       // optional
    //                         //  .rotate(90)
    //                         .into(gaming_square_info_main_img);
    //             }
    //             catch(JSONException jsonException){
    //                 Toast.makeText(GamingSquareGameInfo.this, "JSON Exception : "+jsonException.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    //             }

    //         }
    //     },
    //             new Response.ErrorListener() {
    //                 @Override
    //                 public void onErrorResponse(VolleyError error) {
    //                     Toast.makeText(GamingSquareGameInfo.this, ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    //                 }
    //             }
    //     );

    //     requestQueue.add(jsonObjectRequest);
    // }
}