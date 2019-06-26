package com.angran.dushu.angranmall.product;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.details.DetailsActivity;
import com.angran.dushu.angranmall.fragment.home_fragment.MainListAdapterL;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListDataScreenView;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListScreenMenuAdapter;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * author: Create By dushu on 2019/6/11 17:28
 * email : dushu@bytedance.com
 * 全部货源页面
 */
public class AllPreductActivity extends BaseActivity {

    private GeneralTitleBar titleBar;
    private ListDataScreenView mListDataScreenView;

    private RefreshLayout mRefreshLayout;
    private static boolean isFirstEnter = true;

    private List<Integer> drawableIDL = new ArrayList<>();
    private MainListAdapterL mainListAdapterL;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_all_product);
        initTitleBar();

        mListDataScreenView = findViewById(R.id.list_data_screen_view);
        mListDataScreenView.setAdapter(new ListScreenMenuAdapter(this));

        mRefreshLayout = findViewById(R.id.refreshLayout_product);
        mRefreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
        mRefreshLayout.setEnableFooterFollowWhenNoMoreData(true);

        //第一次进入演示刷新
        if (isFirstEnter) {
            isFirstEnter = false;
            mRefreshLayout.autoRefresh();
        }
        initRecyclerView();


    }

    private void initRecyclerView() {
        View view = findViewById(R.id.product_recyler_view);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            initData();
            recyclerView.setAdapter(mainListAdapterL =new MainListAdapterL(drawableIDL, this));
            mainListAdapterL.setOnItemClickListener(new MainListAdapterL.OnItemClickListener() {

                @Override
                public void OnItemClick(View itemView, int position) {
                    jumpToDetails(itemView, position);
                }

                @Override
                public void onItemLongClick(View itemView, int position) {

                }
            });
        }
    }

    private void initData() {
        drawableIDL.add(R.drawable.list1);
        drawableIDL.add(R.drawable.list2);
        drawableIDL.add(R.drawable.list1);
        drawableIDL.add(R.drawable.list1);
        drawableIDL.add(R.drawable.list2);
    }


    private void initTitleBar() {
        titleBar = findViewById(R.id.all_product_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("全部货源");
        titleBar.showDivierLine(true);
    }

    //跳转到商品详情页
    private void jumpToDetails(View itemView, int position) {
        Intent intent = new Intent(AllPreductActivity.this, DetailsActivity.class);
        startActivity(intent);
    }

    public void closeMenuView() {
        mListDataScreenView.closeMenu();
    }
}
