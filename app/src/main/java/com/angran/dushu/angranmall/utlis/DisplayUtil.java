package com.angran.dushu.angranmall.utlis;

import android.content.Context;
import android.util.TypedValue;

/**
 * author: Create By dushu on 2019/4/7 21:38
 * email : dushu@bytedance.com
 */
public class DisplayUtil {
    /**
     * 根据dip值转化成px值
     *
     * @param context
     * @param dip
     * @return
     */
    public static int dipToPix(Context context, int dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
        return size;
    }
}
