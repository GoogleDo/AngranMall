package com.angran.dushu.angranmall.purchase;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.fragment.home_fragment.MainListAdapterR;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListDataScreenView;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListScreenMenuAdapter;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * author: Create By dushu on 2019/6/27 11:51
 * email : dushu@bytedance.com
 */
public class PurchaseListActivity extends BaseActivity {


    private GeneralTitleBar titleBar;
    private ListDataScreenView mListDataScreenView;

    private RefreshLayout mRefreshLayout;
    private static boolean isFirstEnter = true;

    private List<Boolean> drawableIDR = new ArrayList<>();
    private MainListAdapterR mainListAdapterR;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_purchase_list);
        initTitleBar();

        mListDataScreenView = findViewById(R.id.purchase_list_data_screen_view);
        mListDataScreenView.setAdapter(new ListScreenMenuAdapter(this, new String[]{"地区", "商品", "筛选", "排序"}));

        mRefreshLayout = findViewById(R.id.refreshLayout_purchase_list);
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
        View view = findViewById(R.id.purchase_list_recyler_view);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            initData();
            recyclerView.setAdapter(mainListAdapterR = new MainListAdapterR(drawableIDR, this));
            mainListAdapterR.setOnItemClickListener(new MainListAdapterR.OnItemClickListener() {

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
        drawableIDR.add(false);
        drawableIDR.add(true);
        drawableIDR.add(true);
        drawableIDR.add(false);
        drawableIDR.add(true);
    }


    private void initTitleBar() {
        titleBar = findViewById(R.id.purchase_list_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("采购大厅");
        titleBar.showDivierLine(true);
    }

    //跳转到采购详情页
    private void jumpToDetails(View itemView, int position) {
//        Intent intent = new Intent(PurchaseListActivity.this, PurchaseDetailsActivity.class);
//        startActivity(intent);
    }

    public void closeMenuView() {
        mListDataScreenView.closeMenu();
    }
}
