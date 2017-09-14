package com.shixing.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by shixing on 2017/9/7.
 */

public class LifeTActivity extends Activity {

    public static final String TAG = "LifeTActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String tag = "onCreate: " + (savedInstanceState == null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifet);
        if (savedInstanceState != null) {
            User u = (User) savedInstanceState.getSerializable("u");
            tag = tag + u.name + u.age;
        }
        Log.d(TAG, tag);
    }

    public void lifeT2(View view) {
        Intent intent = new Intent(this,LifeT2Activity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //singleTask模式
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: " + (outState== null));
        User user = new User("csx",19);
        outState.putSerializable("u",user);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String tag =  "onRestoreInstanceState: " + (savedInstanceState == null);
        if (savedInstanceState  != null) {
            User u = (User) savedInstanceState.getSerializable("u");
            tag = tag + u.name + u.age;
        }
        Log.d(TAG, tag);
    }

    // <activity android:name=".LifeTActivity" android:configChanges="orientation|screenSize" />时会调用下面的方法
    //此时因为activity没有被销毁和重新创建，所以onSaveInstanceState()和onRestoreInstanceState()不会被调用
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: " + newConfig.orientation);
    }
}
