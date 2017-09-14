package com.shixing.patheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by shixing on 2017/9/5.
 */

public class PathEffectView extends View {
    Paint mPaint;
    Path mPath;
    PathEffect mPathEffect[] = new PathEffect[6];
    public PathEffectView(Context context) {
        super(context);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPath = new Path();
        mPath.moveTo(0,0);
        for (int i = 0; i < 30; ++i) {
            mPath.lineTo(i*35, (float)( Math.random() * 100));
        }
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathEffect[0] = null;
        mPathEffect[1] = new CornerPathEffect(30);
        mPathEffect[2] = new DiscretePathEffect(3,5);
        mPathEffect[3] = new DashPathEffect(new float[]{20,10,5,10},0);
        Path tempPath = new Path();
        tempPath.addRect(0,0,8,8, Path.Direction.CCW);
        mPathEffect[4] = new PathDashPathEffect(tempPath,12,0,PathDashPathEffect.Style.ROTATE);
        mPathEffect[5] = new ComposePathEffect(mPathEffect[3],mPathEffect[1]);
        for (int i = 0; i < mPathEffect.length; ++i) {
            mPaint.setPathEffect(mPathEffect[i]);
            canvas.drawPath(mPath,mPaint);
            canvas.translate(0,200);
        }
    }
}
