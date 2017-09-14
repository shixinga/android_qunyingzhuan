package com.shixing.listview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by shixing on 2017/9/1.
 */

public class ListViewItemAdapter extends BaseAdapter {
    Context mContext;
    String mStrs[];
    int mCurrentItem;
    public ListViewItemAdapter(Context context, String[] mStrs) {
        mContext = context;
        this.mStrs = mStrs;
    }

    @Override
    public int getCount() {
        return mStrs.length;
    }

    @Override
    public Object getItem(int position) {
        return mStrs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mContext);
        if(mCurrentItem == position) {
            tv.setText("你选中我了!");
        } else {
            tv.setText(mStrs[position]);
        }
        return tv;
    }

    public void setmCurrentItem(int mCurrentItem) {
        this.mCurrentItem = mCurrentItem;
    }
}
