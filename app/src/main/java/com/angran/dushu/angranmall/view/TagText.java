package com.angran.dushu.angranmall.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * author: Create By dushu on 2019/6/13 10:44
 * email : dushu@bytedance.com
 * 标签组件
 */
public class TagText extends android.support.v7.widget.AppCompatTextView {

    private static final String TAG = "TagText";

    public TagText(Context context) {
        super(context);
    }

    public TagText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public boolean isSelected() {
        return isEnabled();
    }

    public void setSelected(boolean Selected) {
        setEnabled(Selected);
    }






}
