package gamingsquare.vtune.com.gamingsquare.GamingSquareIntro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 26/02/2017.
 */

public class GamingSquareIntro2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup gamingSquareIntro2 = (ViewGroup) inflater.inflate(
                R.layout.gaming_square_intro2, container, false);

        return gamingSquareIntro2;
    }
}
