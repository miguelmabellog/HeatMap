package com.example.heatmap

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("colorvalue","compareOne","compareTwo")
fun setColor(view: View, colorvalue: Float, compareOne:Float, compareTwo:Float) {
    val numbers= listOf(colorvalue,compareOne,compareTwo)

    var min=numbers.min()?:0F
    var max=numbers.max()?:1F

    val percent=(colorvalue-min)*100/(max-min)


    if(percent==0F)
        view.setBackgroundColor(view.context.getColor(R.color.min))
    if (percent==100F)
        view.setBackgroundColor(view.context.getColor(R.color.max))
    if (25F<percent && percent<75F)
        view.setBackgroundColor(view.context.getColor(R.color.medium))
    if (0<percent && percent<=25F)
        view.setBackgroundColor(view.context.getColor(R.color.min_medium))
    if (75F<=percent && percent<100F)
        view.setBackgroundColor(view.context.getColor(R.color.max_medium))




}

