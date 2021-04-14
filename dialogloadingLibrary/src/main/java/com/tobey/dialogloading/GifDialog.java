package com.tobey.dialogloading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.lang.ref.SoftReference;

import pl.droidsonroids.gif.GifImageView;

/**
 * @Package: com.tobey.dialogloading
 * @ClassName: GifDialog
 * @Author: Tobey_r1
 * @CreateDate: 2021/4/13 14:22
 * @Description: java类作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/13 14:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GifDialog {

    private static String TAG = "com.tobey.gitdialog";

    public static boolean isclose = false;
    private static TextView tipTextView;
    private static GifImageView img;
    private static LinearLayout gifLayout;
    private static Context mContext;

    public static Dialog createDialog(Context context, String msg) {
        isclose = false;
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_gif_loading, null);// 得到加载view
        LinearLayout layout = v.findViewById(R.id.loading_view);// 加载布局
        tipTextView = v.findViewById(R.id.loading_message);// 提示文字
        gifLayout = v.findViewById(R.id.gifLayout);
        tipTextView.setText(msg);// 设置加载信息
        img = v.findViewById(R.id.giftView);
        Dialog loadingDialog = new Dialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
        loadingDialog.setCancelable(true); // 是否可以按“返回键”消失
        loadingDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        // 设置布局
        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        //lp.type = lp.TYPE_PHONE;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        loadingDialog.show();
        return loadingDialog;
    }

    public static void closeDialog(Dialog mDialogUtils) {

        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
            isclose = true;
        }
    }


    /** 设置显示消息颜色
     * @param color 文本颜色
     */
    public static void setTextColor(int color){
        tipTextView.setTextColor(mContext.getResources().getColor(color));
    }

    /** 设置弹窗窗体颜色
     * @param color 文本颜色
     */
    public static void setlayoutBackGroundColor(int color){
        gifLayout.setBackgroundColor(color);
    }

    /** 设置弹窗圆角颜色
     * @param drawable 图片资源
     */
    public static void setlayoutBackGround(Drawable drawable){
        gifLayout.setBackground(drawable);
    }

    /** 设置显示消息颜色
     */
    public static void setImageBackGround(int stlyle){
        if (isDrawable(stlyle,mContext)){
            img.setImageResource(stlyle);
        }

    }

    private static boolean isDrawable(int id,Context context){
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources res = context.getResources();
        SoftReference<BitmapFactory.Options> softReference = new SoftReference<>(options);
        if (softReference !=null){
            softReference.get().inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res,id,options);
            String type = options.outMimeType;
            if (TextUtils.isEmpty(type)) {
                Log.e(TAG,"未能识别的图片");
                return false;
            } else if (type.substring(6, type.length()).equals("gif")){
                return true;
            }else {
                type = type.substring(6, type.length());
                Log.e("image type -> ", type);
                return false;
            }

        }else {
            Log.e(TAG,"内存不足，自动回收");
            return false;
        }

    }


}
