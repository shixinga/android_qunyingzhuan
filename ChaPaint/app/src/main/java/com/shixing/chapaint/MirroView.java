package com.shixing.chapaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shixing on 2017/9/5.
 */

public class MirroView extends View {
    Paint mPaint;
    Bitmap mSrcBitmap;
    Bitmap mMirrorBitmap;
    PorterDuffXfermode mPorterDuffXfermode;
    public MirroView(Context context) {
        super(context);
        initView(context);
    }

    public MirroView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MirroView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private  void initView(Context context) {
        mPaint = new Paint();
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Matrix mirrorMetrix = new Matrix(); //创建将bitmap垂直翻转的matrix
        mirrorMetrix.setScale(1,-1);
        mMirrorBitmap = Bitmap.createBitmap(mSrcBitmap,0,0,mSrcBitmap.getWidth(),mSrcBitmap.getHeight(),mirrorMetrix,true);
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mPaint.setXfermode(mPorterDuffXfermode);
        mPaint.setShader(new LinearGradient(0,mSrcBitmap.getHeight(),0,mSrcBitmap.getHeight()*2,
                0XDD000000,0X10000000, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mSrcBitmap,0,0,null);
        canvas.drawBitmap(mMirrorBitmap,0,mSrcBitmap.getHeight(),null);
        //绘制渐变效果矩形
        canvas.drawRect(0,mSrcBitmap.getHeight(),mMirrorBitmap.getWidth(),mSrcBitmap.getHeight() * 2, mPaint);
    }
}
