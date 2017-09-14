package com.shixing.activity.task;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shixing.activity.R;

/**
 * Created by shixing on 2017/9/10.
 */

public class SingleInstanceActivity extends Activity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_task_singleinstance);

    }
}
