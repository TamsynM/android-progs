package com.murphy.tamsyn.tamsynmurphyresumeapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.murphy.tamsyn.tamsynmurphyresumeapp.fragments.EducationFragment;
import com.murphy.tamsyn.tamsynmurphyresumeapp.fragments.EmploymentFragment;
import com.murphy.tamsyn.tamsynmurphyresumeapp.fragments.SummaryFragment;

/**
 * Created by Tamsyn on 11/09/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Title[];
    int NumberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence title[], int number) {
        super(fm);
        this.Title = title;
        this.NumberOfTabs = number;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                //show the summary fragment
                SummaryFragment tab1 = new SummaryFragment();
                return tab1;
            case 1:
                //show the education fragment
                EducationFragment tab2 = new EducationFragment();
                return tab2;
            case 2:
                //show the employment fragment
                EmploymentFragment tab3 = new EmploymentFragment();
                return tab3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Title[position];
    }

    //this method returns the number of tabs in the tab strip
    @Override
    public int getCount() {
        return Title.length;
    }
}