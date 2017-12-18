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
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentTop100.GamingSquareTop100Fragment;

public class GamingSquareTop100Data {

    RequestQueue gamingSquareTop100RequestQueue;
    GamingSquareTop100Fragment gamingSquareTop100Fragment;

    ArrayList<GamingSquareMainAllModel> gamingSquareMainAllModels = new ArrayList<GamingSquareMainAllModel>();

    public GamingSquareTop100Data(GamingSquareTop100Fragment gamingSquareTop100Fragment) {
        this.gamingSquareTop100Fragment = gamingSquareTop100Fragment;
        gamingSquareTop100RequestQueue = Volley.newRequestQueue(gamingSquareTop100Fragment.getContext());
        new GamingSquareTop100DataAsyncTask().execute();
    }

    public int getListSize() {
        return gamingSquareMainAllModels.size();
    }

    public GamingSquareMainAllModel getListItem(int position) {
        return gamingSquareMainAllModels.get(position);
    }

    private void gamingSquareGetTop100Data() {
        String url = "api/getgamingsquaretop100list";

        HashMap<String, String> gamingSquareMainListParams = new HashMap<String, String>();
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");
        gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_GAME_DATA_COUNT, "");

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
                                    gamingSquareMainAllModels.add(new GamingSquareMainAllModel(jo.getString("game_id"),
                                            jo.getString("game_name"), jo.getString("game_publisher"),
                                            jo.getInt("game_rating"), jo.getString("game_img_url")));
                                    gamingSquareTop100Fragment.gamingSquareAddMainListData();
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
                Toast.makeText(gamingSquareTop100Fragment.getActivity(), "Error Occured: " + arg0.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        gamingSquareTop100RequestQueue.add(reqobj);
    }

    public class GamingSquareTop100DataAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            gamingSquareGetTop100Data();
            return null;
        }
    }

}
