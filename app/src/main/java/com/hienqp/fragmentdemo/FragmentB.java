package com.hienqp.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // chỉnh sửa return view của Fragment thông qua inflater bởi method inflate
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
