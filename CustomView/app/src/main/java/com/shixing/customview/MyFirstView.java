package com.shixing.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shixing on 2017/8/30.
 */

public class MyFirstView extends View {
    public MyFirstView(Context context) {
        super(context);
    }

    public MyFirstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFirstView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasure(widthMeasureSpec),heightMeasure(heightMeasureSpec));
    }

    private int heightMeasure(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        Log.d(MainActivity.TAG, "heightMeasure:mode= " + specMode + " specSize=" + specSize + " result=" + result);
        return result;
    }

    private int widthMeasure(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        Log.d(MainActivity.TAG, "widthMeasure:mode= " + specMode + " specSize=" + specSize + " result=" + result);
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        int width = getWidth();
        int height = getHeight();
        Log.d(MainActivity.TAG, "ondraw:width= " + width + " height=" + height);
    }
}
