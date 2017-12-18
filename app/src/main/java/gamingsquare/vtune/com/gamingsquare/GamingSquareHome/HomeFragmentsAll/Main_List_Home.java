package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentsAll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareMainData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareGamesAdapter.GamingSquareRecViewAdapter;
import gamingsquare.vtune.com.gamingsquare.R;

public class Main_List_Home extends Fragment {
    RecyclerView recyclerView;
    GamingSquareMainData photoAlbum;
    GamingSquareRecViewAdapter photoAlbumAdapter;
    RecyclerView.LayoutManager layoutManager;
    private SimpleArcDialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

        View view = inflater.inflate(R.layout.fragment_main_list_home,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.fragment_main_list_home_recycler_view);

        photoAlbum = new GamingSquareMainData(this);
        layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        photoAlbumAdapter = new GamingSquareRecViewAdapter(getActivity(),photoAlbum, new GamingSquareHelper().GAMING_SQUARE_MAIN_ALL_PC);
        recyclerView.setAdapter(photoAlbumAdapter);
        return view;
    }

    public void gamingSquareAddMainListData(){
        photoAlbumAdapter.gamingSquareAddMainListData();
        mDialog.dismiss();
    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

}
