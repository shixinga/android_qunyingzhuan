package com.shixing.mysurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by shixing on 2017/9/5.
 */

public class MyPaintSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    private static final String TAG = "MySurfaceView";
    SurfaceHolder mSurfaceHolder;
    Path mPath;
    Paint mPaint;
    Canvas mCanvas;
    boolean mIsDrawing;

    public MyPaintSurfaceView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        Log.d(TAG, "initView: ");
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        mPath = new Path();
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        //SurfaceView默认就是可触摸的
//        setFocusable(true);
//        setFocusableInTouchMode(true);
    }

    public MyPaintSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPaintSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated: ");
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged: ");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed: ");
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing) {
            long start = System.currentTimeMillis();
            draw();
            long end = System.currentTimeMillis();
            if (end - start < 100) {
                try {
                    Thread.sleep(100 - (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void draw() {
        try {

            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.WHITE); //设置画布的背景为白色
            mCanvas.drawPath(mPath,mPaint);
        } catch (Exception e) {

        } finally {
            if (mCanvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x= event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x,y);
                break;

            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
