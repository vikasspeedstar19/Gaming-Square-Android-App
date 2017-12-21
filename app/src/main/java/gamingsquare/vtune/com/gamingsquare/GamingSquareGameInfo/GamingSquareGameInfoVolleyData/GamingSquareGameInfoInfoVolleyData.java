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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGamingInfoModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameInfoFragment;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 15/05/2017.
 */

public class GamingSquareGameInfoInfoVolleyData {

    RequestQueue requestQueue;

    String url = "api/getgamingsquaregameinfoinfo";

    String game_id;

    GamingSquareGameInfoFragment gamingSquareGameInfoFragment;

    public GamingSquareGameInfoInfoVolleyData(String game_id,
            GamingSquareGameInfoFragment gamingSquareGameInfoFragment) {
        this.game_id = game_id;
        this.gamingSquareGameInfoFragment = gamingSquareGameInfoFragment;
        requestQueue = Volley.newRequestQueue(gamingSquareGameInfoFragment.getContext());
        gamingSquareGetGameInfo(game_id);

    }

    public void gamingSquareGetGameInfo(String game_id) {
        HashMap<String, String> gamingSquareGameInfoParams = new HashMap<String, String>();
        gamingSquareGameInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_GAMES_ID, game_id);
        gamingSquareGameInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameInfoParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            Toast.makeText(gamingSquareGameInfoFragment.getActivity(), "Data is"+json, Toast.LENGTH_SHORT).show();
                            if (Integer.parseInt(json.getString("status")) == 200) {

                                JSONObject jsonData = json.getJSONObject("data");

                                JSONObject jsonObject = jsonData.getJSONObject("game_info");
                                GamingSquareGamingInfoModel gamingSquareGamingInfoModel = new GamingSquareGamingInfoModel(
                                        jsonObject.getString("game_img"), jsonObject.getJSONArray("developer"),
                                        jsonObject.getJSONArray("game_modes"), jsonObject.getJSONArray("genre"),
                                        jsonObject.getJSONArray("player_view"), jsonObject.getJSONArray("publisher"),
                                        jsonObject.getJSONArray("release_dates"));
                                gamingSquareGameInfoFragment
                                        .getGamingSquareGameInfoModelData(gamingSquareGamingInfoModel);
                                gamingSquareGameInfoFragment.dismissProgressBar();
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
                        Toast.makeText(gamingSquareGameInfoFragment.getActivity(), "" + arg0.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(req);
    }
}