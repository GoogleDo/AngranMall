package com.angran.dushu.angranmall.financing;

import android.content.Intent;
import android.view.View;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/13 17:23
 * email : dushu@bytedance.com
 */
public class FinancingListActivity extends BaseActivity implements View.OnClickListener {

    private GeneralTitleBar titleBar;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_financing_list);
        initTitleBar();
    }

    private void initTitleBar() {
        titleBar = findViewById(R.id.financing_list_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("融资");
        titleBar.showDivierLine(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_apply_0:
            case R.id.tv_apply_1:
            case R.id.tv_apply_2:
            case R.id.tv_apply_3:
            case R.id.tv_apply_4:
            case R.id.tv_apply_5:
                startActivity(new Intent(FinancingListActivity.this, ApplyFinancingActivity.class));
                break;
        }
    }
}
