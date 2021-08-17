package com.tobey.dialogloading

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

@SuppressLint("StaticFieldLeak")
object GifDialog {

       private var tipTextView: TextView? = null
       private  var mContext: Context? = null
       private var img: GifImageView? = null
       private var gifLayout: LinearLayout? = null

       fun createDialog(context: Context?, msg: String?): Dialog {
              mContext = context
              val inflater = LayoutInflater.from(context)
              val v = inflater.inflate(R.layout.dialog_gif_loading, null) // 得到加载view
              val layout = v.findViewById<LinearLayout>(R.id.loading_view) // 加载布局
              tipTextView = v.findViewById<TextView>(R.id.loading_message)
              tipTextView!!.text = msg
              gifLayout = v.findViewById(R.id.gifLayout)
              img = v.findViewById(R.id.giftView)
              val loadingDialog = Dialog(context!!, R.style.MyDialogStyle) // 创建自定义样式dialog
              loadingDialog.apply {
                     setCancelable(true)
                     setCanceledOnTouchOutside(false)
                     setContentView(
                            layout, LinearLayout.LayoutParams(
                                   LinearLayout.LayoutParams.MATCH_PARENT,
                                   LinearLayout.LayoutParams.MATCH_PARENT
                            )
                     )
              }.show()
              /**
              * 将显示Dialog的方法封装在这里面
              */
              val window = loadingDialog.window
              val lp = window!!.attributes
              lp.width = WindowManager.LayoutParams.MATCH_PARENT
              lp.height = WindowManager.LayoutParams.MATCH_PARENT
              window.apply {
                     setGravity(Gravity.CENTER)
                     attributes = lp
                     setWindowAnimations(R.style.PopWindowAnimStyle)
              }
              return loadingDialog
       }

       fun closeDialog(mDialogUtils: Dialog?) {
              if (mDialogUtils != null && mDialogUtils.isShowing) {
                     mDialogUtils.dismiss()
              }
              img?.clearFocus()
              img = null
              tipTextView = null
              gifLayout = null
              mContext = null
       }

       /** 设置显示消息颜色
        * @param color 文本颜色
        */
       fun setTextColor(color: Int) {
              tipTextView!!.setTextColor(mContext!!.resources.getColor(color))
       }

       /** 设置弹窗窗体颜色
        * @param color 文本颜色
        */
       fun setlayoutBackGroundColor(color: Int) {
              gifLayout!!.setBackgroundColor(color)
       }

       /** 设置弹窗圆角颜色
        * @param drawable 图片资源
        */
       fun setlayoutBackGround(drawable: Drawable?) {
              gifLayout!!.background = drawable
       }

       /** 设置显示消息颜色
        */
       fun setImageBackGround(stlyle: Int) {
              if (isDrawable(stlyle, mContext)) {
                     img!!.setImageResource(stlyle)
              }
       }

       private fun isDrawable(id: Int, context: Context?): Boolean {
              val options = BitmapFactory.Options()
              val res = context!!.resources
              options.inJustDecodeBounds = true
              BitmapFactory.decodeResource(res, id,options)
              val type = options.outMimeType
              if (type.isNotEmpty()){
                     return  when(type.substring(6, type.length)){
                            "gif" ->  true
                            else -> {
                                   Log.e("image type -> ", type)
                                   false
                            }
                     }
              }
              Log.e(TAG, "内存不足，自动回收")
              return false
       }
}

