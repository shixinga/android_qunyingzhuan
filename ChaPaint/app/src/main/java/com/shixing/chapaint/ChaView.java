package com.shixing.chapaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shixing on 2017/9/5.
 */

public class ChaView extends View {
    private static final String TAG = "ChaView";
    Paint mPaint;
    Bitmap mFgBitmap,mBgBitmap;
    Canvas mCanvas;
    Path mPath;
    public ChaView(Context context) {
        super(context);
        initView(context);
    }

    public ChaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setAlpha(0);
        mPaint.setXfermode(
                new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(50);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mBgBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
        mFgBitmap = Bitmap.createBitmap(mBgBitmap.getWidth(),mBgBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mFgBitmap);
        mCanvas.drawColor(Color.GREEN);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: ");
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                
                break;
        }
        
        mCanvas.drawPath(mPath,mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        canvas.drawBitmap(mBgBitmap,0,0,null); //注释看看效果？？？
        canvas.drawBitmap(mFgBitmap,0,0,null);
    }
}
