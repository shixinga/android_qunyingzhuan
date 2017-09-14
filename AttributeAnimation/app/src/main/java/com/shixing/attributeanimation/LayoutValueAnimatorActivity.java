package com.shixing.attributeanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by shixing on 2017/9/6.
 */

public class LayoutValueAnimatorActivity extends Activity {
    LinearLayout mLayoutHiddenView;
    float mDensity;
    int mLayoutHiddenViewMeasureHeight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);
        mLayoutHiddenView = (LinearLayout) findViewById(R.id.ll_hidden_view);
        mDensity = getResources().getDisplayMetrics().density; //获取像素密度
        mLayoutHiddenViewMeasureHeight = (int) (mDensity * 40 + 0.5); //该像素值与布局文件中的ll_hidden_view的dp值相等

    }

    public void llClick(View view) {
        if (mLayoutHiddenView.getVisibility() == View.GONE) {
            openAnimator(mLayoutHiddenView);
        } else {
            closeAnimator(mLayoutHiddenView);
        }
    }

    private void closeAnimator(final LinearLayout layoutHidedenView) {

        ValueAnimator valueAnimator = createValueAnimator(layoutHidedenView,mLayoutHiddenViewMeasureHeight,0);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                layoutHidedenView.setVisibility(View.GONE);
            }
        });
        valueAnimator.start();
    }

    private void openAnimator(final LinearLayout layoutHidedenView) {
        layoutHidedenView.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = createValueAnimator(layoutHidedenView,0,mLayoutHiddenViewMeasureHeight);
        valueAnimator.start();

    }

    public ValueAnimator createValueAnimator(final LinearLayout layoutHidedenView, int fromHeight,
                                             int toHeight) {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(fromHeight,toHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentHeight = (Integer)(animation.getAnimatedValue());
                ViewGroup.LayoutParams layoutParams = layoutHidedenView.getLayoutParams();
                layoutParams.height = currentHeight;
                layoutHidedenView.setLayoutParams(layoutParams);
            }
        });
        return valueAnimator;
    }
}
