package com.shixing.scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by shixing on 2017/9/3.
 */

public class DragViewLayoutParams extends View {
    int mLastX;
    int mLastY;
    public DragViewLayoutParams(Context context) {
        super(context);
    }

    public DragViewLayoutParams(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewLayoutParams(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX(); //不是直接getX()
        int y = (int) event.getY(); //不是直接getY()
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) getLayoutParams(); //和下面注释代码等价
//                LinearLayout.LayoutParams marginLayoutParams = (LinearLayout.LayoutParams) getLayoutParams(); //该View的父布局是LinearLayout

                marginLayoutParams.leftMargin = getLeft() + offsetX;
                marginLayoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(marginLayoutParams);
                mLastY = y;
                mLastX = x;
                Log.d(MainActivity.TAG, "onTouchEvent: mLastX=" + mLastX + " mLastY=" + mLastY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
