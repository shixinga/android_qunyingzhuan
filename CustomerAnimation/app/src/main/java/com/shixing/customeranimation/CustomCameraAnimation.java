package com.shixing.customeranimation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * Created by shixing on 2017/9/6.
 */

public class CustomCameraAnimation extends Animation {
    int mCenterWidth;
    int mCenterHeight;
    Camera mCamera = new Camera();
    float mRotateY = 30; //旋转的角度

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setFillAfter(true); //保留动画结束后的状态
        setInterpolator(new BounceInterpolator());
        setDuration(2000);
        mCenterHeight = height / 2;
        mCenterWidth = width / 2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        //使用Camera设置旋转的角度
        mCamera.rotateY(mRotateY * interpolatedTime);
        //将旋转变换的效果作用到Matrix上
        mCamera.getMatrix(matrix);
        mCamera.restore();
        //通过pre方法设置矩阵作用前的偏移量来改变旋转中心
        matrix.preTranslate(mCenterWidth,mCenterHeight);
        matrix.postTranslate(-mCenterWidth,-mCenterHeight);
    }
}
