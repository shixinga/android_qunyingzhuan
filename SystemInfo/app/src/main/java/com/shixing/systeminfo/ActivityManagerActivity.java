package com.shixing.systeminfo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import com.shixing.systeminfo.adapter.ActivityManagerAdapter;
import com.shixing.systeminfo.bean.MyActivityAppProcessInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixing on 2017/9/7.
 */

public class ActivityManagerActivity extends Activity {
    private static final String TAG = "ActivityManagerActivity";
    ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitymanager);
        mListView = (ListView) findViewById(R.id.lv_activity_manager);
        ActivityManagerAdapter activityManagerAdapter = new ActivityManagerAdapter(this,getRunningProcessInfo());
        mListView.setAdapter(activityManagerAdapter);
    }

    private List<MyActivityAppProcessInfo> getRunningProcessInfo() {
        List<MyActivityAppProcessInfo> list = new ArrayList<>();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcessInfoList) {
            int pid = runningAppProcessInfo.pid;
            int uid = runningAppProcessInfo.uid;
            MyActivityAppProcessInfo myActivityAppProcessInfo = new MyActivityAppProcessInfo();
            myActivityAppProcessInfo.setPid("pid:"+pid);
            myActivityAppProcessInfo.setUid("uid"+uid + "");
            myActivityAppProcessInfo.setProcessName(runningAppProcessInfo.processName);
            int memoryPid[] = new int []{pid};
            Debug.MemoryInfo [] memoryInfos = activityManager.getProcessMemoryInfo(memoryPid);
            int memorySize = memoryInfos[0].getTotalPss();
            myActivityAppProcessInfo.setMemorySize(memorySize + "KB");
            Log.d(TAG, "getRunningProcessInfo: ");
            list.add(myActivityAppProcessInfo);
        }

        return list;
    }
}
