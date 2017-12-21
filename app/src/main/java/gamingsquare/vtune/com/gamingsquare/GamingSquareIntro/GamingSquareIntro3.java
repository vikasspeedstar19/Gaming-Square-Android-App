package gamingsquare.vtune.com.gamingsquare.GamingSquareIntro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareHome;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 26/02/2017.
 */

public class GamingSquareIntro3 extends Fragment {
    Button gamingSquareIntroFinish;
    EditText starterIpAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup gamingSquareIntro3 = (ViewGroup) inflater.inflate(R.layout.gaming_square_intro3, container, false);
        startActivity(new Intent(getActivity(), GamingSquareHome.class));
        getActivity().finish();

        return gamingSquareIntro3;
    }
}
