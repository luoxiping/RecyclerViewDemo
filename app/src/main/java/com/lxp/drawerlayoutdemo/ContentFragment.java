package com.lxp.drawerlayoutdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/9/19.
 */
public class ContentFragment extends Fragment {
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mTextView = (TextView) view.findViewById(R.id.textview);
        String text = getArguments().getString("text");
        mTextView.setText(text);
        return view;
    }
}
