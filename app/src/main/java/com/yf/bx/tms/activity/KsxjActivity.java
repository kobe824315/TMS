package com.yf.bx.tms.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.TxxjFragmentPagerAdapter;
import com.yf.bx.tms.fragment.CssbFragment;
import com.yf.bx.tms.fragment.JfhjFragment;
import com.yf.bx.tms.fragment.JhsbFragment;
import com.yf.bx.tms.fragment.MxjglFragment;
import com.yf.bx.tms.fragment.PxsbFragment;
import com.yf.bx.tms.fragment.Txdy1Fragment;
import com.yf.bx.tms.fragment.Txdy2Fragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;
//巡检业务中 开始巡检 不是春秋检的巡检界面
public class KsxjActivity extends AutoLayoutActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener,ViewPager.OnPageChangeListener{

    private ImageButton ib_back,ib_wwyt;
    private TextView tv_notice;
    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
    private ViewPager viewpager;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private List<Fragment> fragments;
    private JfhjFragment jfhjFragment;
    private Txdy1Fragment txdy1Fragment;
    private Txdy2Fragment txdy2Fragment;
    private CssbFragment cssbFragment;
    private JhsbFragment jhsbFragment;
    private PxsbFragment pxsbFragment;
    private MxjglFragment mxjglFragment;
    private TxxjFragmentPagerAdapter txxjFragmentPagerAdapter;

    private int ck_type = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ksxj);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        initView();
        initData();
        initListener();
        //在巡检业务界面点击查看后根据选择条目跳转
        Intent intent_ck = getIntent();
        if (intent_ck!=null){
        ck_type = intent_ck.getIntExtra("ck",-1);
            if (ck_type!=-1)
            jump(ck_type);
        }

    }
    public void jump(int i){
        switch (i){
            case 1:
                rb1.setChecked(true);
                break;
            case 2:
                rb2.setChecked(true);
                break;
            case 3:
                rb3.setChecked(true);
                break;
            case 4:
                rb4.setChecked(true);
                break;
            case 5:
                rb5.setChecked(true);
                break;
            case 6:
                rb6.setChecked(true);
                break;
            case 7:
                rb7.setChecked(true);
                break;
        }
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewPager_ksxj);
        rg = (RadioGroup) findViewById(R.id.ksxj_rg);
        tv_notice = (TextView) findViewById(R.id.tv_ksxj_notice);
        ib_back = (ImageButton) findViewById(R.id.ib_ksxj_back);
        ib_wwyt = (ImageButton) findViewById(R.id.ib_ksxj_wwyt);
        rb1 = (RadioButton) findViewById(R.id.rb_ksxj_jfhj);
        rb2 = (RadioButton) findViewById(R.id.rb_ksxj_txdy1);
        rb3 = (RadioButton) findViewById(R.id.rb_ksxj_txdy2);
        rb4 = (RadioButton) findViewById(R.id.rb_ksxj_cssb);
        rb5 = (RadioButton) findViewById(R.id.rb_ksxj_jhsb);
        rb6 = (RadioButton) findViewById(R.id.rb_ksxj_pxsb);
        rb7 = (RadioButton) findViewById(R.id.rb_ksxj_mxjgl);
        viewpager.setOffscreenPageLimit(7);
    }


    private void initData() {
        fragments = new ArrayList<>();
        jfhjFragment = new JfhjFragment();
        txdy1Fragment = new Txdy1Fragment();
        txdy2Fragment = new Txdy2Fragment();
        cssbFragment = new CssbFragment();
        jhsbFragment = new JhsbFragment();
        pxsbFragment = new PxsbFragment();
        mxjglFragment = new MxjglFragment();
        fragments.add(jfhjFragment);
        fragments.add(txdy1Fragment);
        fragments.add(txdy2Fragment);
        fragments.add(cssbFragment);
        fragments.add(jhsbFragment);
        fragments.add(pxsbFragment);
        fragments.add(mxjglFragment);
        txxjFragmentPagerAdapter = new TxxjFragmentPagerAdapter(fm,fragments);
        viewpager.setAdapter(txxjFragmentPagerAdapter);
        rb1.setChecked(true);
    }

   private void initListener(){
       rg.setOnCheckedChangeListener(this);
       ib_back.setOnClickListener(this);
       ib_wwyt.setOnClickListener(this);
       tv_notice.setOnClickListener(this);
       viewpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_ksxj_jfhj:
                viewpager.setCurrentItem(0);
                break;
            case R.id.rb_ksxj_txdy1:
                viewpager.setCurrentItem(1);
                break;
            case R.id.rb_ksxj_txdy2:
                viewpager.setCurrentItem(2);
                break;
            case R.id.rb_ksxj_cssb:
                viewpager.setCurrentItem(3);
                break;
            case R.id.rb_ksxj_jhsb:
                viewpager.setCurrentItem(4);
                break;
            case R.id.rb_ksxj_pxsb:
                viewpager.setCurrentItem(5);
                break;
            case R.id.rb_ksxj_mxjgl:
                viewpager.setCurrentItem(6);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_ksxj_notice:
                break;
            case R.id.ib_ksxj_back:
                finish();
                break;
            case R.id.ib_ksxj_wwyt:
                Intent intent = new Intent(this,XjywWwytActivity.class);
                int i = viewpager.getCurrentItem();
                intent.putExtra("currentItem",i);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
         RadioButton radioButton = (RadioButton) rg.getChildAt(position);
          radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
