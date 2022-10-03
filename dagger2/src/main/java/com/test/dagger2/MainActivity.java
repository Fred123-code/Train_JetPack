package com.test.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.test.dagger2.contants.Dagger2Contants;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Context mContext;
    private LinearLayout mLinearLayout;
    private String a;
    private String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getBaseContext();

        mLinearLayout = findViewById(R.id.ll_1);
        initJump(Dagger2Contants.EXAMPLE1,Dagger2Contants.EXAMPLE1_PATH);
        initJump(Dagger2Contants.EXAMPLE2,Dagger2Contants.EXAMPLE2_PATH);



    }

    public void onClickBtn(View view) {
        try {
            Class<?> aClass = Class.forName(b);
            Intent intent = new Intent(this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initJump(String name, String path) {
        a = name;
        b = path;
        Button button = new Button(mContext);
        button.setText(a);
        button.setOnClickListener(this::onClickBtn);
        mLinearLayout.addView(button);
    }
}