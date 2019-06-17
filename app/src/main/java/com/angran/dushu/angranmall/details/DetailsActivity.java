package com.angran.dushu.angranmall.details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.release.PurchaseOrderActivity;
import com.angran.dushu.angranmall.view.TitleBar.GeneralTitleBar;

import base.BaseActivity;

/**
 * author: Create By dushu on 2019/5/8 22:26
 * email : dushu@bytedance.com
 */
public class DetailsActivity extends BaseActivity {

    private GeneralTitleBar titleBar;

    private TextView tvAsk;
    private TextView tvOrder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_details);
        initTitleBar();

        tvAsk = findViewById(R.id.tv_ask);
        tvAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到电话界面,同时传递电话号
                Intent Intent =  new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + "18686876345"));
                startActivity(Intent);
            }
        });
        tvOrder = findViewById(R.id.tv_order);
        tvOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, PurchaseOrderActivity.class));
            }
        });

    }

    private void initTitleBar() {
        titleBar = findViewById(R.id.details_titlebar);
        titleBar.setLeftButtonListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.showDivierLine(false);
    }
}
