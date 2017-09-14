package com.shixing.scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shixing on 2017/9/2.
 */

public class DragViewOffsetLeftAndRight extends View {
    int mLastX;
    int mLastY;
    public DragViewOffsetLeftAndRight(Context context) {
        super(context);
    }

    public DragViewOffsetLeftAndRight(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewOffsetLeftAndRight(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                //和layout方式的滑动效果一样
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                mLastY = y;
                mLastX = x;
                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
