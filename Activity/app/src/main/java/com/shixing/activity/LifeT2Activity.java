package com.shixing.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by shixing on 2017/9/10.
 */

public class LifeT2Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeTActivity.TAG, "LifeT2 onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifeTActivity.TAG, "LifeT2 onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifeTActivity.TAG, "LifeT2 onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifeTActivity.TAG, "LifeT2 onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifeTActivity.TAG, "LifeT2 onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifeTActivity.TAG, "LifeT2 onDestroy: ");
    }
}
