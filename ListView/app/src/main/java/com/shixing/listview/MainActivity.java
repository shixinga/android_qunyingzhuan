package com.shixing.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyOnClick(View view) {
        Intent intent = new Intent(this, NotifyActivity.class);
        startActivity(intent);
    }

    public void flexableListViewOnClick(View view) {
        Intent intent = new Intent(this, FlexableActivity.class);
        startActivity(intent);
    }

    public void scrollHideListViewOnClick(View view) {
        Intent intent = new Intent(this, ScrollHideActivity.class);
        startActivity(intent);
    }

    public void chatOnClick(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    public void listViewItemClickOnClick(View view) {
        Intent intent = new Intent(this,ListViewItemClickActivity.class);
        startActivity(intent);
    }
}
