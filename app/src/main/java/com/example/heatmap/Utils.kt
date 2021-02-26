package com.example.heatmap

import android.os.Build
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("changeColor")
fun setPaddingLeft(view: View, value: Float) {

    if(value>100){
        view.setBackgroundColor(view.context.getColor(R.color.max))
    }else
        view.setBackgroundColor(view.context.getColor(R.color.white))
}