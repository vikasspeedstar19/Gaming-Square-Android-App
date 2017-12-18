package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentExclusives;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareGamesAdapter.GamingSquareRecViewAdapter;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareExclusivesXBOXData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 04/03/2017.
 */

public class GamingSquareExclusivesXBOXFragment extends Fragment {

    RecyclerView recyclerView;
    GamingSquareExclusivesXBOXData photoAlbum;
    GamingSquareRecViewAdapter photoAlbumAdapter;
    RecyclerView.LayoutManager layoutManager;
    SimpleArcDialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

        View view = inflater.inflate(R.layout.fragment_games_list_main,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.framgent_main_list_pc_recycler_view);

        photoAlbum = new GamingSquareExclusivesXBOXData(this);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        photoAlbumAdapter = new GamingSquareRecViewAdapter(getActivity(),photoAlbum, new GamingSquareHelper().GAMING_SQAURE_EXCLUSIVES_XBOX);
        recyclerView.setAdapter(photoAlbumAdapter);
        return view;
    }


    public void gamingSquareAddExclusiveXBOXListData(){
        photoAlbumAdapter.gamingSquareAddExclusiveXBOXListData();
        mDialog.dismiss();
    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

}