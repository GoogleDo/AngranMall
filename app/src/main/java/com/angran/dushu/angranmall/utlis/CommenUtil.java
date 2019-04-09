package com.angran.dushu.angranmall.utlis;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * author: Create By dushu on 2019/4/8 23:18
 * email : dushu@bytedance.com
 */
public class CommenUtil {


    /**
     * 获取当前屏幕宽度
     */
    public static int getScreenWidth(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        return width;
    }

    /**
     * 获取当前屏幕高度
     */
    public static int getScreenHeight(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        return height;
    }

    public static int getStateBarHright(Context context) {
        Class c = null;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            int statusBarHeight = context.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DisplayUtil.dipToPix(context, 20);
    }
}
