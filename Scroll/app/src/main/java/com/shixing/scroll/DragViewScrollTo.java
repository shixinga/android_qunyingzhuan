package com.shixing.scroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by shixing on 2017/9/3.
 */

public class DragViewScrollTo extends View {
    int mLastX;
    int mLastY;
    Scroller mScroller;
    public DragViewScrollTo(Context context) {
        super(context);
        initView(context);
    }

    public DragViewScrollTo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragViewScrollTo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        View parentView = (View) getParent();
        Log.d(MainActivity.TAG, "computeScroll: parentView.getScrollX()=" + parentView.getScrollX()
                + " parentView.getScrollY()=" + parentView.getScrollY() + " mScroller.getCurrX()=" + mScroller.getCurrX()
                + " mScroller.getCurrY()=" + mScroller.getCurrY());
        if(mScroller.computeScrollOffset()) {
            parentView.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate(); //通过重绘来不断调用draw(),然后draw()调用computeScroll()
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        View parentView = (View) getParent();
        Log.d(MainActivity.TAG, "onTouchEvent:getRawX()=" + event.getRawX() + " getRawY()=" + event.getRawY()
            + " getX()=" + event.getX() + " getY()=" + event.getY() +  " getScrollX()=" + getScrollX()
            + " getScrollY()=" + getScrollY() + " parentView.getScrollX()=" + parentView.getScrollX()
            + " parentView.getScrollY()=" + parentView.getScrollY() + " mScroller.getCurrX()=" + mScroller.getCurrX()
            + " mScroller.getCurrY()=" + mScroller.getCurrY());
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
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mScroller.startScroll(
                        parentView.getScrollX(),
                        parentView.getScrollY(),
                        -parentView.getScrollX(),
                        -parentView.getScrollY()
                );
                invalidate();
                break;
        }
        return true;
    }

}
