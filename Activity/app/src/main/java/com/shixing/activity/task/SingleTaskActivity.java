package com.shixing.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.shixing.activity.MainActivity;
import com.shixing.activity.R;

/**
 * Created by shixing on 2017/9/7.
 */

public class SingleTaskActivity extends Activity{

    private static final String TAG = "SingleTaskActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_singletask);
        Log.d(TAG, "onCreate: ");
    }

    public void singleTaskOnClick(View view) {
        Intent intent = new Intent(this,SingleTaskActivity.class); //再一次启动时，该singleTaskActivity不会被销毁和创建

//        Intent intent = new Intent(this, MainActivity.class); //再一次启动该SingleTaskActivity时，如果该任务栈上有该SingleTaskActivity的实例
                                                                //则将压在该SingleTaskActivity实例上面的Activity实例全部移出栈
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
}
