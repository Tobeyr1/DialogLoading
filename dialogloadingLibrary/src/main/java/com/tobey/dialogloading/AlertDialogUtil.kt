package com.tobey.dialogloading

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

/**
 *  @Package:        com.tobey.dialogloading
 * @ClassName:      AlertDialogUtil
 * @Author:         Tobey_r1
 * @CreateDate:     2021/8/13 20:44
 * @Description:     java类作用描述
 * @UpdateUser:        更新者
 * @UpdateDate:     2021/8/13 20:44
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
class AlertDialogUtil {

    companion object{
        private var smoothProgress:SmoothRoundProgressBar? = null
        fun createLoading(context: Context, msg:String):AlertDialog{
            val dialog = AlertDialog.Builder(context,R.style.NoBackgroundDialog).create()
            val view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
            smoothProgress = view.findViewById(R.id.progress_smooth)
            dialog.apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCanceledOnTouchOutside(false)
                setCancelable(false)
            }.show()
            dialog. setContentView(view)
            view.findViewById<TextView>(R.id.tv_message).text = msg
            return dialog
        }
        fun setProgressColor(color:Int){
            smoothProgress!!.endColor = color
        }
        fun closeDialog(dialog: AlertDialog){
            dialog?.let {
                it.dismiss()
                smoothProgress?.clearFocus()
                smoothProgress = null
            }
        }
    }
}