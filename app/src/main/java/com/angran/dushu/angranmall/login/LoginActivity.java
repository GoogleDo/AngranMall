package com.angran.dushu.angranmall.login;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.activity.MainTabActivity;
import com.angran.dushu.angranmall.activity.SplashActivity;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/2/24 15:13
 * email : dushu@bytedance.com
 *
 * 登录页面
 */
public class LoginActivity extends BaseActivity {

    public final static String TAG = "LoginActivity";

    private GeneralTitleBar mTitleBar;


    private ImageView mIvLoginQQ;
    private ImageView mIvLoginWechat;
    private ImageView mIvLoginWeibo;

    private Button mBtnLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_login);
        mTitleBar = findViewById(R.id.login_titlebar);
        mTitleBar.setLeftButtonImage(R.drawable.login_close);
        mTitleBar.setLeftButtonListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        mTitleBar.setRightText("注册");
        mTitleBar.setRightButtonListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainTabActivity.class));
                finish();
            }
        });


        mIvLoginQQ = findViewById(R.id.iv_login_qq);
        mIvLoginWechat = findViewById(R.id.iv_login_wechat);
        mIvLoginWeibo = findViewById(R.id.iv_login_weibo);

        mIvLoginQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"暂未支持",Toast.LENGTH_SHORT).show();
            }
        });
        mIvLoginWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"暂未支持",Toast.LENGTH_SHORT).show();
            }
        });
        mIvLoginWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"暂未支持",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
