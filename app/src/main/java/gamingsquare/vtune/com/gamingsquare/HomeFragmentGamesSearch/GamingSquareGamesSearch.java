package gamingsquare.vtune.com.gamingsquare.HomeFragmentGamesSearch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class GamingSquareGamesSearch extends AppCompatActivity {

    private Toolbar search_list_toolbar;
    private ListView searchGamesList;
    private EditText enterGameNameForSearch;
    private TextView noGamesFoundGamesSearch;
    ArrayAdapter<GamingSquareGamesSearchModel> adapter;

    private GamingSquareGamesSearchVolleyData gamingSquareGamesSearchVolleyData;
    ArrayList<GamingSquareGamesSearchModel> gamesList = new ArrayList<GamingSquareGamesSearchModel>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_square_games_search);

        enterGameNameForSearch = (EditText) findViewById(R.id.enterGameNameForSearch);
        searchGamesList = (ListView) findViewById(R.id.gamingSquareGamesSearchList);

        noGamesFoundGamesSearch = (TextView) findViewById(R.id.noGamesFoundGamesSearch);

        search_list_toolbar = (Toolbar) findViewById(R.id.main_list_toolbar);
        setSupportActionBar(search_list_toolbar);

        setSupportActionBar(search_list_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        searchGamesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String msg = gamesList.get(position).getGame_id();
                Intent intent = new Intent(GamingSquareGamesSearch.this, GamingSquareGameInfo.class);
                intent.putExtra(new GamingSquareHelper().GAMING_SQAURE_GAME_INFO_GAME_ID, msg);
                startActivity(intent);
                finish();
                Toast.makeText(GamingSquareGamesSearch.this, "" + gamesList.get(position).game_id, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        enterGameNameForSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (gamesList.size() != 0) {
                    gamesList.clear();
                }
                gamingSquareGamesSearchVolleyData = new GamingSquareGamesSearchVolleyData(GamingSquareGamesSearch.this,
                        "" + s);
            }
        });
    }

    public void searchGamesAddGameList(String game_id, String game_name) {
        gamesList.add(new GamingSquareGamesSearchModel(game_id, game_name));
    }

    public void searchGamesListAdd(boolean toAdd) {
        if (toAdd) {
            searchGamesList.setVisibility(View.VISIBLE);
            noGamesFoundGamesSearch.setVisibility(View.GONE);
            adapter = new ArrayAdapter<GamingSquareGamesSearchModel>(GamingSquareGamesSearch.this,
                    android.R.layout.simple_list_item_1, gamesList);
            searchGamesList.setAdapter(adapter);
        } else {
            // Here set the visibility of 'noGamesFoundGamesSearch' textField to true and 'searchGamesList' to false
            searchGamesList.setVisibility(View.GONE);
            noGamesFoundGamesSearch.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        case android.R.id.home: onBackPressed();
            break;
        }
        return true;
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(enterGameNameForSearch.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        hideKeyboard();
        super.onBackPressed();
    }
}