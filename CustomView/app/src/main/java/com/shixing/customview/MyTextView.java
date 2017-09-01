package com.shixing.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shixing on 2017/8/30.
 */

public class MyTextView extends TextView {
    Paint mPaint1;
    Paint mPaint2;
    public MyTextView(Context context) {
        super(context);
        initView();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setColor(getResources().getColor(
                android.R.color.holo_blue_light));
        mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setColor(Color.YELLOW);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MainActivity.TAG, "onMeasure: " + MeasureSpec.getSize(widthMeasureSpec) + ",," + MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(MainActivity.TAG, "onMeasure: " + getMeasuredWidth() + ",," + getMeasuredHeight());
        //绘制外层图形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(),mPaint1);
        //绘制内层图形
        canvas.drawRect(10,10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);

        canvas.save();
        //绘制文本内容前将文本内容向右偏移100px
        canvas.translate(100,0);
        //绘制文本内容
        super.onDraw(canvas);
        canvas.restore();
    }
}
