package gamingsquare.vtune.com.gamingsquare.HomeFragmentGamesSearch;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 04/05/2017.
 */

public class GamingSquareGamesSearchVolleyData {

    RequestQueue gamingSquareMainDataRequestQueue;
    GamingSquareGamesSearch gamingSquareGamesSearch;
    GamingSquareHelper gamingSquareHelper = new GamingSquareHelper();
    String searchGameName;
    String url = "api/getgamingsquaregamesearchlist";
    JSONArray jsonArray = new JSONArray();
    HashMap<String, String> gamingSearchParameters = new HashMap<String, String>();
    JSONObject obj;
    JSONArray array;

    public GamingSquareGamesSearchVolleyData(GamingSquareGamesSearch gamingSquareGamesSearch, String searchGameName) {
        this.gamingSquareGamesSearch = gamingSquareGamesSearch;
        gamingSquareMainDataRequestQueue = Volley.newRequestQueue(gamingSquareGamesSearch);
        this.searchGameName = searchGameName;
        gamingSquareGetSearchData();
    }

    public ArrayList<GamingSquareGamesSearchModel> gamingSquareGamesSearchModels = new ArrayList<GamingSquareGamesSearchModel>();

    public GamingSquareGamesSearchModel getSearchData(int position) {
        return gamingSquareGamesSearchModels.get(position);
    }

    public int gamesSearchDataSize() {
        return gamingSquareGamesSearchModels.size();
    }

    public void gamingSquareGetSearchData() {
        gamingSearchParameters.put(gamingSquareHelper.GAMING_SQUARE_GAMES_SEARCH, searchGameName);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSearchParameters),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (Integer.parseInt(json.getString("status")) == 200) {
                                JSONObject jsonData = json.getJSONObject("data");
                                JSONArray jsonArray = jsonData.getJSONArray("search_results");
                                if (jsonArray.length() == 0) {
                                    gamingSquareGamesSearch.searchGamesListAdd(false);
                                } else {
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jo = jsonArray.getJSONObject(i);
                                        gamingSquareGamesSearch.searchGamesAddGameList(jo.getString("game_id"),
                                                jo.getString("game_name"));
                                    }
                                    gamingSquareGamesSearch.searchGamesListAdd(true);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        Toast.makeText(gamingSquareGamesSearch, "Error", Toast.LENGTH_SHORT).show();
                        Toast.makeText(gamingSquareGamesSearch, "" + arg0.getLocalizedMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        gamingSquareMainDataRequestQueue.add(req);

    }
}
