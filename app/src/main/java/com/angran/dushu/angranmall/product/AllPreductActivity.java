package com.angran.dushu.angranmall.product;

import android.view.View;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListDataScreenView;
import com.angran.dushu.angranmall.view.ListDataScreenView.ListScreenMenuAdapter;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/11 17:28
 * email : dushu@bytedance.com
 */
public class AllPreductActivity extends BaseActivity {

    private GeneralTitleBar titleBar;
    private ListDataScreenView mListDataScreenView;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_all_product);
        initTitleBar();

        mListDataScreenView = findViewById(R.id.list_data_screen_view);
        mListDataScreenView.setAdapter(new ListScreenMenuAdapter(this));
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
}
