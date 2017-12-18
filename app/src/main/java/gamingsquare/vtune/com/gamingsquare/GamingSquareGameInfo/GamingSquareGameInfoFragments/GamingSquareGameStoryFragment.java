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

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGameStoryModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameStoryVolleyData;
import gamingsquare.vtune.com.gamingsquare.R;

import static gamingsquare.vtune.com.gamingsquare.R.id.gaming_square_game_story_progress_layout;

/**
 * Created by Vikas on 18/03/2017.
 */

public class GamingSquareGameStoryFragment extends Fragment {

    View view;

    SimpleArcDialog mDialog;

    GamingSquareGameStoryModel gamingSquareGameStoryModel;
    GamingSquareGameStoryVolleyData gamingSquareGameStoryVolleyData;

    LinearLayout gaming_square_game_story_progress_layout;

    TextView gamingSquareGameInfoStory;

    String gameStory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_story, container, false);
        gaming_square_game_story_progress_layout = (LinearLayout)view.findViewById(R.id.gaming_square_game_story_progress_layout);
        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
//        mDialog.show();

        gamingSquareGameStoryVolleyData = new GamingSquareGameStoryVolleyData("prototype", GamingSquareGameStoryFragment.this);

        return view;
    }

    public void getGamingSquareGameStoryModelData(GamingSquareGameStoryModel gamingSquareGameStoryModel) {
        this.gamingSquareGameStoryModel = gamingSquareGameStoryModel;

        gamingSquareGameInfoStory = (TextView) view.findViewById(R.id.gamingSquareGameInfoStory);

        gameStory = gamingSquareGameStoryModel.getGameStory();

        gamingSquareGameInfoStory.setText(gameStory);

        gaming_square_game_story_progress_layout.setVisibility(LinearLayout.GONE);
    }

    public void dismissProgressBar() {
        mDialog.dismiss();
    }

}
