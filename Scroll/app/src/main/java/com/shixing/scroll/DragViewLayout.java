package com.shixing.scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shixing on 2017/9/2.
 */

public class DragViewLayout extends View {
    int mLastX;
    int mLastY;
    public DragViewLayout(Context context) {
        super(context);
    }

    public DragViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //基于android坐标系滑动

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
                mLastY = y;
                mLastX = x;
                break;

            case MotionEvent.ACTION_UP:

                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d(MainActivity.TAG, "onTouchEvent: " + flag); //View的onTouchEvent()默认返回false（即触摸不生效），所以要改为true
        return true;
    }


    //基于视图坐标系滑动
    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                //相对于父控件的偏移，所以永远也走不出父控件所限定的区域
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
                mLastY = y;
                mLastX = x;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;

    }*/
}
