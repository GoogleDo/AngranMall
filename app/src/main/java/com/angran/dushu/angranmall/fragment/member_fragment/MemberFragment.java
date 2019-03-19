package com.angran.dushu.angranmall.fragment.member_fragment;

import android.os.Bundle;

import com.angran.dushu.angranmall.R;
import com.shizhefei.fragment.LazyFragment;

/**
 * author: Create By dushu on 2019/3/8 00:54
 * email : dushu@bytedance.com
 */
public class MemberFragment extends LazyFragment {

    public final static String TAG = "MemberFragment";

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_member);
    }
}
