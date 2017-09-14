package com.shixing.imagecolormatrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by shixing on 2017/9/4.
 */

public class ColorMatrixActivity extends Activity {

    private static final String TAG = "ColorMatrixActivity";
    Bitmap mBitmap;
    ImageView mImageView;
    GridLayout mGridLayout;
    float mColorMatrixs[];
    EditText mEditTexts[];
    int mEditTextWidth;
    int mEditTextHeight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colormatrix);
        initData();
        initView();
    }

    private void initData() {
        mColorMatrixs = new float[20];
        for (int i = 0; i < 20; ++i) {
            if (i % 6 == 0) {
                mColorMatrixs[i] = 1;
            } else {
                mColorMatrixs[i] = 0;
            }
        }
    }

    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test1);
        mImageView = (ImageView) findViewById(R.id.iv_colormatrix);
        mImageView.setImageBitmap(mBitmap);
        mGridLayout = (GridLayout) findViewById(R.id.gv_colormatrix);
        mEditTexts = new EditText[20];
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                //mEditTextHeight和mEditTextWidth必须在post()里面设置，不能挪到外面（挪到外面是获取不到值得！）
                mEditTextHeight = mGridLayout.getHeight() / 4;
                mEditTextWidth = mGridLayout.getWidth() / 5;
                for (int i = 0; i < 20; ++i) {
                    EditText editText = new EditText(ColorMatrixActivity.this);
                    editText.setText(mColorMatrixs[i] + "");
                    mEditTexts[i] = editText;
                    mGridLayout.addView(editText, mEditTextWidth, mEditTextHeight);
                }

            }
        });



    }

    public void setColorMatrixOnClick(View view) {

        Bitmap btm = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(btm);
        Paint paint = new Paint();
        for (int i = 0; i < 20; ++i) {
            mColorMatrixs[i] = Float.valueOf(mEditTexts[i].getText().toString());
            Log.d(TAG, "setColorMatrixOnClick: " + mColorMatrixs[i]);
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap,0,0,paint);
        mImageView.setImageBitmap(btm);
    }

    public void resetColorMatrixOnClick(View view) {

    }
}
