package com.itzb.wangyimusicanimdemo.music;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mDiscLayouts;

    public ViewPagerAdapter(List<View> mDiscLayouts) {
        this.mDiscLayouts = mDiscLayouts;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View discLayout = mDiscLayouts.get(position);
        container.addView(discLayout);
        return discLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mDiscLayouts.get(position));
    }

    @Override
    public int getCount() {
        return mDiscLayouts.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
