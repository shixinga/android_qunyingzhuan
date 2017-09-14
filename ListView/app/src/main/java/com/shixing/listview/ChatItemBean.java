package com.shixing.listview;

import android.graphics.Bitmap;

/**
 * Created by shixing on 2017/9/1.
 */

public class ChatItemBean {
    private int type;
    private String text;
    private Bitmap icon_bm;

    public ChatItemBean(int type, String text, Bitmap icon_bm) {
        this.type = type;
        this.text = text;
        this.icon_bm = icon_bm;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon_bm() {
        return icon_bm;
    }

    public void setIcon_bm(Bitmap icon_bm) {
        this.icon_bm = icon_bm;
    }
}
