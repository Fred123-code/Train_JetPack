package com.test.customs_ioc_annnation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.ioc_annation_lib.InjectTool;
import com.test.ioc_annation_lib.annation.BindView;
import com.test.ioc_annation_lib.annation.ContentView;
import com.test.ioc_annation_lib.annnation_common.onClickCommon;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_1)
    Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        InjectTool.inject(this);

    }

    @onClickCommon(R.id.btn_1)
    public void show1() {

    }
}