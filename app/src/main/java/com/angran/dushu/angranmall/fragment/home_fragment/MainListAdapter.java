package com.angran.dushu.angranmall.fragment.home_fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListHolder> {

    private List<Integer> mDatas;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public MainListAdapter(List<Integer> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        public void OnItemClick(View itemView, int position);

        public void onItemLongClick(View itemView, int position);
    }

    @NonNull
    @Override
    public MainListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_main_recycler,parent,false);
        MainListHolder viewHolder = new MainListHolder(itemView);
        return viewHolder;
    }


    /**
     * 绑定viewholder
     * 在此方法中完成对view显示内容，设置数据的工作
     */
    @Override
    public void onBindViewHolder(@NonNull MainListHolder holder, int position) {
        holder.ivAvater.setImageResource(mDatas.get(position));
        setEvent(holder);
    }

    public void setEvent(final MainListHolder holder){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();    //获取当前获得焦点的位置
                listener.OnItemClick(holder.itemView,pos);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                listener.onItemLongClick(holder.itemView,pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    class MainListHolder extends RecyclerView.ViewHolder {

        ImageView ivAvater;

        public MainListHolder(View itemView) {
            super(itemView);
            ivAvater = itemView.findViewById(R.id.iv_item_avater);
        }
    }

    /**
     * 增加数据的方法
     */
    public void addItem(int pos, int obj) {
        mDatas.add(pos, obj);
        //增加数据，并且提示更新
        notifyItemInserted(pos);
    }

    /**
     * 移除数据
     */
    public void removeItem(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}
