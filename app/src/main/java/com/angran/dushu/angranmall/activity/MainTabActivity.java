package com.angran.dushu.angranmall.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.fragment.home_fragment.MainFragment;
import com.angran.dushu.angranmall.fragment.member_fragment.MemberFragment;
import com.angran.dushu.angranmall.fragment.mine_fragment.MineFragment;
import com.angran.dushu.angranmall.fragment.msg_fragment.MessageFragment;
import com.angran.dushu.angranmall.release.PurchaseOrderActivity;
import com.angran.dushu.angranmall.release.QuotationPricesActivity;
import com.angran.dushu.angranmall.release.ReleaseGoodsActivity;
import com.angran.dushu.angranmall.view.DragFloatActionButton;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.shizhefei.view.viewpager.SViewPager;


import java.util.logging.Logger;

import base.BaseActivity;

public class MainTabActivity extends BaseActivity {

    private static final String TAG = "MainTabActivity";

    private SViewPager viewPager;
    private FixedIndicatorView indicator;
    private IndicatorViewPager indicatorViewPager;

    private LinearLayout lySearch;
    private LinearLayout lySearchTitleBar;
    private TextView tvMade;

    private DragFloatActionButton dfaBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG,"onNewIntent");
        if (intent != null) {
            String page = intent.getExtras().getString("page");
            if (!TextUtils.isEmpty(page) && TextUtils.equals(page, "main")) {
                try {
                    viewPager.setCurrentItem(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_main_tab);

        lySearchTitleBar = findViewById(R.id.ly_title_bar);

        lySearch = findViewById(R.id.ly_search);
        lySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接跳转搜索页

            }
        });

        tvMade = findViewById(R.id.tv_made);
        tvMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接跳转定制页
            }
        });

        viewPager = findViewById(R.id.tabmain_viewPager);
        indicator = findViewById(R.id.tabmain_indicator);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(getResources().getColor(R.color.tab_text_selected_color),
                getResources().getColor(R.color.tab_text_color)));

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    lySearchTitleBar.setVisibility(View.VISIBLE);
                    dfaBtn.setVisibility(View.VISIBLE);
                } else {
                    lySearchTitleBar.setVisibility(View.GONE);
                    dfaBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        dfaBtn = findViewById(R.id.dfa_btn);
        dfaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainTabActivity.this,dfaBtn);
                getMenuInflater().inflate(R.menu.pop_item,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        switch (menuItem.getItemId()){
                            case R.id.release_product:
                                intent.setClass(MainTabActivity.this, ReleaseGoodsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.release_buys:
                                intent.setClass(MainTabActivity.this, PurchaseOrderActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.release_prices:
                                intent.setClass(MainTabActivity.this, QuotationPricesActivity.class);
                                startActivity(intent);
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
                Log.e("****--->","float");

            }
        });

    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"主页", "动态", "会员", "我的"};
        private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
                R.drawable.maintab_4_selector};
        private LayoutInflater inflater;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_widght_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            switch (position) {
                case 0:
                    MainFragment mainFragment = new MainFragment();
                    return mainFragment;
                case 1:
                    return new MessageFragment();
                case 2:
                    return new MemberFragment();
                case 3:
                    return new MineFragment();
            }

            return null;
        }
    }
}
