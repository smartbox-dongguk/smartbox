package com.zyd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zyd.myapplication.activity.BaseActivity;
import com.zyd.myapplication.activity.GoodsActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView main_goods,main_time;
    private TimePickerView pvTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        main_goods = findViewById(R.id.main_goods);
        main_time = findViewById(R.id.main_time);
        main_goods.setOnClickListener(this);
        main_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_goods:
                startActivity(new Intent(this, GoodsActivity.class));
                break;
            case R.id.main_time:
                showTimePick();
                break;
        }
    }

    private void showTimePick(){
        if (pvTime == null){
            pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                    main_time.setText(sdf.format(date));
                }
            })
                    .setType(new boolean[]{false, false, false, false, true, true})
                    .setCancelText("Cancel")//取消按钮文字
                    .setSubmitText("Sure")//确认按钮文字
                    .setLabel("Y","M","D","H","M","S")
                    .build();
        }
        pvTime.show();
    }
}