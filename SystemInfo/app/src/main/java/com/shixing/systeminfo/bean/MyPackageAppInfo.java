package com.shixing.systeminfo.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by shixing on 2017/9/7.
 */

public class MyPackageAppInfo {
    private Drawable appIcon;
    private String appLabel;
    private String packageName;

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
