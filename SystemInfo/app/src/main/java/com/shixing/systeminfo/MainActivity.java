package com.shixing.systeminfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buildAndPropertySystemInfo(View view) {
        Intent intent = new Intent(this,BuildAndGetPropertyActivity.class);
        startActivity(intent);
    }

    public void packageManageInfo(View view) {
        Intent intent = new Intent(this,PackageManagerActivity.class);
        startActivity(intent);
    }

    public void activityManageInfo(View view) {
        Intent intent = new Intent(this,ActivityManagerActivity.class);
        startActivity(intent);
    }
}
