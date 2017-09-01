package com.shixing.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shixing on 2017/8/31.
 */

public class MyCircleView extends View {
    int mMeasureWidth;
    int mMeasureHeight;
    float mLength;

    //圆心
    float mCircleXY;
    float mCircleRadius;
    Paint mCirclePaint;

    //画弧线所需要的变量
    RectF mRectF;
    Paint mArcPaint;
    float mSweepValue = 66;
    float mSweepAngle;

    //画文字
    Paint mTextPaint;
    float mTextSize = 50;
    String mText = "你好！";
    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(MainActivity.TAG, "onDraw: ");
        //画圆
        canvas.drawCircle(mCircleXY,mCircleXY,mCircleRadius,mCirclePaint);

        //画狐
        canvas.drawArc(mRectF, 270, mSweepAngle, false, mArcPaint);

        //画文字
        canvas.drawText(mText, 0, mText.length(), mCircleXY,mCircleXY,mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(MainActivity.TAG, "onMeasure: ");
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeight);
        initView();
    }

    private void initView() {
        //对圆的初始化
        if(mMeasureWidth >= mMeasureHeight) {
            mLength = mMeasureHeight;
        } else {
            mLength = mMeasureWidth;
        }
        mCircleXY = (float)(mLength / 2.0);
        mCircleRadius = (float)(mLength / 4.0);
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GREEN);


        //对弧线的初始化
        mRectF = new RectF(
                (float) (mLength * 0.1),
                (float) (mLength * 0.1),
                (float) (mLength * 0.9),
                (float) (mLength * 0.9));
        mArcPaint = new Paint();
        mArcPaint.setColor(Color.YELLOW);
        //mArcPaint.setAntiAlias(true); //取消锯齿
        mArcPaint.setStrokeWidth((float)(mLength * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mSweepAngle = (float) (mSweepValue * 3.6);

        //对文字的初始化
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

}
