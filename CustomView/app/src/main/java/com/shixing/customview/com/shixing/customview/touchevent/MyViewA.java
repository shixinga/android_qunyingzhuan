package com.shixing.customview.com.shixing.customview.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.shixing.customview.MainActivity;

/**
 * Created by shixing on 2017/8/31.
 */

public class MyViewA extends View {

    public MyViewA(Context context) {
        super(context);
    }

    public MyViewA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(MainActivity.TAG, "dispatchTouchEvent View A: ");
        boolean flag = super.dispatchTouchEvent(event);
        Log.d(MainActivity.TAG, "View A dispatchTouchEvent: event.action=" + event.getAction() +
                " super.dispatchTouchEvent(event)" +  flag  );
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(MainActivity.TAG, "onTouchEvent A: ");
        boolean flag =  super.onTouchEvent(event);
        Log.d(MainActivity.TAG, "View A onTouchEvent: event.action=" + event.getAction() +
                " super.onTouchEvent(event)" +  flag  );
        return flag;
//        return flag;
    }
}
