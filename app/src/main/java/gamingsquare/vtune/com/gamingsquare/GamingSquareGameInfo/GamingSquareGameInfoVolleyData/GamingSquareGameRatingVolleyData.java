package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData;

import android.os.AsyncTask;
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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameRatingModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameRatingFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 17/05/2017.
 */

public class GamingSquareGameRatingVolleyData {
    String url = "api/getgamingsquaregameinforatings";

    String game_id;

    RequestQueue requestQueue;
    GamingSquareGameRatingFragment gamingSquareGameRatingFragment;

    public GamingSquareGameRatingVolleyData(String game_id,
            GamingSquareGameRatingFragment gamingSquareGameRatingFragment) {
        this.game_id = game_id;
        this.gamingSquareGameRatingFragment = gamingSquareGameRatingFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameRatingFragment.getContext());
        new GamingSquareGameRatingVolleyDataAsyncTask().execute();
    }

    ArrayList<GamingSquareGameRatingModel> gamingSquareGameRatingModels = new ArrayList<GamingSquareGameRatingModel>();

    public int getListSize() {
        return gamingSquareGameRatingModels.size();
    }

    public GamingSquareGameRatingModel getListItem(int position) {
        return gamingSquareGameRatingModels.get(position);
    }

    private void gamingSquareGetGameRating(String game_id) {

        HashMap<String, String> gamingSquareGameRatingsParams = new HashMap<String, String>();
        gamingSquareGameRatingsParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);
        gamingSquareGameRatingsParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameRatingsParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameRatingsParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (Integer.parseInt(json.getString("status")) == 200) {

                                JSONObject jsonData = json.getJSONObject("data");

                                JSONArray jsonArray = jsonData.getJSONArray("ratings");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jo = jsonArray.getJSONObject(i);
                                    gamingSquareGameRatingModels.add(new GamingSquareGameRatingModel(
                                            jo.getString("rating_name"), jo.getInt("rating_value")));
                                    gamingSquareGameRatingFragment.gamingSquareAddRatingsData();
                                }

                                gamingSquareGameRatingFragment.dismissProgressBar();
                            } else {
                                // HANDLE THE ERROR ACCORDINGLY
                            }

                        } catch (JSONException e) {
                            Toast.makeText(gamingSquareGameRatingFragment.getActivity(), "Exception Occured",
                                    Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        //gamingSquareExclusivesPCFragment.dismissProgressBar();
                        Toast.makeText(gamingSquareGameRatingFragment.getActivity(), "Error Occured " + arg0,
                                Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(req);
    }

    public class GamingSquareGameRatingVolleyDataAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            gamingSquareGetGameRating(game_id);
            return null;
        }
    }

}