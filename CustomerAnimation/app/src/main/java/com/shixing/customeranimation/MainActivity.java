package com.shixing.customeranimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAnim(View view) {
        CustomCameraAnimation customCameraAnimation = new CustomCameraAnimation();
        view.startAnimation(customCameraAnimation);
    }

    public void imgClose(View view) {
        Log.d(TAG, "imgClose:getResources().getDisplayMetrics().density= " + getResources().getDisplayMetrics().density);
        CustomAnimation customAnimation = new CustomAnimation();
        view.startAnimation(customAnimation);
    }
}
