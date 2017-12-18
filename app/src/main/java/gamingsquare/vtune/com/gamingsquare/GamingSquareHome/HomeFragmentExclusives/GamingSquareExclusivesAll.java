package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.HomeFragmentExclusives;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 04/03/2017.
 */

public class GamingSquareExclusivesAll extends Fragment {
    private TabLayout exclusive_list_tabs;
    private ViewPager exclusive_list_tabspager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gaming_square_main_list_all, container, false);
        exclusive_list_tabs = (TabLayout) view.findViewById(R.id.main_list_all_tabs);
        exclusive_list_tabspager = (ViewPager) view.findViewById(R.id.main_list_all_tabspager);
        exclusive_list_tabspager.setOffscreenPageLimit(3);
        setupViewPager(exclusive_list_tabspager);
        exclusive_list_tabs.setupWithViewPager(exclusive_list_tabspager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager(exclusive_list_tabspager);
        exclusive_list_tabs.setupWithViewPager(exclusive_list_tabspager);
        exclusive_list_tabs.getTabAt(0).setIcon(R.drawable.ic_pc);
        exclusive_list_tabs.getTabAt(1).setIcon(R.drawable.ic_ps);
        exclusive_list_tabs.getTabAt(2).setIcon(R.drawable.ic_xbox);
        exclusive_list_tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        GamingSquareExclusivesAll.ViewPagerAdapter viewPagerAdapter = new GamingSquareExclusivesAll.ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new GamingSquareExclusivesPCFragment(), null);
        viewPagerAdapter.addFragment(new GamingSquareExclusivesPSFragment(), null);
        viewPagerAdapter.addFragment(new GamingSquareExclusivesXBOXFragment(), null);

        viewPager.setAdapter(viewPagerAdapter);
    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> fragmentTitles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }

        public void addFragment(Fragment fragment, String name) {
            fragmentList.add(fragment);
            fragmentTitles.add(name);
        }
    }
}
