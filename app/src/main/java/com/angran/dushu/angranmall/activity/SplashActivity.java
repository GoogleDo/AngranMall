package com.angran.dushu.angranmall.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;


import base.BaseActivity;

/**
 * author: Create By dushu on 2019/2/16 22:47
 * email : dushu@bytedance.com
 */
public class SplashActivity extends BaseActivity {

    @Override
    public void setRootView() {
        super.setRootView();

        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置没有标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainTabActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }
}
