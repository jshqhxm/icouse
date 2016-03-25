package com.iketang.icouse.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iketang.icouse.IcString;
import com.iketang.icouse.ui.fragment.IcRecommendFragment;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/25.
 */
public class IcMainFmAdapter extends FragmentPagerAdapter {

    public IcMainFmAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return  new IcRecommendFragment();
        }

        return null;
    }


    @Override
    public int getCount() {

        return IcString.MAIN_TITLES.length;
    }
}
