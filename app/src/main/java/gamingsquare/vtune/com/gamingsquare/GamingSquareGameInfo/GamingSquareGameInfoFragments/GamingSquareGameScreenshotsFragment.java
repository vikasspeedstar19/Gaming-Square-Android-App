package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.ZGrid;
import com.mzelzoghbi.zgallery.entities.ZColor;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoAdapter.GamingSquareGameScreenshotsAdapter;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameScreenshotsVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 16/03/2017.
 */

public class GamingSquareGameScreenshotsFragment extends Fragment {

	View view;
    GamingSquareGameScreenshotsVolleyData gamingSquareGameScreenshotsVolleyData;
    RecyclerView gameScreenshotsRecylerView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    SimpleArcDialog mDialog;
    GamingSquareGameScreenshotsAdapter gamingSquareGameScreenshotsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_screenshots,container,false);

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
//        mDialog.show();

        gamingSquareGameScreenshotsVolleyData = new GamingSquareGameScreenshotsVolleyData("prototype",GamingSquareGameScreenshotsFragment.this);
        gameScreenshotsRecylerView = (RecyclerView)view.findViewById(R.id.gameScreenshotsRecylerView);
        staggeredGridLayoutManager  = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        gameScreenshotsRecylerView.setLayoutManager(staggeredGridLayoutManager);
        gamingSquareGameScreenshotsAdapter = new GamingSquareGameScreenshotsAdapter(getActivity(), gamingSquareGameScreenshotsVolleyData);
        gameScreenshotsRecylerView.setAdapter(gamingSquareGameScreenshotsAdapter);
        return view;
    }

    public void gamingSquareAddMainListData(){
        gamingSquareGameScreenshotsAdapter.gamingSquareAddGameScreenshotsListData();
        mDialog.dismiss();
    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

    public void gamingSquareAddScreenshotsData(){
        gamingSquareGameScreenshotsAdapter.gamingSquareAddGameScreenshotsListData();
        //mDialog.dismiss();
    }

}