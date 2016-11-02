package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.GdpsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/10/26.
 */

public class GdpsFragment extends Fragment {


    private TextView tv_gdps_num;
    private ListView lv_gdps;
    private View view;
    private GdpsAdapter gdpsAdapter;
    public GdpsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gdps,null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_gdps_num = (TextView) view.findViewById(R.id.tv_gdps_num);
        lv_gdps = (ListView) view.findViewById(R.id.listview_gdps);
        //实验数据
        List<String> list = new ArrayList<>();
        list.add("试验数据1");
        list.add("试验数据2");
        gdpsAdapter = new GdpsAdapter(getActivity(),list);
        lv_gdps.setAdapter(gdpsAdapter);

    }
}
