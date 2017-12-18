package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareExtraModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameRatingDLCModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameInfoExtraVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

import static gamingsquare.vtune.com.gamingsquare.R.id.gaming_square_game_rating_progress_layout;

/**
 * Created by Vikas on 18/03/2017.
 */

public class GamingSquareGameExtraFragment extends Fragment {
    View view;
    ImageView gamingSquareGameExtraHasPC,gamingSquareGameExtraHasPS, gamingSquareGameExtraHasXBOX;
    ListView gamingSquareGameExtraDLCList;
    TextView isContainDLCInExtra;
    GamingSquareExtraModel gamingSquareExtraModel;
    GamingSquareGameInfoExtraVolleyData gamingSquareGameInfoExtraVolleyData;
    JSONArray dlclist, platformlist;
    ArrayList<GamingSquareGameRatingDLCModel> dlclistArrayList;
    LinearLayout dlclistlinearlayout, gaming_square_game_extra_progress_layout;
    SimpleArcDialog mDialog;

    ArrayAdapter<GamingSquareGameRatingDLCModel> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_extra,container,false);

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);

        gamingSquareGameExtraHasPC = (ImageView)view.findViewById(R.id.gamingSquareGameExtraHasPC);
        gamingSquareGameExtraHasPS = (ImageView)view.findViewById(R.id.gamingSquareGameExtraHasPS);
        gamingSquareGameExtraHasXBOX = (ImageView)view.findViewById(R.id.gamingSquareGameExtraHasXBOX);
        gamingSquareGameExtraDLCList = (ListView)view.findViewById(R.id.gamingSquareGameExtraDLCList);
        dlclistlinearlayout = (LinearLayout)view.findViewById(R.id.dlclistlinearlayout);
        gaming_square_game_extra_progress_layout = (LinearLayout)view.findViewById(R.id.gaming_square_game_extra_progress_layout);
        gamingSquareGameInfoExtraVolleyData = new GamingSquareGameInfoExtraVolleyData("prototype",GamingSquareGameExtraFragment.this);

        return view;
    }

    public void getGamingSquareGameRatingModelData(GamingSquareExtraModel gamingSquareExtraModel){
        this.gamingSquareExtraModel = gamingSquareExtraModel;

        dlclist = this.gamingSquareExtraModel.getDlclist();

        platformlist = this.gamingSquareExtraModel.getPlatformlist();
        if(dlclist.length()==0){
            dlclistlinearlayout.setVisibility(View.GONE);
        }
        else{
            dlclistArrayList = new ArrayList<GamingSquareGameRatingDLCModel>();
            try{
                for(int i = 0;i<dlclist.length();i++){
                    JSONObject jsonObject = dlclist.getJSONObject(i);
                    dlclistArrayList.add(new GamingSquareGameRatingDLCModel(jsonObject.getString("game_dlc_id"),jsonObject.getString("game_dlc_name")));
                }
                if(dlclist.length()==0){
                    isContainDLCInExtra.setVisibility(LinearLayout.GONE);
                }

                arrayAdapter = new ArrayAdapter<GamingSquareGameRatingDLCModel>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, dlclistArrayList);
                gamingSquareGameExtraDLCList.setAdapter(arrayAdapter);

                gamingSquareGameExtraDLCList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String msg = dlclistArrayList.get(position).getDlcid();
                        GamingSquareGameDLCInfo gamingSquareGameDLCInfo = new GamingSquareGameDLCInfo();
                        gamingSquareGameDLCInfo.show(getActivity().getSupportFragmentManager(),gamingSquareGameDLCInfo.getTag());

                       // startActivity(new Intent(getActivity(),GamingSquareGameDLCInfoActivity.class));

                    }
                });
                gaming_square_game_extra_progress_layout.setVisibility(LinearLayout.GONE);
            }
            catch(JSONException jsonException){
                Toast.makeText(getActivity(), "Error is : "+jsonException.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

}
