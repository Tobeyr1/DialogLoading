package com.tobey.sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;

import com.tobey.dialogloading.AlertDialogUtil;
import com.tobey.dialogloading.Const;
import com.tobey.dialogloading.ConstsKt;
import com.tobey.dialogloading.GifDialog;


public class MainActivity extends AppCompatActivity {
   //  private static Handler mHandler = new Handler();
    private AlertDialog dialog;
    private Dialog dialogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         App.getRefWatcher().watch(this);
      //  dialog = AlertDialogUtil.Companion.createLoading(this,"加载中...");
         dialogs =  GifDialog.INSTANCE.createDialog(this,"ss");
         GifDialog.INSTANCE.setImageBackGround(ConstsKt.getCOOL_BULE());
       // dialogs = DialogUtils.Companion.createLoading(this,"加载中...");
       /* GifDialog.setImageBackGround(R.drawable.loading_normal,this);
        GifDialog.setTextColor(R.color.colorAccent);
        GifDialog.setlayoutBackGround(this.getResources().getDrawable(R.drawable.loading_bg));*/
      //  final Dialog dialog = DialogUtil.createLoadingDialog(this,"加载中");
     //   final AlertDialog dialog = AlertDialogUtils.loadingDialog(this,"登录中...");
     //  AlertDialogUtils.setProgressColor(getResources().getColor(R.color.colorAccent));
      /*  mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GifDialog.INSTANCE.closeDialog(dialogs);
            }
        },5000);*/


    }
}
