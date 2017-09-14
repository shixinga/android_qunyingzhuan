package com.shixing.systeminfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by shixing on 2017/9/7.
 */

public class BuildAndGetPropertyActivity extends Activity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_and_property);
        mTextView = (TextView) findViewById(R.id.tv);
        String systemTinfo = SystemInfoTools.getBuildInfo();
        systemTinfo += "------------------------------\r\n";
        systemTinfo += SystemInfoTools.getSystemPropertyInfo();
        mTextView.setText(systemTinfo);
    }
}
