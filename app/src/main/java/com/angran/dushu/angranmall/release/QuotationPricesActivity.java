package com.angran.dushu.angranmall.release;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/5/28 23:45
 * email : dushu@bytedance.com
 */
public class QuotationPricesActivity extends BaseActivity {
    private static final String TAG = "PurchaseOrderActivity";

    private GeneralTitleBar titleBar;

    private TextView tvReleaseGuide;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_prices);
        initTitleBar();

        tvReleaseGuide = findViewById(R.id.tv_release_guide);
        SpannableString spStr = new SpannableString(tvReleaseGuide.getText());
        tvReleaseGuide.setMovementMethod(LinkMovementMethod.getInstance());
        spStr.setSpan(new ClickableSpan(){
            @Override
            public void onClick(View widget) {
                Toast.makeText(QuotationPricesActivity.this, "触发点击事件!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#2873FF"));
            }
        },12,spStr.length() , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvReleaseGuide.setText(spStr);
    }

    private void initTitleBar() {
        titleBar = findViewById(R.id.prices_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("填写报价单");
        titleBar.showDivierLine(true);
    }
}
