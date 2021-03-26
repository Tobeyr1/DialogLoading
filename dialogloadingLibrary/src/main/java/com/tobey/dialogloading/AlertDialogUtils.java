package com.tobey.dialogloading;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class AlertDialogUtils {

    static  SmoothRoundProgressBar smoothProgress;
    /**
     * 加载框
     *
     * @param context
     * @return
     */
    public static AlertDialog loadingDialog(Context context, String message) {
        AlertDialog dialog = new AlertDialog.Builder(context, R.style.NoBackgroundDialog).create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);//按对话框以外的地方不起作用。按返回键还起作用
//        dialog.setCancelable(false);//按对话框以外的地方不起作用。按返回键也不起作用
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        smoothProgress = view.findViewById(R.id.progress_smooth);

        if (!TextUtils.isEmpty(message)) {
            ((TextView) view.findViewById(R.id.tv_message)).setText(message);
        }
        dialog.setContentView(view);
        return dialog;
    }

   public static void setProgressColor(int color){
        smoothProgress.setEndColor(color);
   }



    public static void closeDialog(AlertDialog dialog) {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
