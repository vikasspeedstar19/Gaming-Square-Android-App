package gamingsquare.vtune.com.gamingsquare.GamingSquareIntro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import gamingsquare.vtune.com.gamingsquare.R;

public class GamingSquareIntro extends FragmentActivity {

    private ViewPager gamingIntroViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_square_intro);
        gamingIntroViewPager = (ViewPager) findViewById(R.id.gamingIntroViewPager);
        gamingIntroViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        setupGamingIntroViewPager(gamingIntroViewPager);
    }

    private void setupGamingIntroViewPager(ViewPager viewPager) {
        GamingIntroViewPagerAdapter adapter = new GamingIntroViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GamingSquareIntro1());
        adapter.addFragment(new GamingSquareIntro2());
        adapter.addFragment(new GamingSquareIntro3());

        viewPager.setAdapter(adapter);
    }

    private class GamingIntroViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> gamingIntroFragmentList = new ArrayList<>();

        public GamingIntroViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return gamingIntroFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return gamingIntroFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            gamingIntroFragmentList.add(fragment);
        }
    }
}
