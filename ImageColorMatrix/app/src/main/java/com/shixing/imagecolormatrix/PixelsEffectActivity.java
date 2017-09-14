package com.shixing.imagecolormatrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.shixing.imagecolormatrix.utils.ImageHelper;

/**
 * Created by shixing on 2017/9/4.
 */

public class PixelsEffectActivity extends Activity {
    Bitmap mBitmap;
    ImageView mImageView1;
    ImageView mImageView2;
    ImageView mImageView3;
    ImageView mImageView4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixels_effect);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        mImageView1 = (ImageView) findViewById(R.id.iv_pixels_effect1);
        mImageView2 = (ImageView) findViewById(R.id.iv_pixels_effect2);
        mImageView3 = (ImageView) findViewById(R.id.iv_pixels_effect3);
        mImageView4 = (ImageView) findViewById(R.id.iv_pixels_effect4);

        mImageView1.setImageBitmap(mBitmap);
        mImageView2.setImageBitmap(ImageHelper.handleImageNagtive(mBitmap));
        mImageView3.setImageBitmap(ImageHelper.handleImageOld(mBitmap));
        mImageView4.setImageBitmap(ImageHelper.handleImageRelief(mBitmap));
    }
}
