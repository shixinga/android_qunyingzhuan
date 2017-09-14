package com.shixing.imagecolormatrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.shixing.imagecolormatrix.utils.ImageHelper;

/**
 * Created by shixing on 2017/9/4.
 */

public class ImageActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    Bitmap mBitmap;
    ImageView mImageView;
    SeekBar mSeekBarHue;
    SeekBar mSeekBarStauration;
    SeekBar mSeekBarLum;
    float mHue, mStauration, mLum;
    static final int MAX_VALUE = 255;
    static final int MIN_VALUE = 127;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_handle);
        mImageView = (ImageView) findViewById(R.id.iv_handle);
        mSeekBarHue = (SeekBar) findViewById(R.id.sb_hue);
        mSeekBarStauration = (SeekBar) findViewById(R.id.sb_satuation);
        mSeekBarLum = (SeekBar) findViewById(R.id.sb_lum);
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test3);
        mImageView.setImageBitmap(mBitmap);
        mSeekBarHue.setMax(MAX_VALUE);
        mSeekBarHue.setProgress(MIN_VALUE);
        mSeekBarStauration.setMax(MAX_VALUE);
        mSeekBarStauration.setProgress(MIN_VALUE);
        mSeekBarLum.setMax(MAX_VALUE);
        mSeekBarLum.setProgress(MIN_VALUE);

        mSeekBarHue.setOnSeekBarChangeListener(this);
        mSeekBarStauration.setOnSeekBarChangeListener(this);
        mSeekBarLum.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sb_hue:
                mHue = (progress - MIN_VALUE) * 1.0F / MIN_VALUE *180;
                break;

            case R.id.sb_satuation:
                mStauration = progress * 1.0F / MIN_VALUE;
                break;
            case R.id.sb_lum:
                mLum = progress * 1.0F /MIN_VALUE;
                break;
        }


        mImageView.setImageBitmap(ImageHelper.handleImage(mBitmap, mHue,mStauration,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
