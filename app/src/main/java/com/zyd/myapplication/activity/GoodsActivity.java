package com.zyd.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.zyd.myapplication.R;
import com.zyd.myapplication.view.BaseTitleLayout;

public class GoodsActivity extends BaseActivity implements View.OnClickListener {

    private BaseTitleLayout base_title_layout;
    private LinearLayout valve_1,valve_2,valve_3,valve_4;
    private View valve_1_view,valve_2_view,valve_3_view,valve_4_view;
    private boolean isShow_1 = true;
    private boolean isShow_2 = true;
    private boolean isShow_3 = true;
    private boolean isShow_4 = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        initView();
    }

    private void initView(){
        base_title_layout = findViewById(R.id.base_title_layout);
        base_title_layout.setTitle("Goods");
        valve_1 = findViewById(R.id.valve_1);
        valve_2 = findViewById(R.id.valve_2);
        valve_3 = findViewById(R.id.valve_3);
        valve_4 = findViewById(R.id.valve_4);
        valve_1_view = findViewById(R.id.valve_1_view);
        valve_2_view = findViewById(R.id.valve_2_view);
        valve_3_view = findViewById(R.id.valve_3_view);
        valve_4_view = findViewById(R.id.valve_4_view);
        valve_1.setOnClickListener(this);
        valve_2.setOnClickListener(this);
        valve_3.setOnClickListener(this);
        valve_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.valve_1:
                if (isShow_1){
                    valve_1_view.setBackgroundResource(R.color.touming);
                }else {
                    valve_1_view.setBackgroundResource(R.color.black);
                }
                isShow_1 = !isShow_1;
                break;
            case R.id.valve_2:
                if (isShow_2){
                    valve_2_view.setBackgroundResource(R.color.touming);
                }else {
                    valve_2_view.setBackgroundResource(R.color.black);
                }
                isShow_2 = !isShow_2;
                break;
            case R.id.valve_3:
                if (isShow_3){
                    valve_3_view.setBackgroundResource(R.color.touming);
                }else {
                    valve_3_view.setBackgroundResource(R.color.black);
                }
                isShow_3 = !isShow_3;
                break;
            case R.id.valve_4:
                if (isShow_4){
                    valve_4_view.setBackgroundResource(R.color.touming);
                }else {
                    valve_4_view.setBackgroundResource(R.color.black);
                }
                isShow_4 = !isShow_4;
                break;
        }
    }
}
