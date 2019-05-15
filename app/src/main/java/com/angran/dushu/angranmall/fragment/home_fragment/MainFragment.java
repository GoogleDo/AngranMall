package com.angran.dushu.angranmall.fragment.home_fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.details.DetailsActivity;
import com.angran.dushu.angranmall.utlis.CommenUtil;
import com.angran.dushu.angranmall.utlis.DisplayUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.BannerComponent;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * author: Create By dushu on 2019/3/2 11:31
 * email : dushu@bytedance.com
 */
public class MainFragment extends LazyFragment {

    public final static String TAG = "MainFragment";

    private RefreshLayout mRefreshLayout;
    private BannerComponent bannerComponent;
    private ViewPager bannerViewPager;
    private Indicator bannerIndicator;

    private ViewPager listViewPager;
    private ScrollIndicatorView listIndicator;

    private Activity activity;

    private static boolean isFirstEnter = true;
    private MainListAdapter mainListAdapterL;
    private MainListAdapter mainListAdapterR;

    //当前显示在前台的 viewpager 中的page的索引
    private int mPageIndex = 0;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain);


        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
        mRefreshLayout.setEnableFooterFollowWhenNoMoreData(true);

        //第一次进入演示刷新
        if (isFirstEnter) {
            isFirstEnter = false;
            mRefreshLayout.autoRefresh();
        }

        activity = getActivity();
        initBanner();
        initRecyle();

        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                        refreshLayout.resetNoMoreData();//setNoMoreData(false);//恢复上拉状态
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainListAdapter adapter;
                        boolean isLeflList = mPageIndex == 0 ? true : false;
                        if (isLeflList) {
                            adapter = mainListAdapterL;
                        } else {
                            adapter = mainListAdapterR;
                        }
                        if (adapter.getItemCount() > 12) {
                            Toast.makeText(getApplicationContext(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            refreshLayout.finishLoadMoreWithNoMoreData();//设置之后，将不会再触发加载事件
                        } else {
                            adapter.addItem(loadMore(isLeflList));
                            refreshLayout.finishLoadMore();
                        }
                    }

                }, 1000);
            }
        });

    }

    private void initRecyle() {
        listViewPager = (ViewPager) findViewById(R.id.goods_list_viewPager);
        listViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPageIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //这里通过动态的给viewpager设置高度来解决srcollview、viewpager嵌套问题造成的viewpager不显示的问题
        int height = CommenUtil.getScreenHeight(activity) - CommenUtil.getStateBarHright(activity) - DisplayUtil.dipToPix(activity, 44);

        //为ViewPager设置高度
        ViewGroup.LayoutParams params = listViewPager.getLayoutParams();
        params.height = height;
        listViewPager.setLayoutParams(params);


        listIndicator = (ScrollIndicatorView) findViewById(R.id.goods_list_indicator);
        listIndicator.setScrollBar(getRecyleScrollBar());
        //设置 banner_viewpager 预加载页面数为1个
        bannerViewPager.setOffscreenPageLimit(1);
        float unSelectSize = 12;
        float selectSize = unSelectSize * 1.3f;
        listIndicator.setOnTransitionListener(new OnTransitionTextListener().
                setColor(0xFF2C2C2C, Color.GRAY).setSize(selectSize, unSelectSize));

        new IndicatorViewPager(listIndicator, listViewPager).setAdapter(new MyRecyleIndicatorAdapter());
    }

    private ScrollBar getRecyleScrollBar() {
        ScrollBar scrollBar = new ColorBar(this.getContext(), 0xFFFBAB3E, 4);
        ((ColorBar) scrollBar).setWidth(DisplayUtil.dipToPix(getContext(), 63));
        return scrollBar;
    }

    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3};

    private void initBanner() {
        bannerViewPager = (ViewPager) findViewById(R.id.banner_viewPager);
        bannerIndicator = (Indicator) findViewById(R.id.banner_indicator);
        bannerIndicator.setScrollBar(getBannerScrollBar());
        //设置 banner_viewpager 预加载页面数为2个
        bannerViewPager.setOffscreenPageLimit(2);
        bannerComponent = new BannerComponent(bannerIndicator, bannerViewPager, false);
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

    @Override
    protected void onFragmentStartLazy() {
        super.onFragmentStartLazy();
        bannerComponent.startAutoPlay();
    }


    @Override
    protected void onFragmentStopLazy() {
        super.onFragmentStopLazy();
        bannerComponent.stopAutoPlay();
    }

    private ScrollBar getBannerScrollBar() {
        ScrollBar scrollBar = new ColorBar(getApplicationContext(), Color.WHITE, 0, ScrollBar.Gravity.CENTENT_BACKGROUND);
        ((ColorBar) scrollBar).setWidth(5);
        return scrollBar;
    }


    private class MyRecyleIndicatorAdapter extends IndicatorViewPager.IndicatorViewPagerAdapter {
        private String[] versions = {"推荐货源", "最新采购"};
        private List<Integer> drawableIDL = new ArrayList<>();
        private List<Integer> drawableIDR = new ArrayList<>();

        @Override
        public int getCount() {
            return versions.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.tab_main_list, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(versions[position]);

            int witdh = getTextWidth(textView);
            int padding = DisplayUtil.dipToPix(getApplicationContext(), 8);
            //因为wrap的布局 字体大小变化会导致textView大小变化产生抖动，这里通过设置textView宽度就避免抖动现象
            //1.3f是根据上面字体大小变化的倍数1.3f设置
            textView.setWidth((int) (witdh * 1.3f) + padding);

            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new RecyclerView(container.getContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            RecyclerView recyclerView = (RecyclerView) convertView;
            //设置列表布局管理
            recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
            initData(position);
            if (position == 0) {
                //设置适配器
                recyclerView.setAdapter(mainListAdapterL = new MainListAdapter(drawableIDL, getContext()));
                mainListAdapterL.setOnItemClickListener(new MainListAdapter.OnItemClickListener() {

                    @Override
                    public void OnItemClick(View itemView, int position) {
                        jumpToDetails(itemView,position);
                    }

                    @Override
                    public void onItemLongClick(View itemView, int position) {

                    }
                });
            } else {
                //设置适配器
                recyclerView.setAdapter(mainListAdapterR = new MainListAdapter(drawableIDR, getContext()));
                mainListAdapterL.setOnItemClickListener(new MainListAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View itemView, int position) {
                        jumpToDetails(itemView,position);
                    }

                    @Override
                    public void onItemLongClick(View itemView, int position) {

                    }
                });
            }


            return convertView;
        }

        //跳转到商品详情页
        private void jumpToDetails(View itemView, int position) {
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            startActivity(intent);
        }

        private void initData(int position) {
            if (position == 0) {
                drawableIDL.add(R.drawable.list1);
                drawableIDL.add(R.drawable.list2);
                drawableIDL.add(R.drawable.list1);
                drawableIDL.add(R.drawable.list1);
                drawableIDL.add(R.drawable.list2);
            } else {
                drawableIDR.add(R.drawable.list3);
                drawableIDR.add(R.drawable.list4);
                drawableIDR.add(R.drawable.list3);
                drawableIDR.add(R.drawable.list3);
                drawableIDR.add(R.drawable.list4);
            }
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_UNCHANGED;
        }

        private int getTextWidth(TextView textView) {
            if (textView == null) {
                return 0;
            }
            Rect bounds = new Rect();
            String text = textView.getText().toString();
            Paint paint = textView.getPaint();
            paint.getTextBounds(text, 0, text.length(), bounds);
            int width = bounds.left + bounds.width();
            return width;
        }

    }

    private List<Integer> loadMore(boolean isLeftList) {
        List<Integer> list = new ArrayList<>();
        if (isLeftList) {
            list.add(R.drawable.list1);
            list.add(R.drawable.list2);
            list.add(R.drawable.list1);
            list.add(R.drawable.list1);
            list.add(R.drawable.list2);
        } else {
            list.add(R.drawable.list3);
            list.add(R.drawable.list4);
            list.add(R.drawable.list3);
            list.add(R.drawable.list3);
            list.add(R.drawable.list4);
        }
        return list;
    }

}
