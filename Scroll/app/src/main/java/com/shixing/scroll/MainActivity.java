package com.shixing.scroll;

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

    public void layoutOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent);
    }

    public void offsetOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent);
    }

    public void layoutParamsOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 3);
        startActivity(intent);
    }

    public void scrollByOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 4);
        startActivity(intent);
    }

    public void scrollToOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 5);
        startActivity(intent);
    }
}
