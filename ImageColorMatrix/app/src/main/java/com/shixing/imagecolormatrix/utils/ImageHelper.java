package com.shixing.imagecolormatrix.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by shixing on 2017/9/4.
 */

public class ImageHelper {

    public static Bitmap handleImage(Bitmap bitmap, float hue, float stauration, float lum) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix hueColorMatrix = new ColorMatrix();
        hueColorMatrix.setRotate(0,hue);
        hueColorMatrix.setRotate(1,hue);
        hueColorMatrix.setRotate(2,hue);

        ColorMatrix staurationColorMatrix = new ColorMatrix();
        staurationColorMatrix.setSaturation(stauration);

        ColorMatrix lumColorMatrix = new ColorMatrix();
        lumColorMatrix.setScale(lum,lum,lum,1);

        //实现颜色、饱和度、光度的效果叠加
        ColorMatrix imageColorMatrix = new ColorMatrix();
        imageColorMatrix.postConcat(hueColorMatrix);
        imageColorMatrix.postConcat(staurationColorMatrix);
        imageColorMatrix.postConcat(lumColorMatrix);
        paint.setColorFilter(new ColorMatrixColorFilter(imageColorMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);
        return bmp;

    }

    public static Bitmap handleImageNagtive(Bitmap bitmap) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int oldPixels[] = new int[ width * height];
        int newPixels[] = new int[width * height];
        bitmap.getPixels(oldPixels,0,width,0,0, width, height);
        int color;
        int r,g,b,a;
        for (int i = 0; i < width * height; ++i) {
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if(r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if(g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if(b < 0) {
                b = 0;
            }

            newPixels[i] = Color.argb(a,r,g,b);
        }
        bitmap1.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap1;
    }

    public static Bitmap handleImageOld(Bitmap bitmap) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int oldPixels[] = new int[ width * height];
        int newPixels[] = new int[width * height];
        bitmap.getPixels(oldPixels,0,width,0,0, width, height);
        int color;
        int r,g,b,a,r1,g1,b1;
        for (int i = 0; i < width * height; ++i) {
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r1 = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r1 > 255) {
                r1 = 255;
            }
            if (g1 > 255) {
                g1 = 255;
            }
            if (b1 > 255) {
                b1 = 255;
            }

            newPixels[i] = Color.argb(a,r1,g1,b1);
        }
        bitmap1.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap1;
    }

    public static Bitmap handleImageRelief(Bitmap bitmap) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int oldPixels[] = new int[ width * height];
        int newPixels[] = new int[width * height];
        bitmap.getPixels(oldPixels,0,width,0,0, width, height);
        int color, colorBefore;
        int r,g,b,a,r1,g1,b1;
        for (int i = 1; i < width * height; i++) {
            colorBefore = oldPixels[i - 1];
            a = Color.alpha(colorBefore);
            r = Color.red(colorBefore);
            g = Color.green(colorBefore);
            b = Color.blue(colorBefore);

            color = oldPixels[i];
            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = (r - r1 + 127);
            g = (g - g1 + 127);
            b = (b - b1 + 127);
            if (r > 255) {
                r = 255;
            }
            if (g > 255) {
                g = 255;
            }
            if (b > 255) {
                b = 255;
            }
            newPixels[i] = Color.argb(a, r, g, b);
        }
        bitmap1.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap1;
    }
}
