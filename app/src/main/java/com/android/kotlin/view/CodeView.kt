package com.android.kotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.core.app.ActivityCompat
import com.android.kotlin.R
import com.android.kotlinbase.utils.Utils
import java.util.*
import androidx.appcompat.widget.AppCompatTextView

/**
 * TODO  CodeView
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 14:59
 */
class CodeView : AppCompatTextView {

    private var paint = Paint()

    constructor(context: Context?) : super(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {

        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(ActivityCompat.getColor(context!!, R.color.colorPrimary))

        setTextColor(Color.WHITE)

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = ActivityCompat.getColor(context, R.color.colorAccent)
        paint.strokeWidth = Utils.dp2px(3f)

        updateCode()
    }

    private var codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okhttp",
        "retrofit",
        "tcp/ip"
    )

     fun updateCode() {
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        //        setText(code)
        text = code
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
    }




}