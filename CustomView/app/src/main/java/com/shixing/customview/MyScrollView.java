package com.shixing.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * Created by shixing on 2017/8/31.
 */

public class MyScrollView extends ViewGroup {

    int mScreenHeight;
    Scroller mScroller;

    int mLasty;
    int mStart;
    int mEnd;

    public MyScrollView(Context context) {
        super(context);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenHeight = dm.heightPixels;
        mScroller = new Scroller(context);
        Log.d(MainActivity.TAG, "initView mScreenHeight: " + mScreenHeight);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MainActivity.TAG, "onMeasure: ");
        int count = getChildCount();
        for(int i = 0; i < count; ++i) {
            View childView = getChildAt(0);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(MainActivity.TAG, "onLayout: changed=" + changed + " l=" + l + " t=" + t
            + " r=" + r + " b=" + b);
        int count = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * count;
        setLayoutParams(mlp);

        for(int i = 0; i < count; ++i) {
            View childView = getChildAt(i);
            if(childView.getVisibility() != View.GONE) {
                childView.layout(l, i * mScreenHeight,
                        r, (i + 1) * mScreenHeight);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        Log.d(MainActivity.TAG, "onTouchEvent: y=" + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLasty = y;
                //记录触摸起点
                mStart = getScrollY();
                Log.d(MainActivity.TAG, "Action_down: mLasty=" + mLasty + " mstart=" + mStart);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MainActivity.TAG, "Action_move: mScroller.finished()="
                        + mScroller.isFinished() + " getScrollY()=" + getScrollY()
                        + " getHeight()=" + getHeight() + " mScreenHeight=" + mScreenHeight);
                if(!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLasty - y;
                if(getScrollY() < 0) {
                    dy = 0;
                }
                if(getScrollY() > getHeight() - mScreenHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLasty = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                //与下面那一行的注释代码效果相同
                int dScrollY = checkAlignment();
//                int dScrollY = mEnd - mStart;
                Log.d(MainActivity.TAG, "Action_up: dScrollY= " + dScrollY + " getScrollY()=" + getScrollY());
                //mScroller.startScroll()只是开始移动，本身并不具备移动效果！
                //因此需要配合computeScroll()中的scrollTo()
                if(dScrollY > 0) {
                    if(dScrollY < mScreenHeight / 3) {

                        mScroller.startScroll(0,getScrollY(),0, -dScrollY);
                    } else {
                        mScroller.startScroll(0,getScrollY(),0, mScreenHeight-dScrollY);

                    }
                } else {
                    if(-dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(0,getScrollY(),0, -dScrollY);
                    } else {
                        mScroller.startScroll(0,getScrollY(),0, -mScreenHeight-dScrollY);

                    }

                }
                break;
        }
        postInvalidate();
        //比如return true;(即处理该响应事件)否则move和up这两个动作没有响应
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.d(MainActivity.TAG, "computeScroll: mScroller.computeScrollOffset()=" +
                mScroller.computeScrollOffset() + " mScroller.getCurrY()="+
                mScroller.getCurrY());
        if(mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }

    //
    private int checkAlignment() {
        int mEnd = getScrollY();
        boolean isUp = ((mEnd - mStart) > 0) ? true : false;
        int lastPrev = mEnd % mScreenHeight;
        int lastNext = mScreenHeight - lastPrev;
        if (isUp) {
            //向上的
            return lastPrev;
        } else {
            return -lastNext;
        }
    }
}
