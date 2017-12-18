package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoFragments;

import android.graphics.Color;
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

import org.json.JSONArray;
import org.json.JSONException;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel.GamingSquareGamingInfoModel;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameInfoInfoVolleyData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 18/03/2017.
 */

public class GamingSquareGameInfoFragment extends Fragment {

    View view;
    GamingSquareGamingInfoModel gamingSquareGamingInfoModel;
    GamingSquareGameInfoInfoVolleyData gamingSquareGameInfoInfoVolleyData;
    TextView gamingSquareGameInfoGameName;// Use this to set game name using Intent
    private SimpleArcDialog mDialog;
    GamingSquareGameInfo gamingSquareGameInfo = new GamingSquareGameInfo();
    LinearLayout gamingSquareGameInfoDeveloper, gamingSquareGameInfoPublisher, gamingSquareGameInfoGenre, gamingSquareGameInfoGameModes, gamingSquareGameInfoPlayerView, gamingSquareGameInfoReleaseDates,gaming_square_game_info_progress_layout;
    JSONArray developer, publisher, releaseDates, genre, playerView, gameModes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaming_square_game_info_info, container, false);

        mDialog = new SimpleArcDialog(getActivity());
        mDialog.setConfiguration(new ArcConfiguration(getActivity()));
        mDialog.setCanceledOnTouchOutside(false);
//        mDialog.show();

        gamingSquareGameInfoInfoVolleyData = new GamingSquareGameInfoInfoVolleyData("prototype", GamingSquareGameInfoFragment.this);

        return view;
    }

    public void getGamingSquareGameInfoModelData(GamingSquareGamingInfoModel gamingSquareGamingInfoModel) {
        this.gamingSquareGamingInfoModel = gamingSquareGamingInfoModel;

        gamingSquareGameInfo.setGameDetailMainImg(gamingSquareGamingInfoModel.getImgUrl());

        String game_name = getActivity().getIntent().getStringExtra(new GamingSquareHelper().GAMING_SQUARE_GAME_NAME);

        gamingSquareGameInfoGameName = (TextView) view.findViewById(R.id.gamingSquareGameInfoGameName);
        gamingSquareGameInfoDeveloper = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoDeveloper);
        gamingSquareGameInfoPublisher = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoPublisher);
        gamingSquareGameInfoGenre = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoGenre);
        gamingSquareGameInfoPlayerView = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoPlayerView);
        gamingSquareGameInfoReleaseDates = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoReleaseDates);
        gamingSquareGameInfoGameModes = (LinearLayout) view.findViewById(R.id.gamingSquareGameInfoGameModes);
        gaming_square_game_info_progress_layout = (LinearLayout) view.findViewById(R.id.gaming_square_game_info_progress_layout);


        developer = gamingSquareGamingInfoModel.getDeveloper();
        publisher = gamingSquareGamingInfoModel.getPublisher();
        releaseDates = gamingSquareGamingInfoModel.getReleaseDates();
        genre = gamingSquareGamingInfoModel.getGenre();
        playerView = gamingSquareGamingInfoModel.getPlayerView();
        gameModes = gamingSquareGamingInfoModel.getGameModes();

        try {

            gamingSquareGameInfoGameName.setText(game_name);

            for (int i = 0; i < developer.length(); i++) {
                TextView textview = new TextView(getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview.setTextSize(16);
                textview.setTextColor(Color.WHITE);
                textview.setLayoutParams(params);
                textview.setText("" + developer.get(i));
                gamingSquareGameInfoDeveloper.addView(textview);
            }

            gamingSquareGameInfoDeveloper.addView(createHorizontalRule());

            for (int i = 0; i < publisher.length(); i++) {
                TextView textview = new TextView(getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview.setTextSize(16);
                textview.setTextColor(Color.WHITE);
                textview.setLayoutParams(params);
                textview.setText("" + publisher.get(i));
            }

            gamingSquareGameInfoPublisher.addView(createHorizontalRule());

            for (int i = 0; i < releaseDates.length(); i++) {
                TextView textview1 = new TextView(getActivity());

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview1.setTextSize(16);
                textview1.setTextColor(Color.WHITE);
                textview1.setLayoutParams(params1);

                textview1.setText("" + releaseDates.getJSONObject(i).getString("game_console"));

                gamingSquareGameInfoReleaseDates.addView(textview1);

                TextView textview2 = new TextView(getActivity());

                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                params2.setMargins(0, 0, 0, 12);
                textview2.setTextSize(16);
                textview2.setTextColor(Color.WHITE);
                textview2.setLayoutParams(params2);
                textview2.setText("" + releaseDates.getJSONObject(i).getString("console_release_date").toString().substring(0,10));

                gamingSquareGameInfoReleaseDates.addView(textview2);

            }

            gamingSquareGameInfoReleaseDates.addView(createHorizontalRule());

            for (int i = 0; i < genre.length(); i++) {
                TextView textview = new TextView(getActivity());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview.setTextSize(16);
                textview.setTextColor(Color.WHITE);
                textview.setLayoutParams(params);
                textview.setText("" + genre.get(i));

                gamingSquareGameInfoGenre.addView(textview);

            }

            gamingSquareGameInfoGenre.addView(createHorizontalRule());

            for (int i = 0; i < playerView.length(); i++) {
                TextView textview = new TextView(getActivity());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview.setTextSize(16);
                textview.setTextColor(Color.WHITE);
                textview.setLayoutParams(params);
                textview.setText("" + playerView.get(i));

                gamingSquareGameInfoPlayerView.addView(textview);

            }

            for (int i = 0; i < gameModes.length(); i++) {
                TextView textview = new TextView(getActivity());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textview.setTextSize(16);
                textview.setTextColor(Color.WHITE);
                textview.setLayoutParams(params);
                textview.setText("" + gameModes.get(i));

                gamingSquareGameInfoGameModes.addView(textview);

            }

            gamingSquareGameInfoGameModes.addView(createHorizontalRule());
            // dismissProgressBar();
            gaming_square_game_info_progress_layout.setVisibility(LinearLayout.GONE);
        } catch (JSONException jsonException) {
        }
    }

    public void dismissProgressBar(){
        mDialog.dismiss();
    }

    public View createHorizontalRule() {
        View view = new View(getActivity());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);

        params.setMargins(0, 20, 0, 20);

        view.setLayoutParams(params);

        view.setBackgroundColor(Color.WHITE);
        return view;
    }

}
