package com.shixing.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.shixing.listview.mylistview.FlexableListView;

/**
 * Created by shixing on 2017/9/1.
 */

public class FlexableActivity extends Activity {
    String strs[] = new String[30];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexable);
        for(int i = 0; i < 30; ++i) {
            strs[i] = "第" + i + "个item";
        }
        FlexableListView flexableListView = (FlexableListView) findViewById(R.id.lv_flexable);
        flexableListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
    }

}
