package com.shixing.systeminfo;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.shixing.systeminfo.adapter.PackageManagerAdapter;
import com.shixing.systeminfo.bean.MyPackageAppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixing on 2017/9/7.
 */

public class PackageManagerActivity extends Activity {
    ListView mListView;
    PackageManager mPackageManager;
    private static final int ALL_APP_INFO = 0;
    private static final int SYSTEM_APP_INFO = 1;
    private static final int THIRD_PART_APP_INFO = 2;
    private static final int SDCARD_APP_INFO = 3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packagemanager);
        mListView = (ListView) findViewById(R.id.lv_package_manager);
    }

    public void allAppInfo(View view) {
        setListData(ALL_APP_INFO);
    }

    public void systemAppInfo(View view) {
        setListData(SYSTEM_APP_INFO);
    }
    public void thirdPartAppInfo(View view) {
        setListData(THIRD_PART_APP_INFO);
    }
    public void sdCardAppInfo(View view) {
        setListData(SDCARD_APP_INFO);
    }
    public void setListData(int flag) {
        PackageManagerAdapter packageManagerAdapter = new PackageManagerAdapter(this,getAppInfos(flag));
        mListView.setAdapter(packageManagerAdapter);
    }
    public List<MyPackageAppInfo> getAppInfos(int flag) {
         mPackageManager = this.getPackageManager();
        List<ApplicationInfo> applicationInfoList = mPackageManager.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        List<MyPackageAppInfo> myPackageAppInfoList = new ArrayList<>();
        switch (flag) {
            case ALL_APP_INFO:
                for (ApplicationInfo applicationInfo : applicationInfoList) {
                    myPackageAppInfoList.add(makeMyPackageAppInfo(applicationInfo));
                }
                break;

            case SYSTEM_APP_INFO:
                for (ApplicationInfo applicationInfo : applicationInfoList) {
                    if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        myPackageAppInfoList.add(makeMyPackageAppInfo(applicationInfo));
                    }
                }
                break;

            case THIRD_PART_APP_INFO:
                for (ApplicationInfo applicationInfo : applicationInfoList) {
                    if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0 ||
                            (applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                        myPackageAppInfoList.add(makeMyPackageAppInfo(applicationInfo));
                    }
                }
                break;
            case SDCARD_APP_INFO:
                for (ApplicationInfo applicationInfo : applicationInfoList) {
                    if ((applicationInfo.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
                        myPackageAppInfoList.add(makeMyPackageAppInfo(applicationInfo));
                    }
                }
                break;
            default:
                break;
        }
        return myPackageAppInfoList;
    }

    public MyPackageAppInfo makeMyPackageAppInfo(ApplicationInfo applicationInfo) {
        MyPackageAppInfo myPackageAppInfo = new MyPackageAppInfo();
        myPackageAppInfo.setAppIcon(applicationInfo.loadIcon(mPackageManager));
        myPackageAppInfo.setAppLabel((String)applicationInfo.loadLabel(mPackageManager));
        myPackageAppInfo.setPackageName(applicationInfo.packageName);
        return myPackageAppInfo;
    }
}
