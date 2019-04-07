package com.angran.dushu.angranmall.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.angran.dushu.angranmall.R;

/**
 * author: Create By dushu on 2019/3/20 00:00
 * email : dushu@bytedance.com
 */
public class MsgIcon extends RelativeLayout {

    private ImageView ivMsgTips;
    private RelativeLayout lyMsgIcon;


    public MsgIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.msg_icon, this);
        initView();
    }

    private void initView() {
        lyMsgIcon = findViewById(R.id.ly_msg_icon);
        ivMsgTips = findViewById(R.id.iv_msg_tips);

        lyMsgIcon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转消息页

            }
        });
    }

    public void setNoticeIcon(boolean isGone) {
        if (isGone) {
            lyMsgIcon.setVisibility(View.INVISIBLE);
        } else {
            lyMsgIcon.setVisibility(View.VISIBLE);
        }
    }
}
