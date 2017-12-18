package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentYoutubers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareGamesAdapter.GamingSquareRecViewAdapter;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareYoutubersData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 04/03/2017.
 */

public class GamingSquareYoutubersFragment extends Fragment{

    RecyclerView recyclerView;
    GamingSquareYoutubersData photoAlbum;
    GamingSquareRecViewAdapter photoAlbumAdapter;
    RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_games_list_main,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.framgent_main_list_pc_recycler_view);
        photoAlbum = new GamingSquareYoutubersData();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        photoAlbumAdapter = new GamingSquareRecViewAdapter(getActivity(),photoAlbum,new GamingSquareHelper().GAMING_SQAURE_YOUTUBERS);
        recyclerView.setAdapter(photoAlbumAdapter);
        return view;
    }


}
