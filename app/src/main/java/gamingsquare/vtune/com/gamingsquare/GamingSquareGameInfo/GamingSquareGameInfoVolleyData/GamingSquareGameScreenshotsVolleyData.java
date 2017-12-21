package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData;

import android.os.AsyncTask;
import android.util.Log;
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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameScreenshotsModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameScreenshotsFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 17/05/2017.
 */

public class GamingSquareGameScreenshotsVolleyData {
    String url = "api/getgamingsquaregameinfoscreenshots";

    String game_id;

    RequestQueue requestQueue;
    GamingSquareGameScreenshotsFragment gamingSquareGameScreenshotsFragment;

    public GamingSquareGameScreenshotsVolleyData(String game_id,
            GamingSquareGameScreenshotsFragment gamingSquareGameScreenshotsFragment) {
        this.game_id = game_id;
        this.gamingSquareGameScreenshotsFragment = gamingSquareGameScreenshotsFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameScreenshotsFragment.getContext());
        new GamingSquareGameScreenshotsVolleyDataAsyncTask().execute();
    }

    ArrayList<GamingSquareGameScreenshotsModel> gamingSquareGameScreenshotsModels = new ArrayList<GamingSquareGameScreenshotsModel>();
    ArrayList<String> gamingSquareGameScreenshotView = new ArrayList<String>();

    public int getListSize() {
        return gamingSquareGameScreenshotsModels.size();
    }

    public GamingSquareGameScreenshotsModel getListItem(int position) {
        return gamingSquareGameScreenshotsModels.get(position);
    }

    public ArrayList getGameScreenshots() {
        return gamingSquareGameScreenshotView;
    }

    private void gamingSquareGetGameScreenshots(String game_id) {
        HashMap<String, String> gamingSquareGameScreenshotsParams = new HashMap<String, String>();
        gamingSquareGameScreenshotsParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);
        gamingSquareGameScreenshotsParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameScreenshotsParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");


        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url,
                new JSONObject(gamingSquareGameScreenshotsParams), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (Integer.parseInt(json.getString("status")) == 200) {

                                JSONObject jsonData = json.getJSONObject("data");

                                JSONArray jsonArray = jsonData.getJSONArray("screenshots");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    gamingSquareGameScreenshotsModels
                                            .add(new GamingSquareGameScreenshotsModel(jsonArray.get(i).toString()));
                                    gamingSquareGameScreenshotView
                                            .add(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL
                                                    + jsonArray.get(i).toString());
                                    gamingSquareGameScreenshotsFragment.gamingSquareAddScreenshotsData();
                                }
                                gamingSquareGameScreenshotsFragment.dismissProgressBar();
                            } else {
                                // HANDLE THE ERROR ACCORDINGLY
                            }

                        } catch (JSONException e) {
                            Toast.makeText(gamingSquareGameScreenshotsFragment.getActivity(), "Exception Occured",
                                    Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        //gamingSquareExclusivesPCFragment.dismissProgressBar();
                        Toast.makeText(gamingSquareGameScreenshotsFragment.getActivity(), "Error Occured " + arg0,
                                Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(req);
    }

    public class GamingSquareGameScreenshotsVolleyDataAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            gamingSquareGetGameScreenshots(game_id);
            return null;
        }
    }

}