package com.xuzhiguang.huatu

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager

/**
 * Created by Administrator on 2018/4/20.
 */
class BaseSkillofDraw : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttrInt: Int) : super(context, attrs, defStyleAttrInt)

    var paint = Paint()
    var paint1 = Paint()
    var paint2 = Paint()

    init {

        paint.color = Color.RED   //填充图形内部
        paint.isAntiAlias = true  //坑锯齿
        paint.strokeWidth = 0f  //在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度; 点的大小可以通过 paint.setStrokeWidth(width) 来设置
//        paint.strokeCap = Paint.Cap.ROUND  //paint.setStrokeCap(cap) 来设置：ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.style = Paint.Style.FILL
//        pain.style=Paint.Style.STROKE

        paint1.color = Color.BLUE
        paint1.isAntiAlias = true


        paint2.color = Color.WHITE
        paint2.isAntiAlias = true

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        drawCircle(canvas)
//        drawPoint(canvas)
//        drawPoints(canvas)
//        drawLine(canvas)
//        drawRoundRect(canvas)
//        drawArc(canvas)
        drawPath(canvas)
    }

    fun drawCircle(canvas: Canvas?) {
        canvas?.drawCircle(300f, 300f, 300f, paint)
//        canvas?.drawColor(Color.parseColor("#88880000"))    //对整个画布填充颜色
    }

    fun drawPoint(canvas: Canvas?) {
        canvas?.drawPoint(600f, 600f, paint)
    }

    /**
     * pts 这个数组是点的坐标，每两个成一对；offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点
     * 0f,0f, 不会被绘制，因为已经跳过去了
     */
    fun drawPoints(canvas: Canvas?) {
        var pts = floatArrayOf(0f, 0f, 50f, 50f, 50f, 100f, 100f, 50f, 100f, 100f)
        canvas?.drawPoints(pts, 2, 8, paint)
    }

    fun drawLine(canvas: Canvas?) {
        var pts = floatArrayOf(0f, 50f, 150f, 50f)
        canvas?.drawLines(pts, paint)
    }

    /**
     *  * top <= bottom.
     *
     * @param left   The X coordinate of the left side of the rectangle
     * @param top    The Y coordinate of the top of the rectangle
     * @param right  The X coordinate of the right side of the rectangle
     * @param bottom The Y coordinate of the bottom of the rectangle
     */
    fun drawRoundRect(canvas: Canvas?) {
        var pts = RectF(500f, 500f, 1000f, 1000f)
        canvas?.drawRoundRect(pts, 10f, 10f, paint)
    }

    /**
     * left, top, right, bottom 描述的是这个弧形所在的椭圆；startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
     */
    fun drawArc(canvas: Canvas?) {
        var pts = RectF(500f, 500f, 1000f, 1000f)
        var pts1 = RectF(480f, 480f, 1020f, 1020f)
        canvas?.drawOval(pts, paint1)
        canvas?.drawArc(pts, -102f, 2f, true, paint2)
        canvas?.drawArc(pts1, -100f, 60f, true, paint)
        canvas?.drawArc(pts, -40f, 2f, true, paint2)
    }

    var path = Path()
    fun drawPath(canvas: Canvas?) {
        var paint=Paint()
        var rightTopCorner = RectF(800f, 100f, 900f, 200f)
        var rightBotCorner = RectF(800f, 700f, 900f, 800f)

        paint.style=Paint.Style.STROKE
        paint.color=Color.BLACK
        paint.strokeWidth=2f
        path.moveTo(200f,0f)
        path.rLineTo(100f, 100f)
        path.rLineTo(500f,0f)
        path.arcTo(rightTopCorner,-90f,90f,false)
        path.rLineTo(0f,500f)
        path.arcTo(rightBotCorner,0f,90f,false)

        path.rLineTo(-1000f,0f)
        canvas?.drawPath(path, paint)
    }
}