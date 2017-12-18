package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameOverviewModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameOverviewVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 18/03/2017.
 */

public class GamingSquareGameOverviewFragment extends Fragment {

	View view;
    private SimpleArcDialog mDialog;
	GamingSquareGameOverviewModel gamingSquareGameOverviewModel;
    GamingSquareGameOverviewVolleyData gamingSquareGameOverviewVolleyData;
    LinearLayout gaming_square_game_overview_progress_layout;
	TextView gamingSquareGameInfoOverview;

	String gameOverview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_overview,container,false);

        gaming_square_game_overview_progress_layout = (LinearLayout)view.findViewById(R.id.gaming_square_game_overview_progress_layout);

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
//        mDialog.show();

        gamingSquareGameOverviewVolleyData = new GamingSquareGameOverviewVolleyData("prototype", GamingSquareGameOverviewFragment.this);

        return view;
    }

    public void getGamingSquareGameOverviewModelData(GamingSquareGameOverviewModel gamingSquareGameOverviewModel){
        this.gamingSquareGameOverviewModel = gamingSquareGameOverviewModel;

        gamingSquareGameInfoOverview = (TextView)view.findViewById(R.id.gamingSquareGameInfoOverview);
        
        gameOverview = gamingSquareGameOverviewModel.getGameOverview();

        gamingSquareGameInfoOverview.setText(gameOverview);
        gaming_square_game_overview_progress_layout.setVisibility(LinearLayout.GONE);
    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

}