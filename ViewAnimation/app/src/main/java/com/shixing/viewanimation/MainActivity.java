package com.shixing.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alpha(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1000);
        view.startAnimation(alphaAnimation);
    }
    public void rotate(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,100,100);
        rotateAnimation.setDuration(1000);
        view.startAnimation(rotateAnimation);
    }
    public void rotate_self(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,RotateAnimation.RELATIVE_TO_SELF);
        rotateAnimation.setDuration(1000);
        view.startAnimation(rotateAnimation);
    }
    public void translate(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,300);
        translateAnimation.setDuration(1000);
        view.startAnimation(translateAnimation);
    }
    public void scale(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,2,0,4);
        scaleAnimation.setDuration(1000);
        view.startAnimation(scaleAnimation);
    }
    public void scale_self(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5F
            ,Animation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setDuration(1000);
        view.startAnimation(scaleAnimation);
    }
    public void animation_set(View view) {
        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0,100,0,200);
        translateAnimation.setDuration(1000);
        animationSet.addAnimation(translateAnimation);

        view.startAnimation(animationSet);
    }
}
