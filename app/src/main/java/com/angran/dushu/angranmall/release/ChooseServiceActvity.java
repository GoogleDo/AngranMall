package com.angran.dushu.angranmall.release;

import android.view.View;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/6/1 15:49
 * email : dushu@bytedance.com
 */
public class ChooseServiceActvity extends BaseActivity {



    private GeneralTitleBar titleBar;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_choose_service);

        initTitleBar();

    }


    private void initTitleBar() {
        titleBar = findViewById(R.id.choose_service_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("选择服务");
        titleBar.showDivierLine(true);
    }
}
