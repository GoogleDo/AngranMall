package com.angran.dushu.angranmall.financing;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/14 11:18
 * email : dushu@bytedance.com
 */
public class ApplyFinancingActivity extends BaseActivity {


    private GeneralTitleBar titleBar;
    private Button btnApply;
    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_apply_financing);
        initTitleBar();
        btnApply = findViewById(R.id.btn_apply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApplyFinancingActivity.this, FinancingSuccessActivity.class));
            }
        });
    }

    private void initTitleBar() {
        titleBar = findViewById(R.id.apply_financing_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("申请融资");
        titleBar.showDivierLine(true);
    }
}
