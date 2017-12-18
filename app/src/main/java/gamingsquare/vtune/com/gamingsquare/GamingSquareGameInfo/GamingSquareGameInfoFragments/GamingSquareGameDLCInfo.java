package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameDLCInfoModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameDLCInfoVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 17/06/2017.
 */

public class GamingSquareGameDLCInfo extends BottomSheetDialogFragment {

    GamingSquareGameDLCInfoModel gamingSquareGameDLCInfoModel;
    GamingSquareGameDLCInfoVolleyData gamingSquareGameDLCInfoVolleyData;
    TextView gaming_square_game_dlc_name, gaming_square_game_dlc_overview, gaming_square_game_dlc_story;
    LinearLayout gaming_square_game_dlc_ratings;
    
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {

            if(newState == BottomSheetBehavior.STATE_HIDDEN){
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };

    public void setupDialog(Dialog dialog, int style){
        super.setupDialog(dialog,style);

        View view = View.inflate(getContext(), R.layout.bottom_sheet_gaming_square_game_dlc_info,null);
        gaming_square_game_dlc_name = (TextView)view.findViewById(R.id.gaming_square_game_dlc_name);
        gaming_square_game_dlc_overview = (TextView)view.findViewById(R.id.gaming_square_game_dlc_overview);
        gaming_square_game_dlc_story = (TextView)view.findViewById(R.id.gaming_square_game_dlc_story);
        gaming_square_game_dlc_ratings = (LinearLayout)view.findViewById(R.id.gaming_square_game_dlc_ratings);

        gamingSquareGameDLCInfoVolleyData = new GamingSquareGameDLCInfoVolleyData("prototype",GamingSquareGameDLCInfo.this);

        dialog.setContentView(view);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) ((View)view.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if( behavior != null && behavior instanceof BottomSheetBehavior ) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(bottomSheetCallback);
        }
    }

    public void getGamingSquareGameDLCInfoData(GamingSquareGameDLCInfoModel gamingSquareGameDLCInfoModel){
        this.gamingSquareGameDLCInfoModel = gamingSquareGameDLCInfoModel;
        this.gaming_square_game_dlc_name.setText(gamingSquareGameDLCInfoModel.getGame_dlc_name());
        Toast.makeText(this.getActivity(), "jhgjhgjhg"+gamingSquareGameDLCInfoModel.getGame_dlc_name(), Toast.LENGTH_LONG).show();
        this.gaming_square_game_dlc_overview.setText(gamingSquareGameDLCInfoModel.getGame_dlc_info());
        this.gaming_square_game_dlc_story.setText(gamingSquareGameDLCInfoModel.getGame_dlc_story());

        for(int i = 0; i< gamingSquareGameDLCInfoModel.getGame_dlc_ratings().length();i++){
            try{
                TextView textview1 = new TextView(getActivity());

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview1.setTextSize(16);
                textview1.setTextColor(Color.WHITE);
                textview1.setLayoutParams(params1);

                textview1.setText("" + gamingSquareGameDLCInfoModel.getGame_dlc_ratings().getJSONObject(i).getString("rating_dlc_name")+" : "+ gamingSquareGameDLCInfoModel.getGame_dlc_ratings().getJSONObject(i).getString("rating_dlc_value"));

                gaming_square_game_dlc_ratings.addView(textview1);
            }
            catch(JSONException e){

            }
        }

    }


}