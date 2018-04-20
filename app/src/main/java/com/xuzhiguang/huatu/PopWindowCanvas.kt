package com.xuzhiguang.huatu

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by Administrator on 2018/4/20.
 */
class PopWindowCanvas(var width: Float, var height: Float, var radius: Float, var triangle_w: Float, var triangle_h: Float, context: Context?) : View(context) {

    var paint = Paint()
    var path = Path()

    init {
        paint.color = Color.RED
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawPopWindow(canvas)
    }

    fun drawPopWindow(canvas: Canvas?) {
        var center_x = width / 2f
        var tr_w = triangle_w
        var tr_h = triangle_h
        var x_to_w = (width - tr_w - radius * 2) / 2
        var y_to_h = height - tr_h - radius * 2

        var rightTopCorner = RectF(width - radius, tr_h, width, tr_h + radius)
        var rightBotCorner = RectF(width - radius, height - radius, width, height)
        var leftBotCorner = RectF(0f, height - radius, radius, height)
        var leftTopCorner = RectF(0f, tr_h, radius, tr_h + radius)

        path.moveTo(center_x, 0f)
        path.rLineTo(tr_w / 2f, tr_h)
        path.rLineTo(x_to_w, 0f)
        path.arcTo(rightTopCorner, -90f, 90f, false)
        path.rLineTo(0f, y_to_h)
        path.arcTo(rightBotCorner, 0f, 90f, false)
        path.rLineTo(-(width - radius * 2f), 0f)
        path.arcTo(leftBotCorner, 90f, 90f, false)
        path.rLineTo(0f, -y_to_h)
        path.arcTo(leftTopCorner, 180f, 90f, false)
        path.rLineTo(x_to_w+20, 0f)
        canvas?.drawPath(path, paint)
    }
}