package com.shixing.attributeanimation;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void objectAnimator(View view) {
        Intent intent = new Intent(this,ObjectAnimatorActivity.class);
        startActivity(intent);
    }
    public void valueAnimator(View view) {
        Intent intent = new Intent(this,ValueAnimatorTimerActivity.class);
        startActivity(intent);
    }

    public void layoutAnimator(View view) {
        Intent intent = new Intent(this,LayoutValueAnimatorActivity.class);
        startActivity(intent);
    }
}
