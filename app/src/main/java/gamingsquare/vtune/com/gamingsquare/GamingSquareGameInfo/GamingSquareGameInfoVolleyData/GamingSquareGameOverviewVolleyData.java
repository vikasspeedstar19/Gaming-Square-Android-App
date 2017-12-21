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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameOverviewModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameOverviewFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 17/05/2017.
 */

public class GamingSquareGameOverviewVolleyData {

    RequestQueue requestQueue;

    String url = "api/getgamingsquaregameinfooverview";

    String game_id;

    GamingSquareGameOverviewFragment gamingSquareGameOverviewFragment;

    public GamingSquareGameOverviewVolleyData(String game_id,
            GamingSquareGameOverviewFragment gamingSquareGameOverviewFragment) {
        this.game_id = game_id;
        this.gamingSquareGameOverviewFragment = gamingSquareGameOverviewFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameOverviewFragment.getContext());
        gamingSquareGetGameOverview(game_id);

    }

    public void gamingSquareGetGameOverview(String game_id) {

        HashMap<String, String> gamingSquareGameOverviewParams = new HashMap<String, String>();
        gamingSquareGameOverviewParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);
        gamingSquareGameOverviewParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameOverviewParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameOverviewParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {

                        try {

                            if (Integer.parseInt(json.getString("status")) == 200) {

                                JSONObject jsonData = json.getJSONObject("data");

                                GamingSquareGameOverviewModel gamingSquareGameOverviewModel = new GamingSquareGameOverviewModel(
                                        jsonData.getString("overview"));
                                gamingSquareGameOverviewFragment
                                        .getGamingSquareGameOverviewModelData(gamingSquareGameOverviewModel);
                                gamingSquareGameOverviewFragment.dismissProgressBar();
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
                        Toast.makeText(gamingSquareGameOverviewFragment.getActivity(), "" + arg0.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(req);
    }

}
