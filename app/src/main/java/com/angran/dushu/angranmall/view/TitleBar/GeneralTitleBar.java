package com.angran.dushu.angranmall.view.TitleBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.angran.dushu.angranmall.R;

/**
 * author: Create By dushu on 2019/3/2 16:08
 * email : dushu@bytedance.com
 * 通用titlebar
 */
public class GeneralTitleBar extends RelativeLayout {
    public final static String TAG = "GeneralTitleBar";

    private ImageView ivBackBtn;
    private TextView tvTitleText;


    public GeneralTitleBar(Context context) {
        super(context);
    }

    public GeneralTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this);
        initView();
    }

    private void initView() {
        ivBackBtn = findViewById(R.id.iv_back_left);
        tvTitleText = findViewById(R.id.tv_title_text);
    }

    // 为左侧返回按钮添加自定义点击事件
     public void setLeftButtonListener(OnClickListener listener) {
         ivBackBtn.setOnClickListener(listener);
    }

    public GeneralTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

// 设置标题的方法
     public void setTitleText(String title) {
         if (!tvTitleText.isShown()) {
             tvTitleText.setVisibility(View.VISIBLE);
         }
         tvTitleText.setText(title);
    }


}
