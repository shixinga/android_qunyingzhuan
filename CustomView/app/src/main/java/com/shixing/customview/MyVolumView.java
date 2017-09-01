package com.shixing.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by shixing on 2017/8/31.
 */

public class MyVolumView extends View {
    Paint mPaint;
    int mCount = 12;
    float mWidth;
    float mRectWidth;
    float mHeight;
    double mRandomNum;
    int mOffset = 5; //偏移量（两条柱子之间的间隔）
    public MyVolumView(Context context) {
        super(context);
        initView();
    }

    public MyVolumView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyVolumView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        Log.d(MainActivity.TAG, "initView: ");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(MainActivity.TAG, "onSizeChanged: w=" + w + " h =" + h
                + " oldw=" + oldw + " oldh=" + oldh +
                " getWidth()=" + getWidth() + " getHeight()=" + getHeight());
        mWidth = getWidth();
        mHeight = getHeight();
        mRectWidth = (float) ((mWidth *  0.6) / mCount);

         LinearGradient LinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(LinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(MainActivity.TAG, "onDraw: ");
        for(int i = 0; i < mCount; ++i) {
            mRandomNum = Math.random();
            float currentHeight = (float) (mHeight * mRandomNum);
            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + mOffset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mHeight,
                    mPaint
            );
        }
        postInvalidateDelayed(300);
    }
}
