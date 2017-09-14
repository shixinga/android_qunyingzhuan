package com.shixing.activity.ryg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shixing.activity.MainActivity;
import com.shixing.activity.R;

/**
 * Created by shixing on 2017/9/10.
 */

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void mainActivityOnClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}
