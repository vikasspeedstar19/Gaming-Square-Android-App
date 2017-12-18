package gamingsquare.vtune.com.gamingsquare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareHome;
import gamingsquare.vtune.com.gamingsquare.GamingSquareIntro.GamingSquareIntro;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        int firstLaunch = sharedPref.getInt("FIRST_TIME_LAUNCH",0);
//        if (firstLaunch == 1) {
//            Toast.makeText(this, "Second Launch", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(SplashActivity.this, GamingSquareHome.class));
//            finish();
//        } else if(firstLaunch == 0){
//            editor.putInt("FIRST_TIME_LAUNCH", 1);
//            editor.commit();
//            Toast.makeText(this, "First Launch", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(SplashActivity.this, GamingSquareIntro.class));
//            finish();
//        }

        startActivity(new Intent(SplashActivity.this, GamingSquareIntro.class));
        finish();
    }
}
