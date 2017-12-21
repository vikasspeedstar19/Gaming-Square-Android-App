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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameDLCInfoModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments.GamingSquareGameDLCInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;

/**
 * Created by Vikas on 17/06/2017.
 */

public class GamingSquareGameDLCInfoVolleyData {
    RequestQueue requestQueue;
    String url = "api/getgamingsquaregamedlcinfo";
    String game_id;
    GamingSquareGameDLCInfo gamingSquareGameDLCInfo;

    public GamingSquareGameDLCInfoVolleyData(String game_id, GamingSquareGameDLCInfo gamingSquareGameDLCInfo) {
        this.game_id = game_id;
        this.gamingSquareGameDLCInfo = gamingSquareGameDLCInfo;
        requestQueue = Volley.newRequestQueue(gamingSquareGameDLCInfo.getContext());
        gamingSquareGetGameDLCInfo(game_id);
    }

    public void gamingSquareGetGameDLCInfo(String game_id) {
        HashMap<String, String> gamingSquareGameDLCInfoParams = new HashMap<String, String>();
        gamingSquareGameDLCInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_DLC_ID, game_id);
        gamingSquareGameDLCInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareGameDLCInfoParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareGameDLCInfoParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (Integer.parseInt(json.getString("status")) == 200) {
                                JSONObject jsonData = json.getJSONObject("data");
                                GamingSquareGameDLCInfoModel gamingSquareGameDLCInfoModel = new GamingSquareGameDLCInfoModel(
                                        jsonData.getString("game_dlc_id"), jsonData.getString("game_dlc_name"),
                                        jsonData.getString("dlc_overview"), jsonData.getString("dlc_story"),
                                        jsonData.getJSONArray("dlc_rating"));
                                gamingSquareGameDLCInfo.getGamingSquareGameDLCInfoData(gamingSquareGameDLCInfoModel);
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
                        Toast.makeText(gamingSquareGameDLCInfo.getActivity(),
                                "Error occured : " + arg0.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(req);
    }
}