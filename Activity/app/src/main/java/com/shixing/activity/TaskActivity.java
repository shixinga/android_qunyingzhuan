package com.shixing.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.shixing.activity.task.SingleInstanceActivity;
import com.shixing.activity.task.SingleTaskActivity;
import com.shixing.activity.task.SingleTopActivity;

/**
 * Created by shixing on 2017/9/7.
 */

public class TaskActivity extends Activity {
    TextView mTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        mTextView = (TextView) findViewById(R.id.tv_show_class);
        mTextView.setText(this.toString());
    }

    public void standard(View view) {
        Intent intent = new Intent(this,TaskActivity.class);
        startActivity(intent);
        mTextView.setText(this.toString());
    }

    public void singleTop(View view) {
        Intent intent = new Intent(this, SingleTopActivity.class);
        startActivity(intent);
        mTextView.setText(this.toString());
    }

    public void singleTask(View view) {
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
        mTextView.setText(this.toString()
        );
    }

    public void singleInstance(View view) {
        Intent intent = new Intent(this, SingleInstanceActivity.class);
        startActivity(intent);
    }

}
