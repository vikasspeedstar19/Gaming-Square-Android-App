package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData;

import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareDataModel.GamingSquareMainAllModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentExclusives.GamingSquareExclusivesXBOXFragment;

/**
 * Created by Vikas on 04/03/2017.
 */

public class GamingSquareExclusivesXBOXData {

    RequestQueue gamingSquareExclusivesXBOXRequestQueue;
    GamingSquareExclusivesXBOXFragment gamingSquareExclusivesXBOXFragment;

    public GamingSquareExclusivesXBOXData(GamingSquareExclusivesXBOXFragment gamingSquareExclusivesXBOXFragment) {
        this.gamingSquareExclusivesXBOXFragment = gamingSquareExclusivesXBOXFragment;
        gamingSquareExclusivesXBOXRequestQueue = Volley
                .newRequestQueue(gamingSquareExclusivesXBOXFragment.getContext());
        new GamingSquareExclusivesXBOXDataAsyncTask().execute();
    }

    ArrayList<GamingSquareMainAllModel> gamingSquareMainAllModels = new ArrayList<GamingSquareMainAllModel>();

    public int getListSize() {
        return gamingSquareMainAllModels.size();
    }

    public GamingSquareMainAllModel getListItem(int position) {
        return gamingSquareMainAllModels.get(position);
    }

    private void gamingSquareGetExclusiveXBOXData() {
        String url = "api/getgamingsquareexclusivexboxlist";

        HashMap<String, String> gamingSquareMainListParams = new HashMap<String, String>();
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_LAST_GAME_ID, "" /*GIVE THIS BLANK FOR NOW*/);
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        JsonObjectRequest reqobj = new JsonObjectRequest(Request.Method.POST,
                new GamingSquareHelper().GAMING_SQAURE_BASE_URL + url, new JSONObject(gamingSquareMainListParams),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (Integer.parseInt(json.getString("status")) == 200) {
                                JSONArray data = json.getJSONArray("data");
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject jo = data.getJSONObject(i);
                                    gamingSquareMainAllModels.add(new GamingSquareMainAllModel(
                                                    jo.getString("game_id")
                                                    , jo.getString("game_name")
                                                    , jo.getString("game_publisher")
                                                    , jo.getInt("game_rating"),
                                                    jo.getString("game_img_url")
                                            )
                                    );
                                    gamingSquareExclusivesXBOXFragment.gamingSquareAddExclusiveXBOXListData();
                                }
                            } else {
                                // Handle the error accordingly
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
                Toast.makeText(gamingSquareExclusivesXBOXFragment.getActivity(), "" + arg0.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        gamingSquareExclusivesXBOXRequestQueue.add(reqobj);
    }

    public class GamingSquareExclusivesXBOXDataAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            gamingSquareGetExclusiveXBOXData();
            return null;
        }
    }

}
