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
 * 采购单
 */
public class PurchaseOrderActivity extends BaseActivity {

    private static final String TAG = "PurchaseOrderActivity";

    private GeneralTitleBar titleBar;

    private TextView tvReleaseGuide;
    private LinearLayout lyAddService;

    private LinearLayout lyPay_1;
    private TextView tvPayWay_1;
    private TextView tvPayDetails_1;

    private LinearLayout lyPay_2;
    private TextView tvPayWay_2;
    private TextView tvPayDetails_2;

    private LinearLayout lyPay_3;
    private TextView tvPayWay_3;
    private TextView tvPayDetails_3;




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

        lyPay_1 = findViewById(R.id.ly_pay_1);
        lyPay_2 = findViewById(R.id.ly_pay_2);
        lyPay_3 = findViewById(R.id.ly_pay_3);

        tvPayWay_1 = findViewById(R.id.tv_pay_way_1);
        tvPayWay_2 = findViewById(R.id.tv_pay_way_2);
        tvPayWay_3 = findViewById(R.id.tv_pay_way_3);

        tvPayDetails_1 = findViewById(R.id.tv_pay_details_1);
        tvPayDetails_2 = findViewById(R.id.tv_pay_details_2);
        tvPayDetails_3 = findViewById(R.id.tv_pay_details_3);

        //交易方式--互斥选中状态
        initPayAction();



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

    private void initPayAction() {
        lyPay_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyPay_1.setBackgroundResource(R.drawable.order_bg_select);
                tvPayWay_1.setTextColor(Color.parseColor("#BE985A"));
                tvPayDetails_1.setTextColor(Color.parseColor("#BE985A"));

                lyPay_2.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_2.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_2.setTextColor(Color.parseColor("#A0A0A0"));

                lyPay_3.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_3.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_3.setTextColor(Color.parseColor("#A0A0A0"));
            }
        });

        lyPay_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyPay_1.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_1.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_1.setTextColor(Color.parseColor("#A0A0A0"));

                lyPay_2.setBackgroundResource(R.drawable.order_bg_select);
                tvPayWay_2.setTextColor(Color.parseColor("#BE985A"));
                tvPayDetails_2.setTextColor(Color.parseColor("#BE985A"));

                lyPay_3.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_3.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_3.setTextColor(Color.parseColor("#A0A0A0"));
            }
        });

        lyPay_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyPay_1.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_1.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_1.setTextColor(Color.parseColor("#A0A0A0"));

                lyPay_2.setBackgroundResource(R.drawable.order_bg_unselect);
                tvPayWay_2.setTextColor(Color.parseColor("#565656"));
                tvPayDetails_2.setTextColor(Color.parseColor("#A0A0A0"));

                lyPay_3.setBackgroundResource(R.drawable.order_bg_select);
                tvPayWay_3.setTextColor(Color.parseColor("#BE985A"));
                tvPayDetails_3.setTextColor(Color.parseColor("#BE985A"));
            }
        });

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
