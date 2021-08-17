package com.tobey.dialogloading

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView

/**
 *  @Package:        com.tobey.dialogloading
 * @ClassName:      DialogUtils
 * @Author:         Tobey_r1
 * @CreateDate:     2021/8/13 17:19
 * @Description:     java类作用描述
 * @UpdateUser:        更新者
 * @UpdateDate:     2021/8/13 17:19
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
class DialogUtils {

    companion object{

         fun  createLoading(context: Context,msg:String):Dialog{
            val inflate = LayoutInflater.from(context)
            val v = inflate.inflate(R.layout.activity_loading, null)
            val layout = v.findViewById<LinearLayout>(R.id.dialog_loading_view)

            val dialog = Dialog(context,R.style.MyDialogStyle)
            dialog.apply {
                setCancelable(true)
                setCanceledOnTouchOutside(false)
                setContentView(layout,LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT))
            }.show()
             v.findViewById<TextView>(R.id.dialog_loading_tipTextView).text = msg
            val window = dialog.window
            val lp = window!!.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            window.apply {
                setGravity(Gravity.CENTER)
                attributes = lp
                setWindowAnimations(R.style.PopWindowAnimStyle)
            }
            return dialog
        }

         fun closeDialog(dialog: Dialog){
            dialog?.let {
                it.dismiss()
            }

        }
    }


}