package com.shixing.customview.com.shixing.customview.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.shixing.customview.MainActivity;

/**
 * Created by shixing on 2017/8/31.
 */

public class ViewGroupA extends LinearLayout {
    public ViewGroupA(Context context) {
        super(context);
    }

    public ViewGroupA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(MainActivity.TAG, "dispatchTouchEvent ViewGroup AAA: ");
        boolean flag = super.dispatchTouchEvent(ev);
        Log.d(MainActivity.TAG, "ViewGroup A dispatchTouchEvent: event.action=" + ev.getAction() +
            " super.dispatchTouchEvent(ev)=" + flag);
        return flag;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(MainActivity.TAG, "onInterceptTouchEvent ViewGroup AAA: ");
        boolean flag = super.onInterceptTouchEvent(ev);
        Log.d(MainActivity.TAG, "ViewGroup A onInterceptTouchEvent: event.action=" + ev.getAction() +
                " super.onInterceptTouchEvent(ev)=" + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = super.onTouchEvent(event);
        Log.d(MainActivity.TAG, "ViewGroup A onTouchEvent: event.action=" + event.getAction() +
                " super.onTouchEvent(ev)=" + flag);
        return flag;
    }
}
