package com.angran.dushu.angranmall.fragment.home_fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.angran.dushu.angranmall.R;

import java.util.List;

/**
 * author: Create By dushu on 2019/4/7 22:20
 * email : dushu@bytedance.com
 */
public class MainListAdapterL extends RecyclerView.Adapter<MainListAdapterL.MainListHolderL> {

    private List<Integer> mDatas;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public MainListAdapterL(List<Integer> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Log.e("MainListAdapterL", "MainListAdapterL.ItemCount = "+getItemCount());
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
    public MainListHolderL onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_main_recycler_l,parent,false);
        MainListHolderL viewHolder = new MainListHolderL(itemView);
        return viewHolder;
    }


    /**
     * 绑定viewholder
     * 在此方法中完成对view显示内容，设置数据的工作
     */
    @Override
    public void onBindViewHolder(@NonNull MainListHolderL holder, int position) {
        holder.ivAvater.setImageResource(mDatas.get(position));
        if (position == getItemCount()) {
            holder.vItemDivier.setVisibility(View.GONE);
        }
        setEvent(holder);
    }

    public void setEvent(final MainListHolderL holder){
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



    public static class MainListHolderL extends RecyclerView.ViewHolder {

        ImageView ivAvater;
        View vItemDivier;

        public MainListHolderL(View itemView) {
            super(itemView);
            ivAvater = itemView.findViewById(R.id.iv_item_avater);
            vItemDivier = itemView.findViewById(R.id.item_divier);
        }
    }

    /**
     * 插入数据的方法 (带索引)
     */
    public void addItem(int pos, int obj) {
        mDatas.add(pos, obj);
        //增加数据，并且提示更新
        notifyItemInserted(pos);
    }

    /**
     * 增加数据的方法 (不带索引)
     */
    public void addItem(List<Integer> list) {
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
