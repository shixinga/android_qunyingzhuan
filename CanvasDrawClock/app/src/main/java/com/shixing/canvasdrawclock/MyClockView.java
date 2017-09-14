package com.shixing.canvasdrawclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shixing on 2017/9/4.
 */

public class MyClockView extends View {

    private static final String TAG = "MyClockView";
    public MyClockView(Context context) {
        super(context);
    }

    public MyClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measureWidth = getMeasuredWidth();
        int measureHeight = getMeasuredHeight();
        Log.d(TAG, "onDraw: getMeasuredWidth()=" + measureWidth + " getMeasuredHeight()="
            + measureHeight + " getLeft()=" + getLeft() + " getRight()=" + getRight()
                + " getTop()=" + getTop()+ " getBottom()=" + getBottom());

        //画圆
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        canvas.drawCircle(measureWidth / 2, measureHeight / 2, measureWidth / 2, paintCircle);

        //画刻度线和刻度值
        Paint paintDegree = new Paint();
        paintDegree.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 24; ++i) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                //画刻度线
                canvas.drawLine(measureWidth / 2, measureHeight / 2 - measureWidth / 2,
                        measureWidth / 2, measureHeight / 2 - measureWidth / 2 + 60, paintDegree);
                //画刻度值
                String degreeValue = i + "";
                canvas.drawText(degreeValue, measureWidth / 2 - paintDegree.measureText(degreeValue) / 2,
                        measureHeight / 2 - measureWidth / 2 + 90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(20);
                //画刻度线
                canvas.drawLine(measureWidth / 2, measureHeight / 2 - measureWidth / 2,
                        measureWidth / 2, measureHeight / 2 - measureWidth / 2 + 60, paintDegree);
                //画刻度值
                String degreeValue = i + "";
                canvas.drawText(degreeValue, measureWidth / 2 - paintDegree.measureText(degreeValue) / 2,
                        measureHeight / 2 - measureWidth / 2 + 70, paintDegree);

            }
            //旋转的是画布的坐标系
            canvas.rotate(360/24, measureWidth/2, measureHeight / 2);

        }

        //画原点
        Paint paintPoint = new Paint();
        paintPoint.setColor(Color.GREEN);
        paintPoint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(measureWidth / 2,measureHeight / 2 , 12, paintPoint);

        //画时针和分针
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(10);
        paintHour.setStyle(Paint.Style.STROKE);

        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(6);
        paintMinute.setStyle(Paint.Style.STROKE);

        //相当于git的stash.save()
        canvas.save();
        canvas.translate(measureWidth / 2, measureHeight / 2);
        canvas.drawLine(0,0, 100, 100, paintHour);
        canvas.drawLine(0,0, 100, 300, paintMinute);
        //相当于git的stash.pop();
        canvas.restore();
    }
}
