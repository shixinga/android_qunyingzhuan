package com.shixing.listview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by shixing on 2017/9/1.
 */

public class ScrollHideActivity extends Activity {

    ListView mListView;
    Toolbar mToolBar;
    String mStrs[] = new String[20];
    int mTouchSlop;
    boolean mShow = true;
    int mDirection; //0表示向下 1表示向上
    float mFirstY;
    float mCurrentY;
    ObjectAnimator mObjectAnimator;

    View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN :
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE :
                    mCurrentY = event.getY();
                    /*Log.d(MainActivity.TAG, "onTouch: mFirstY=" + mFirstY
                            + " mCurrentY=" + mCurrentY);*/
                    if (mCurrentY - mFirstY > mTouchSlop) {
                        mDirection = 0; //向下
                    } else if(mFirstY - mCurrentY > mTouchSlop) {
                        mDirection = 1; //向上
                    }

                    if (mDirection == 1) { //hide
                        if(mShow) {
                            Log.d(MainActivity.TAG, "onTouch: 向上滑，所以隐藏");
                            showAnimator(1); //1 表示隐藏
                            mShow = !mShow;
                        }
                    } else if(mDirection == 0) { //show

                        if(!mShow) {
                            Log.d(MainActivity.TAG, "onTouch: 向下滑，所以要显示");
                            showAnimator(0); //0表示显示
                            mShow = !mShow;
                        }

                    }
                    break;

                case MotionEvent.ACTION_UP :

                    break;

                default:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_hide);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        Log.d(MainActivity.TAG, "onCreate: ViewConfiguration.get(this).getScaledTouchSlop()= " + mTouchSlop);
        mListView = (ListView) findViewById(R.id.lv_scroll_hide);
        mToolBar = (Toolbar) findViewById(R.id.toolbar_scroll_hide);
        for(int i = 0; i < 20; ++i) {
            mStrs[i] = "第" + (i + 1) + "item";
        }

        View headView = new View(this);
        headView.setLayoutParams(new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                (int)getResources().getDimension(
                        android.support.v7.appcompat.R.dimen.abc_action_bar_default_height_material)//toolBar的默认高度
            )
        );
        mListView.addHeaderView(headView);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,mStrs));
        mListView.setOnTouchListener(mTouchListener);

    }

    private void showAnimator(int flag) {
        if (mObjectAnimator != null && mObjectAnimator.isRunning()) {
            mObjectAnimator.cancel();
        }

        Log.d(MainActivity.TAG, "showAnimator: mToolBar.getTranslationY()= " +  mToolBar.getTranslationY() +
                " mToolBar.getHeight()=" + mToolBar.getHeight() );
        if (flag == 0) { //show
            mObjectAnimator = ObjectAnimator.ofFloat(mToolBar, "TranslationY", mToolBar.getTranslationY(), 0);
        } else if(flag == 1) { //hide
            mObjectAnimator = ObjectAnimator.ofFloat(mToolBar, "TranslationY", mToolBar.getTranslationY(), -mToolBar.getHeight());

        }

        mObjectAnimator.start();
    }
}
