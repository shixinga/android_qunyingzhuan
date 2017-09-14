package com.shixing.mylayeralpha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyLayer(this));
    }

    public class MyLayer extends View {
        private static final int LAYER_FLAGS =
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG;
        public MyLayer(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Log.d(TAG, "onDraw: " + LAYER_FLAGS);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.RED);
            canvas.drawCircle(150,150,100,paint);

            canvas.saveLayerAlpha(0,0,400,400,127,LAYER_FLAGS); //第四个参数：0表示透明，127表示半透明
            paint.setColor(Color.GREEN);
            canvas.drawCircle(200,200,100,paint);

            canvas.restore();

        }
    }
}
