package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameDLCInfoModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameDLCInfoVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

public class GamingSquareGameDLCInfoActivity extends AppCompatActivity {

    GamingSquareGameDLCInfoVolleyData gamingSquareGameDLCInfoVolleyData;
    GamingSquareGameDLCInfoModel gamingSquareGameDLCInfoModel;

    TextView gaming_square_game_dlc_name, gaming_square_game_dlc_overview, gaming_square_game_dlc_story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_gaming_square_game_dlc_info);

        gaming_square_game_dlc_name = (TextView)findViewById(R.id.gaming_square_game_dlc_name);
        gaming_square_game_dlc_overview = (TextView)findViewById(R.id.gaming_square_game_dlc_overview);
        gaming_square_game_dlc_story = (TextView)findViewById(R.id.gaming_square_game_dlc_story);

        //gamingSquareGameDLCInfoVolleyData = new GamingSquareGameDLCInfoVolleyData("prototype", GamingSquareGameDLCInfoActivity.this);

    }

    public void getGamingSquareGameDLCInfoData(GamingSquareGameDLCInfoModel gamingSquareGameDLCInfoModel){
        this.gamingSquareGameDLCInfoModel = gamingSquareGameDLCInfoModel;
        this.gaming_square_game_dlc_name.setText(gamingSquareGameDLCInfoModel.getGame_dlc_name());
        this.gaming_square_game_dlc_overview.setText(gamingSquareGameDLCInfoModel.getGame_dlc_info());
        this.gaming_square_game_dlc_story.setText(gamingSquareGameDLCInfoModel.getGame_dlc_story());
    }

}
