package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameStoryModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameStoryFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 17/05/2017.
 */

public class GamingSquareGameStoryVolleyData {

    RequestQueue requestQueue;

    String url = "api/getgamingsquaregameinfostory";

    String game_id;

    GamingSquareGameStoryFragment gamingSquareGameStoryFragment;

    public GamingSquareGameStoryVolleyData(String game_id,
            GamingSquareGameStoryFragment gamingSquareGameStoryFragment) {
        this.game_id = game_id;
        this.gamingSquareGameStoryFragment = gamingSquareGameStoryFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameStoryFragment.getContext());
        gamingSquareGetGameStory(game_id);

    }

    public void gamingSquareGetGameStory(String game_id) {

        HashMap<String, String> gamingSquareGameStoryParams = new HashMap<String, String>();
        gamingSquareGameStoryParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);
        gamingSquareGameStoryParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameStoryParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameStoryParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {

                        try {

                            if (Integer.parseInt(json.getString("status")) == 200) {
                                JSONObject jsonData = json.getJSONObject("data");

                                GamingSquareGameStoryModel gamingSquareGameStoryModel = new GamingSquareGameStoryModel(
                                        json.getString("story"));

                                gamingSquareGameStoryFragment
                                        .getGamingSquareGameStoryModelData(gamingSquareGameStoryModel);
                                gamingSquareGameStoryFragment.dismissProgressBar();
                            } else {
                                // HANDLE THE ERROR ACCORDINGLY
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        Toast.makeText(gamingSquareGameStoryFragment.getActivity(), "" + arg0.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(req);
    }
}
