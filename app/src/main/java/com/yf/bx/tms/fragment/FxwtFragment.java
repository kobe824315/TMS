package com.yf.bx.tms.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;
import com.yf.bx.tms.adapter.FxwtAdapter;
import com.yf.bx.tms.bean.FxwtBean;
import com.yf.bx.tms.utils.SelectDateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**发现问题
 * Created by 123 on 2016/11/7.
 */

public class FxwtFragment extends CommonFra {

    private View view;
    private ListView lv;
    private List<FxwtBean> list;
    private FxwtAdapter fxwtAdapter;
    private AppContext appContext;
    private Spinner spi_txz,spi_sfxq,spi_xjlx,spi_jcxm;
    private EditText et_xjdw,et_jcfzr;
    private TextView tv_jcsj,tv_jcsj2;
    private FragmentManager fm;
    private ArrayAdapter<String> adapter_jcxm;

    public FxwtFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fxwt,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv_fxwt);
        et_xjdw = (EditText) view.findViewById(R.id.spi_xjyw_xjdw);
        spi_txz = (Spinner) view.findViewById(R.id.spi_xjyw_txz);
        et_jcfzr = (EditText) view.findViewById(R.id.spi_xjyw_jcfzr);
        tv_jcsj = (TextView) view.findViewById(R.id.spi_xjyw_jcsj);
        tv_jcsj2 = (TextView) view.findViewById(R.id.spi_xjyw_jcsj2);
        spi_sfxq = (Spinner) view.findViewById(R.id.spi_fxwt_sfxq);
        spi_xjlx = (Spinner) view.findViewById(R.id.spi_fxwt_xjlx);
        spi_jcxm = (Spinner) view.findViewById(R.id.spi_fxwt_jcxm);
        appContext = (AppContext) getActivity().getApplicationContext();
        spi_txz.setAdapter(appContext.getAdapter_txz(getActivity()));
        spi_sfxq.setAdapter(appContext.getAdapter_isXiaoque(getActivity()));
        list = new ArrayList<>();
        FxwtBean fxwtBean1 = new FxwtBean();
        fxwtBean1.setXjdw("信息通信运检中心");
        fxwtBean1.setTxz("500kV大泽变");
        fxwtBean1.setJcsj("2016.11.15");
        fxwtBean1.setJcfzr("张铎");
        fxwtBean1.setJcxm("机房空调运行情况");
        fxwtBean1.setYcyy("空调异响");
        fxwtBean1.setIsyxq("是");
        FxwtBean fxwtBean2 = new FxwtBean();
        fxwtBean2.setXjdw("信息通信运检中心");
        fxwtBean2.setTxz("500kV文亭变");
        fxwtBean2.setJcsj("2016.11.15");
        fxwtBean2.setJcfzr("张铎");
        fxwtBean2.setJcxm("风扇运行是否正常");
        fxwtBean2.setYcyy("风扇转速过慢");
        fxwtBean2.setIsyxq("是");
        FxwtBean fxwtBean3 = new FxwtBean();
        fxwtBean3.setXjdw("信息通信运检中心");
        fxwtBean3.setTxz("500kV德州变");
        fxwtBean3.setJcsj("2016.11.15");
        fxwtBean3.setJcfzr("张铎");
        fxwtBean3.setJcxm("防雷器件");
        fxwtBean3.setYcyy("异常");
        fxwtBean3.setIsyxq("是");
        list.add(fxwtBean1);
        list.add(fxwtBean2);
        list.add(fxwtBean3);
        fm = getActivity().getSupportFragmentManager();
        SelectDateUtils.selectDate(fm,tv_jcsj);
        SelectDateUtils.selectDate(fm,tv_jcsj2);
        String[] xjlx = {"巡检业务","春秋检业务"};
        final String[][] jcxm = {{"机房环境","通信电源Ⅰ","通信电源Ⅱ","传输设备","交换设备","配线设备","门型架光缆"},
                {"通讯站安全检查","站内光缆安全检查","ADSS光缆安全检查","OPGW光缆安全检查","普通光缆安全检查","备用纤芯安全检查",
                        "通信电源系统","通信电源-蓄电池","微波设备安全检查","光传输设备安全检查","交换设备安全检查","电视电话会议系统",
                        "电视电话会议系统","数据网设备安全检查","同步设备安全检查","网关系统安全检查","通信运行方式及重要业务通道"}};
        ArrayAdapter<String> adapter_xjlx = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,xjlx);
        adapter_jcxm = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,jcxm[0]);
        spi_jcxm.setAdapter(adapter_jcxm);
        spi_xjlx.setAdapter(adapter_xjlx);
        spi_xjlx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter_jcxm = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line,jcxm[position]);
                spi_jcxm.setAdapter(adapter_jcxm);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fxwtAdapter = new FxwtAdapter(getActivity(),list);
        lv.setAdapter(fxwtAdapter);
    }


}
