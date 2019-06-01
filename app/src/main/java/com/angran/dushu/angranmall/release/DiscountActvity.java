package com.angran.dushu.angranmall.release;

import android.view.View;
import android.widget.Button;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/1 12:52
 * email : dushu@bytedance.com
 * 优惠 页面
 */
public class DiscountActvity extends BaseActivity {

    private static final String TAG = "DiscountActvity";

    private GeneralTitleBar titleBar;

    private Button btnIsSure;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_discount);
        btnIsSure = findViewById(R.id.btn_is_sure);
        btnIsSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initTitleBar();
    }

    private void initTitleBar() {
        titleBar = findViewById(R.id.discount_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("优惠");
        titleBar.showDivierLine(true);
    }
}
