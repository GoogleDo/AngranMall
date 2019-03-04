package com.angran.dushu.angranmall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;


import com.angran.dushu.angranmall.config.PreferencesConfig;
import com.angran.dushu.angranmall.login.LoginActivity;
import com.angran.dushu.angranmall.login.RegisterActivity;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/2/16 22:47
 * email : dushu@bytedance.com
 */
public class SplashActivity extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置没有标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PreferencesConfig.getUserFromPreference() != null) {
                    startActivity(new Intent(SplashActivity.this, MainTabActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }

                finish();
            }
        }, 500);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }
}
