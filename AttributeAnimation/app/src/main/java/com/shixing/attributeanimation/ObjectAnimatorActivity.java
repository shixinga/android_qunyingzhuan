package com.shixing.attributeanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by shixing on 2017/9/6.
 */

public class ObjectAnimatorActivity extends Activity implements View.OnClickListener{

    int ivRs[] = new int[]{R.id.iv_a,R.id.iv_b,R.id.iv_c,R.id.iv_d,R.id.iv_e};
    ImageView imageViews[] = new ImageView[5];
    boolean mFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectanimator);
        for (int i = 0; i < 5; ++i) {
            ImageView imageView = (ImageView) findViewById(ivRs[i]);
            imageView.setOnClickListener(this);
            imageViews[i] = imageView;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.iv_a:
                if (mFlag) {
                    startAnimator();
                } else {
                    closeAnimator();
                }
                break;
            default:
                Toast.makeText(this,"你点击了啥", Toast.LENGTH_SHORT).show();
        }
    }

    private void closeAnimator() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageViews[0],"alpha",0.5F,1F);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageViews[1],"translationY",200F,0);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageViews[2],"translationX",200F,0);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(imageViews[3],"translationY",-200F,0);
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(imageViews[4],"translationX",-200F,0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1500);
        animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4,objectAnimator5);
        animatorSet.setInterpolator(new BounceInterpolator()); //bounds like a basketball
        animatorSet.start();

        mFlag = true;

    }

    private void startAnimator() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageViews[0],"alpha",1F,0.5F);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageViews[1],"translationY",200F);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageViews[2],"translationX",200F);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(imageViews[3],"translationY", -200F);
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(imageViews[4],"translationX", -200F);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new BounceInterpolator()); //bounds like a basketball
        animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4,objectAnimator5);
        animatorSet.start();
        mFlag = false;
    }
}
