package com.angran.dushu.angranmall.fragment.home_fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.angran.dushu.angranmall.R;

import java.util.List;

/**
 * author: Create By dushu on 2019/4/7 22:20
 * email : dushu@bytedance.com
 */
public class MainListAdapterR extends RecyclerView.Adapter<MainListAdapterR.MainListHolderR> {

    private List<Boolean> mDatas;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public MainListAdapterR(List<Boolean> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Log.e("MainListAdapterR", "MainListAdapterR.ItemCount = "+getItemCount());
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnItemClickListener {
        void OnItemClick(View itemView, int position);

        void onItemLongClick(View itemView, int position);
    }

    @NonNull
    @Override
    public MainListHolderR onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_main_recycler_r,parent,false);
        MainListHolderR viewHolder = new MainListHolderR(itemView);
        return viewHolder;
    }


    /**
     * 绑定viewholder
     * 在此方法中完成对view显示内容，设置数据的工作
     */
    @Override
    public void onBindViewHolder(@NonNull MainListHolderR holder, int position) {
        if (!mDatas.get(position)) {
            holder.tvProductTitle.setCompoundDrawables(null,null,null,null);
        }
        if (position == getItemCount()) {
            holder.vItemDivier.setVisibility(View.GONE);
        }
        setEvent(holder);
    }

    public void setEvent(final MainListHolderR holder){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();    //获取当前获得焦点的位置
                if (listener != null) {
                    listener.OnItemClick(holder.itemView,pos);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                if (listener != null) {
                    listener.onItemLongClick(holder.itemView,pos);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    public static class MainListHolderR extends RecyclerView.ViewHolder {

        TextView tvProductTitle;
        View vItemDivier;

        public MainListHolderR(View itemView) {
            super(itemView);
            tvProductTitle = itemView.findViewById(R.id.tv_product_title);
            vItemDivier = itemView.findViewById(R.id.item_divier_line);
        }
    }

    /**
     * 插入数据的方法 (带索引)
     */
    public void addItem(int pos, boolean obj) {
        mDatas.add(pos, obj);
        //增加数据，并且提示更新
        notifyItemInserted(pos);
    }

    /**
     * 增加数据的方法 (不带索引)
     */
    public void addItem(List<Boolean> list) {
        mDatas.addAll(list);
        //增加数据，并且提示更新
        notifyDataSetChanged();
    }
    /**
     * 移除数据
     */
    public void removeItem(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}
