package com.angran.dushu.angranmall.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.activity.MainTabActivity;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/2/24 15:00
 * email : dushu@bytedance.com
 *
 * 注册页面
 */
public class RegisterActivity extends BaseActivity {

    private GeneralTitleBar mTitleBar;
    private Button mBtnRegister;

    private TextView mTvUserAgreement;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_register);
        mTitleBar = findViewById(R.id.register_title_bar);
        mTitleBar.setLeftButtonListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });

        mBtnRegister = findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, MainTabActivity.class));
                finish();
            }
        });

        mTvUserAgreement = findViewById(R.id.tv_user_agreement);
        SpannableString spannableString = new SpannableString(mTvUserAgreement.getText().toString());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#79BEF6")), 9,
                spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvUserAgreement.setText(spannableString);
    }
}
