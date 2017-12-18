package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData;

import android.widget.TextView;
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

import java.util.HashMap;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareExtraModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameExtraFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 07/06/2017.
 */

public class GamingSquareGameInfoExtraVolleyData {
    RequestQueue requestQueue;

    String url = "api/getgamingsquaregameinfoextra";

    String game_id;

    GamingSquareGameExtraFragment gamingSquareGameExtraFragment;

    public GamingSquareGameInfoExtraVolleyData(String game_id,
            GamingSquareGameExtraFragment gamingSquareGameExtraFragment) {
        this.game_id = game_id;
        this.gamingSquareGameExtraFragment = gamingSquareGameExtraFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameExtraFragment.getContext());
        gamingSquareGetGameExtra(game_id);

    }

    public void gamingSquareGetGameExtra(String game_id) {

        HashMap<String, String> gamingSquareGameOverviewParams = new HashMap<String, String>();
        gamingSquareGameOverviewParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameOverviewParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {

                        try {

                            if (Integer.parseInt(json.getString("status")) == 200) {
                                JSONObject jsonData = json.getJSONObject("data");

                                JSONObject jobj = jsonData.getJSONObject("extra");
                                JSONArray dlclist = jobj.getJSONArray("dlc");
                                JSONArray platformlist = jobj.getJSONArray("platforms");

                                GamingSquareExtraModel gamingSquareExtraModel = new GamingSquareExtraModel(dlclist,
                                        platformlist);

                                gamingSquareGameExtraFragment
                                        .getGamingSquareGameRatingModelData(gamingSquareExtraModel);
                                gamingSquareGameExtraFragment.dismissProgressBar();
                            } else {
                                // HANLDE THE ERROR ACCORDINGLY
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        Toast.makeText(gamingSquareGameExtraFragment.getActivity(), "" + arg0.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(req);
    }
}