package com.zyd.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyd.myapplication.R;

public class BaseTitleLayout extends RelativeLayout {

    private Context context;
    private RelativeLayout activity_base_head_layout;
    private TextView activity_base_head_title;
    private RelativeLayout activity_base_head_return;

    public BaseTitleLayout(Context context) {
        super(context);
        init(context);
    }

    public BaseTitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseTitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context){
        this.context=context;
        LayoutInflater.from(context).inflate(R.layout.activity_base_head,this);
        activity_base_head_layout=(RelativeLayout) findViewById(R.id.activity_base_head_layout);
        activity_base_head_return=(RelativeLayout)findViewById(R.id.activity_base_head_return);
        activity_base_head_title=(TextView)findViewById(R.id.activity_base_head_title);
        activity_base_head_return.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });
    }

    public BaseTitleLayout setTitle(String title){
        activity_base_head_title.setText(title);
        return this;
    }

    public BaseTitleLayout setTitleColor(int color){
        activity_base_head_title.setTextColor(context.getResources().getColor(color));
        return this;
    }

    public BaseTitleLayout setReturnBackVisible(int visible){
        activity_base_head_return.setVisibility(visible);
        return this;
    }

    public BaseTitleLayout setBackground(int resid){
        activity_base_head_layout.setBackgroundResource(resid);
        return this;
    }
}
