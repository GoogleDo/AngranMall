package com.angran.dushu.angranmall.financing;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.activity.MainTabActivity;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/17 11:31
 * email : dushu@bytedance.com
 * 融资成功页面
 */
public class FinancingSuccessActivity extends BaseActivity {


    private GeneralTitleBar titleBar;
    private Button btnBackToMain;

    @Override
    public void initView() {
        super.initView();
        initTitleBar();
        btnBackToMain = findViewById(R.id.btn_back_to_main);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinancingSuccessActivity.this, MainTabActivity.class);
                intent.putExtra("page","main");
                startActivity(intent);
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
        titleBar.showDivierLine(false);
    }
}
