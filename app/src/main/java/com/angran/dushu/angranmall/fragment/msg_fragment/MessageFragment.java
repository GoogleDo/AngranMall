package com.angran.dushu.angranmall.fragment.msg_fragment;

import android.os.Bundle;

import com.angran.dushu.angranmall.R;
import com.shizhefei.fragment.LazyFragment;

/**
 * author: Create By dushu on 2019/3/8 00:57
 * email : dushu@bytedance.com
 */
public class MessageFragment extends LazyFragment {


    public final static String TAG = "MessageFragment";

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_msg);

    }
}
