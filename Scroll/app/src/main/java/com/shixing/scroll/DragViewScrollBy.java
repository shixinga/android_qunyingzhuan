package com.shixing.scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shixing on 2017/9/3.
 */

public class DragViewScrollBy extends View {
    int mLastX;
    int mLastY;
    public DragViewScrollBy(Context context) {
        super(context);
    }

    public DragViewScrollBy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewScrollBy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
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
                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                mLastX = x;
                mLastY = y;
                Log.d(MainActivity.TAG, "onTouchEvent: mLastX=" + mLastX + " mLastY=" + mLastY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
