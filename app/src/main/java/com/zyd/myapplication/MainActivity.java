package com.zyd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zyd.myapplication.activity.BaseActivity;
import com.zyd.myapplication.activity.GoodsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView main_goods,main_time,main_bluetooth;
    private TimePickerView pvTime = null;
    private OptionsPickerView optionsPicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        main_goods = findViewById(R.id.main_goods);
        main_time = findViewById(R.id.main_time);
        main_bluetooth = findViewById(R.id.main_bluetooth);
        main_goods.setOnClickListener(this);
        main_time.setOnClickListener(this);
        main_bluetooth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_goods:
                startActivity(new Intent(this, GoodsActivity.class));
                break;
            case R.id.main_time:
//                showTimePick();
                showTimePick2();
                break;
            case R.id.main_bluetooth:
                Toast.makeText(this,"Link Bluetooth",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showTimePick2(){
        if (optionsPicker == null){
            List<String> list1 = new ArrayList<>();
            for (int i = 0;i<60; i++){
                list1.add(i+"");
            }
            List<List<String>> list2 = new ArrayList<>();
            for (int i=0;i<60; i++){
                list2.add(list1);
            }
            List<List<List<String>>> list3 = new ArrayList<>();
            for (int i=0;i<60; i++){
                list3.add(list2);
            }
            optionsPicker = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                    String shi = list1.get(options1);
                    if (shi.length()==1){
                        shi = "0"+shi;
                    }
                    String fen = list2.get(options1).get(options2);
                    if (fen.length()==1){
                        fen = "0"+fen;
                    }
                    String miao = list3.get(options1).get(options2).get(options3);
                    if (miao.length()==1){
                        miao = "0"+miao;
                    }
                    main_time.setText(shi+":"+fen+":"+miao);
                }
            })
                    .setCancelText("Cancel")//取消按钮文字
                    .setSubmitText("Sure")//确认按钮文字
                    .setLabels("H","M","S")
                    .build();
            optionsPicker.setPicker(list1, list2, list3);
        }
        optionsPicker.show();
    }

    private void showTimePick(){
        if (pvTime == null){
            pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    main_time.setText(sdf.format(date));
                }
            })
                    .setType(new boolean[]{false, false, false, true, true, true})
                    .setCancelText("Cancel")//取消按钮文字
                    .setSubmitText("Sure")//确认按钮文字
                    .setLabel("Y","M","D","H","M","S")
                    .build();
        }
        pvTime.show();
    }
}