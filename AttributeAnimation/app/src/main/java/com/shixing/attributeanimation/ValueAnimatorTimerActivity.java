package com.shixing.attributeanimation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.TextView;

/**
 * Created by shixing on 2017/9/6.
 */

public class ValueAnimatorTimerActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
    }

    public void tv_onClick(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ((TextView)view).setText("$"+(Integer) animation.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }
}
