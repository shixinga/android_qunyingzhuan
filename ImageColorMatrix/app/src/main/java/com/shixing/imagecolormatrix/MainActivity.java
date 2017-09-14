package com.shixing.imagecolormatrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageHandle(View view) {
        Intent intent = new Intent(this,ImageActivity.class);
        startActivity(intent);
    }

    public void colorMatrixHandle(View view) {
        Intent intent = new Intent(this,ColorMatrixActivity.class);
        startActivity(intent);
    }

    public void pixelsEffectHandle(View view) {
        Intent intent = new Intent(this,PixelsEffectActivity.class);
        startActivity(intent);
    }
}
