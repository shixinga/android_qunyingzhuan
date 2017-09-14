package com.shixing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shixing.activity.filter.FilterActivity;
import com.shixing.activity.ryg.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lifeT(View view) {
        Intent intent = new Intent(this, LifeTActivity.class);
        startActivity(intent);
    }

    public void task(View view) {
        Intent intent = new Intent(this,TaskActivity.class);
        startActivity(intent);
    }

    //点击进入SecondActivity->点击进入ThirdActivity->点击进入MainActivity->点击进入SecondActivity->点击返回->点击返回，这时回到了桌面
    public void mstmbbOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void filterActivityOnClick(View view) {
        Intent intent = new Intent(); //显示启动和隐式启动同时存在时，以显示启动为准
        intent.setAction("com.haha.action.a");
        intent.setAction("com.haha.action.b");
        intent.addCategory("com.hh.category.d");
        intent.setType("text/plain");
        startActivity(intent);

    }
}
