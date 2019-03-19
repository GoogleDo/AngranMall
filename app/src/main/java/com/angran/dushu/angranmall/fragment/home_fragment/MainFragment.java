package com.angran.dushu.angranmall.fragment.home_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.angran.dushu.angranmall.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.BannerComponent;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;

import base.BaseFragment;

/**
 * author: Create By dushu on 2019/3/2 11:31
 * email : dushu@bytedance.com
 */
public class MainFragment extends LazyFragment {

    public final static String TAG = "MainFragment";

    private RefreshLayout mRefreshLayout;
    private BannerComponent bannerComponent;
    private ViewPager viewPager;
    private Indicator indicator;



    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain);


        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);

        initBanner();

    }
    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
    private void initBanner() {
        viewPager = (ViewPager) findViewById(R.id.banner_viewPager);
        indicator = (Indicator) findViewById(R.id.banner_indicator);
//        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.WHITE, 0, ScrollBar.Gravity.CENTENT_BACKGROUND));
        //设置 banner_viewpager 预加载页面数为2个
        viewPager.setOffscreenPageLimit(2);
        bannerComponent = new BannerComponent(indicator, viewPager, false);
        bannerComponent.setAdapter(new IndicatorViewPager.IndicatorViewPagerAdapter() {

            @Override
            public View getViewForTab(int position, View convertView, ViewGroup container) {
                if (convertView == null) {
                    convertView = new View(container.getContext());
                }
                return convertView;
            }

            @Override
            public View getViewForPage(int position, View convertView, ViewGroup container) {
                if (convertView == null) {
                    convertView = new ImageView(getApplicationContext());
                    convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }
                ImageView imageView = (ImageView) convertView;
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(images[position]);
                return convertView;
            }

//        @Override
//        public int getItemPosition(Object object) {
//            return RecyclingPagerAdapter.POSITION_NONE;
//        }

            @Override
            public int getCount() {
                return images.length;
            }
        });

        //默认就是800毫秒，设置单页滑动效果的时间
//        bannerComponent.setScrollDuration(800);
        //设置播放间隔时间，默认情况是3000毫秒
        bannerComponent.setAutoPlayTime(2500);
    }
}
