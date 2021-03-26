package com.tobey.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import com.tobey.dialogloading.AlertDialogUtils;
import com.tobey.dialogloading.DialogUtil;
import com.tobey.dialogloading.SmoothRoundProgressBar;

public class MainActivity extends AppCompatActivity {
    private static Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // final Dialog dialog = DialogUtil.createLoadingDialog(this,"加载中...");
        final AlertDialog dialog = AlertDialogUtils.loadingDialog(this,"登录中...");
       AlertDialogUtils.setProgressColor(getResources().getColor(R.color.colorAccent));
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
            //    DialogUtil.closeDialog(dialog);
           //     AlertDialogUtils.closeDialog(dialog);
            }
        },5000);


    }
}
