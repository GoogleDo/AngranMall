package com.angran.dushu.angranmall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * author: Create By dushu on 2019/6/13 10:44
 * email : dushu@bytedance.com
 * 标签组件
 */
public class TagText extends android.support.v7.widget.AppCompatTextView implements View.OnClickListener {

    public static final String TAG = "TagText";

    public TagText(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public TagText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(this);
    }

    public TagText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.e(TAG,"tagText.isEnabled()" + this.isEnabled());
        if (this.isSelected()) {
            this.setSelected(false);
        } else {
            this.setSelected(true);
        }
    }
}
