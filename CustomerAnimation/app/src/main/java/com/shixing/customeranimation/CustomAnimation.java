package com.shixing.customeranimation;

import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by shixing on 2017/9/6.
 */

public class CustomAnimation extends Animation {
    private static final String TAG = "CustomAnimation";

    int mCenterWidth;
    int mCenterHeight;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        Log.d(TAG, "initialize: width=" + width + " height=" + height + " parentWidth=" + parentWidth + " parentHeight=" + parentHeight);
        setFillAfter(true); //保留动画后的状态
        setDuration(1000);
        mCenterHeight = height/2;
        mCenterWidth = width/2;
        setInterpolator(new AccelerateInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Log.d(TAG, "applyTransformation: interpolatedTime=" + interpolatedTime);
        Matrix matrix = t.getMatrix();
        matrix.setScale(1,1- interpolatedTime,mCenterWidth,mCenterHeight);

    }
}
