package com.dream.net.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dream.net.mobilesafe.R;

/**
 * Created by sunlongxiao on 3/2/15.
 */
public class Setup2ItemView extends RelativeLayout {

    private CheckBox cb_setting_up;
    private TextView tv_setting_up;
    private TextView tv_setting_up_descript;
    private SharedPreferences sp;


    public Setup2ItemView(Context context) {
        super(context);
        initView(context);
    }

    public Setup2ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Setup2ItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context){



        View.inflate(context, R.layout.relative_setting_item, this);

        tv_setting_up = (TextView)findViewById(R.id.tv_setting_up);
        tv_setting_up.setText("sim卡绑定");

        cb_setting_up = (CheckBox)findViewById(R.id.cb_setting_up);
        tv_setting_up_descript = (TextView)findViewById(R.id.tv_setting_up_descript);

        sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);

        boolean status = sp.getBoolean("simBinding", false);



        if(status){
            cb_setting_up.setChecked(true);
            tv_setting_up_descript.setText("sim绑定已开启");

        }else{
            cb_setting_up.setChecked(false);
            tv_setting_up_descript.setText("sim绑定已关闭");
        }

        final SharedPreferences.Editor editor = sp.edit();

        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb_setting_up.isChecked()){
                    cb_setting_up.setChecked(false);
                    tv_setting_up_descript.setText("sim绑定已关闭");
                    editor.putBoolean("simBinding",false);
                }else{
                    cb_setting_up.setChecked(true);
                    tv_setting_up_descript.setText("sim绑定已开启");
                    editor.putBoolean("simBinding",true);
                }
                editor.commit();

            }
        });
    }

    public boolean getStatus(){


        return cb_setting_up.isChecked();


    }


}
