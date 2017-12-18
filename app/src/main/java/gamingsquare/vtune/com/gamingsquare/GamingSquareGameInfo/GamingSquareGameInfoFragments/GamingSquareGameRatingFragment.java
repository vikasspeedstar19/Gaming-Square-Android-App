package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import java.util.ArrayList;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoAdapter.GamingSquareGameInfoRatingAdapter;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameRatingModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameRatingVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 18/03/2017.
 */

public class GamingSquareGameRatingFragment extends Fragment{

	View view;
    GamingSquareGameRatingVolleyData gamingSquareGameRatingVolleyData;
    GamingSquareGameRatingModel gamingSquareGameRatingModel;
    LinearLayout gamingSquareGameInfoRating;
    RecyclerView gameRatingRecylerView;
    LinearLayoutManager layoutManager;
    LinearLayout gaming_square_game_rating_progress_layout;
    SimpleArcDialog mDialog;
    GamingSquareGameInfoRatingAdapter gamingSquareGameInfoRatingAdapter;
    ArrayList<GamingSquareGameRatingModel> gameInfoRatings = new ArrayList<GamingSquareGameRatingModel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
//        mDialog.show();

        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_ratings,container,false);

        gamingSquareGameRatingVolleyData = new GamingSquareGameRatingVolleyData("prototype",GamingSquareGameRatingFragment.this);
        gaming_square_game_rating_progress_layout = (LinearLayout)view.findViewById(R.id.gaming_square_game_rating_progress_layout);
        gameRatingRecylerView = (RecyclerView)view.findViewById(R.id.gameRatingRecylerView);

        layoutManager = new LinearLayoutManager(getActivity());
        gameRatingRecylerView.setLayoutManager(layoutManager);

        gamingSquareGameInfoRatingAdapter = new GamingSquareGameInfoRatingAdapter(getActivity(), gamingSquareGameRatingVolleyData);

        gameRatingRecylerView.setAdapter(gamingSquareGameInfoRatingAdapter);

        return view;
    }

    public void getGamingSquareGameRatingModelData(ArrayList<GamingSquareGameRatingModel> gameInfoRatings){
    	this.gameInfoRatings = gameInfoRatings;
    }

    public void gamingSquareAddMainListData(){
        gamingSquareGameInfoRatingAdapter.gamingSquareAddGameRatingListData();
        mDialog.dismiss();
    }

    public void dismissProgressBar(){
        gaming_square_game_rating_progress_layout.setVisibility(LinearLayout.GONE);
        // mDialog.dismiss();
    }

    public void gamingSquareAddRatingsData(){
        gamingSquareGameInfoRatingAdapter.gamingSquareAddGameRatingListData();
        mDialog.dismiss();
    }

}