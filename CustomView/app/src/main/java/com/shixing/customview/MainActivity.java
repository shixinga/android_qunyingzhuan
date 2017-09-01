package com.shixing.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void myFirstView(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 0);
       startActivity(intent);

   }

   public void myTextView(View view)  {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 1);
       startActivity(intent);
   }

   public void myShineView(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 2);
       startActivity(intent);
   }

   public void myTopBarAttr(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 3);
       startActivity(intent);
   }

   public void myIncludeTopBar(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 4);
       startActivity(intent);
   }

   public void myCircleView(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 5);
       startActivity(intent);
   }

   public void myVolumeView(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 6);
       startActivity(intent);
   }

   public void myScrollView(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 7);
       startActivity(intent);
   }

   public void touchEvent(View view) {
       Intent intent = new Intent(this,SecondActivity.class);
       intent.putExtra("flag", 8);
       startActivity(intent);
   }

}
