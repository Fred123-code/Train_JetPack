package com.test.train_jetpack.binding

import android.R
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.test.architecture.utils.ClickUtils

@SuppressWarnings("unused")
object CommonBindingAdapter {
    //  use  kotlin-kapt
    // 要在 Kotlin 中使用数据绑定注释，请在模块的 build.gradle 中应用“kotlin-kapt”插件

    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
    fun loadUrl(view: ImageView, url: String?, placeHolder: Drawable?) {
        Glide.with(view.context).load(url).placeholder(placeHolder).into(view)
    }

    @BindingAdapter(value = ["visible"], requireAll = false)
    fun visible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter(value = ["showDrawable", "drawableShowed"], requireAll = false)
    fun showDrawable(view: ImageView, showDrawable: Boolean, drawableShowed: Int) {
        view.setImageResource(if (showDrawable) drawableShowed else R.color.transparent)
    }

    @BindingAdapter(value = ["textColor"], requireAll = false)
    fun setTextColor(textView: TextView, textColorRes: Int) {
        textView.setTextColor(textView.resources.getColor(textColorRes))
    }

    @BindingAdapter(value = ["imageRes"], requireAll = false)
    fun setImageRes(imageView: ImageView, imageRes: Int) {
        imageView.setImageResource(imageRes)
    }

    @BindingAdapter(value = ["selected"], requireAll = false)
    fun selected(view: View, select: Boolean) {
        view.isSelected = select
    }

    @JvmStatic
    @BindingAdapter(value = ["onClickWithDebouncing"], requireAll = false)
    fun onClickWithDebouncing(view: View?, clickListener: View.OnClickListener?) {
        ClickUtils.applySingleDebouncing(view, clickListener)
    }
}