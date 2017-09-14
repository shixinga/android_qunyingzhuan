package com.shixing.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.shixing.listview.adapter.NotifyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixing on 2017/9/1.
 */

public class NotifyActivity extends Activity {

    ListView mListView;
    List<String> mList = new ArrayList<>();
    NotifyAdapter mNotifyAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        mListView = (ListView) findViewById(R.id.lv);

        for(int i = 0; i < 20; ++i) {
            mList.add("第" + i + "个item！");
        }

        mNotifyAdapter = new NotifyAdapter(this, mList);
        mListView.setAdapter(mNotifyAdapter);

        //题外话
        //ListView的两种监听事件：OnTouchListener 和OnScrollListener
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(MainActivity.TAG, "onTouch: down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(MainActivity.TAG, "onTouch: move");

                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(MainActivity.TAG, "onTouch: up");

                        break;
                }
                return false;
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE: //滚动停止时
                        Log.d(MainActivity.TAG, "onScrollStateChanged:SCROLL_STATE_IDLE ");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING://手指抛动时（即手指用力滑动）
                        Log.d(MainActivity.TAG, "onScrollStateChanged: SCROLL_STATE_FLING");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL: //正在滚动时
                        Log.d(MainActivity.TAG, "onScrollStateChanged: SCROLL_STATE_TOUCH_SCROLL");
                        break;
                }
            }

            int lstVisibleItemPosition = 0;
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //滚动时一直调用
                Log.d(MainActivity.TAG, "onScroll: ");

                if(firstVisibleItem > lstVisibleItemPosition) {
                    Log.d(MainActivity.TAG, "onScroll:向上滚动 ");
                } else if(firstVisibleItem < lstVisibleItemPosition) {
                    Log.d(MainActivity.TAG, "onScroll:向下滚动 ");
                }
                lstVisibleItemPosition = firstVisibleItem;
            }
        });
    }

    public void addAnItem(View view) {
        mList.add("button 加的");
        mNotifyAdapter.notifyDataSetChanged();
        mListView.setSelection(mList.size() - 1);
    }

}
