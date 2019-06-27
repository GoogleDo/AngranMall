package com.angran.dushu.angranmall.view.ListDataScreenView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.angran.dushu.angranmall.R;
import com.angran.dushu.angranmall.product.AllPreductActivity;
import com.angran.dushu.angranmall.purchase.PurchaseListActivity;


public class ListScreenMenuAdapter extends BaseMenuAdapter{
    private Context mContext;

    public ListScreenMenuAdapter(Context context,String[] mItems){
        this.mContext = context;
        if (mItems != null) {
            this.mItems = mItems;
        }
    }

    private String[] mItems ={"地区","商品","筛选","排序"};

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public View getTabView(int position, ViewGroup parent) {
        TextView tabView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_tab,parent,false);
        tabView.setText(mItems[position]);
        tabView.setTextColor(Color.BLACK);
        return tabView;
    }

    @Override
    public View getMenuView(int position, ViewGroup parent) {
        if (position == 2) {
            View menuView = LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_menu_screen,parent,false);
            Button button = menuView.findViewById(R.id.btn_is_sure_ap);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mContext != null && mContext instanceof AllPreductActivity) {
                        //这里应该先把筛选条件传递出去再关闭，为了演示 先这么写
                        ((AllPreductActivity) mContext).closeMenuView();
                    } else if (mContext != null && mContext instanceof PurchaseListActivity) {
                        ((PurchaseListActivity) mContext).closeMenuView();
                    }
                }
            });
            return menuView;
        }
        // 不同的位置显示的布局不一样
        TextView menuView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_menu,parent,false);
        menuView.setText(mItems[position]);
        return menuView;
    }

    @Override
    public void menuClose(View tabView) {
        TextView tabTv = (TextView) tabView;
        tabTv.setTextColor(Color.BLACK);
    }

    @Override
    public void menuOpen(View tabView) {
        TextView tabTv = (TextView) tabView;
        tabTv.setTextColor(Color.RED);
    }
}
