package com.shixing.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shixing.listview.adapter.ListViewItemAdapter;

/**
 * Created by shixing on 2017/9/1.
 */

public class ListViewItemClickActivity extends Activity {

    String mStrs[] = new String[20];
    ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_item);
        mListView = (ListView) findViewById(R.id.lv_click_item);
        for(int i = 0; i < 20; ++i) {
            mStrs[i] = "item " + i;
        }

        final ListViewItemAdapter listViewItemAdapter = new ListViewItemAdapter(this, mStrs);
        mListView.setAdapter(listViewItemAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewItemAdapter.setmCurrentItem(position);
                listViewItemAdapter.notifyDataSetChanged();
            }
        });

    }
}
