package com.angran.dushu.angranmall.release;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/5/21 23:03
 * email : dushu@bytedance.com
 */
public class PurchaseOrderActivity extends BaseActivity {

    private static final String TAG = "PurchaseOrderActivity";

    private GeneralTitleBar titleBar;

    private TextView tvReleaseGuide;
    private LinearLayout lyAddService;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_purchase_order);
        initTitleBar();

        lyAddService = findViewById(R.id.ly_add_service);
        lyAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PurchaseOrderActivity.this, ChooseServiceActvity.class));
            }
        });



        tvReleaseGuide = findViewById(R.id.tv_release_guide);
        SpannableString spStr = new SpannableString(tvReleaseGuide.getText());
//        spStr.setSpan(new ForegroundColorSpan(Color.parseColor("#2873FF")), 12,spStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvReleaseGuide.setText(spStr);

        tvReleaseGuide.setMovementMethod(LinkMovementMethod.getInstance());
        spStr.setSpan(new ClickableSpan(){
            @Override
            public void onClick(View widget) {
                Toast.makeText(PurchaseOrderActivity.this, "触发点击事件!", Toast.LENGTH_SHORT).show();
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
        titleBar = findViewById(R.id.purchase_order_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleText("填写采购单");
        titleBar.showDivierLine(true);
    }
}
