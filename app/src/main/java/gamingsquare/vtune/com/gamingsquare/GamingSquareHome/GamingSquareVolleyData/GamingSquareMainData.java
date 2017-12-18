package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData;

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

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareDataModel.GamingSquareMainAllModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentsAll.Main_List_Home;

/**
 * Created by Vikas on 01/03/2017.
 */

public class GamingSquareMainData {
    RequestQueue gamingSquareMainDataRequestQueue;
    Main_List_Home main_list_home;

    public GamingSquareMainData(Main_List_Home main_list_home) {
        this.main_list_home = main_list_home;
        gamingSquareMainDataRequestQueue = Volley.newRequestQueue(main_list_home.getContext());
        new GamingSquareMainDataAsyncTask().execute();
    }

    ArrayList<GamingSquareMainAllModel> gamingSquareMainAllModels = new ArrayList<GamingSquareMainAllModel>();

    public int getListSize() {
        return gamingSquareMainAllModels.size();
    }

    public GamingSquareMainAllModel getListItem(int position) {
        return gamingSquareMainAllModels.get(position);
    }

    private void gamingSquareGetMainData() {
        String url = "api/getgamingsquaremainsortedlist";

         HashMap<String, String> gamingSquareMainListParams = new HashMap<String, String>();
         gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_LAST_GAME_ID,"" /*GIVE THIS BLANK FOR NOW*/ );
         gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_VERSION_ID, "1.0");
         gamingSquareMainListParams.put(new GamingSquareHelper().GAMING_SQUARE_EXTRA_PARAM, "1");

        Log.d("HashMap is",""+gamingSquareMainListParams);

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
                                     main_list_home.gamingSquareAddMainListData();
                                 }
                             } else {
                                 // Handle the error accordingly
                             }
                         } catch (JSONException e) {
                             Toast.makeText(main_list_home.getActivity(), "Error Occured", Toast.LENGTH_SHORT).show();
                             e.printStackTrace();
                         }
                     }
                 }, new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError arg0) {

                         main_list_home.dismissProgressBar();
                        Toast.makeText(main_list_home.getActivity(), "Error Occured Hum First " + arg0, Toast.LENGTH_LONG).show();
                     }
                 });
        gamingSquareMainDataRequestQueue.add(reqobj);
    }

    public class GamingSquareMainDataAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            gamingSquareGetMainData();
            return null;
        }
    }

}