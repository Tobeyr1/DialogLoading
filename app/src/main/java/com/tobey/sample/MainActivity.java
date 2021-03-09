package com.tobey.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import com.tobey.dialogloading.DialogUtil;

public class MainActivity extends AppCompatActivity {
    private static Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog dialog = DialogUtil.createLoadingDialog(this,"测试ing...");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogUtil.closeDialog(dialog);
            }
        },4000);


    }
}
