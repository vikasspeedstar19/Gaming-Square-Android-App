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
        gamingSquareIntroFinish = (Button) gamingSquareIntro3.findViewById(R.id.gaming_square_intro_finish);
        starterIpAddress = (EditText) gamingSquareIntro3.findViewById(R.id.starterIpAddress);

        starterIpAddress.setText("http://192.168.1.100:3000/");

        gamingSquareIntroFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                GamingSquareHelper.GAMING_SQAURE_BASE_URL = "http://"+starterIpAddress.getText().toString().trim()+"/";
//                GamingSquareHelper.GAMING_SQAURE_IMG_BASE_URL = "http://"+starterIpAddress.getText().toString()+"/";

                        /*public final String GAMING_SQAURE_BASE_URL = "http://192.168.1.104:3000/";
                          public final String GAMING_SQAURE_IMG_BASE_URL = "http://192.168.1.104:3000/";
                        * */
                startActivity(new Intent(getActivity(), GamingSquareHome.class));
                getActivity().finish();
            }
        });

        return gamingSquareIntro3;
    }
}
