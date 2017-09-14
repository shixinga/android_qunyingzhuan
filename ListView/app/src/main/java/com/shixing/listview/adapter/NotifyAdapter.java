package com.shixing.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixing.listview.R;

import java.util.List;

/**
 * Created by shixing on 2017/9/1.
 */

public class NotifyAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public NotifyAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder vh;
        if(convertView == null) {
            vh = new MyViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_notify, null);
            vh.vh_iv = (ImageView) convertView.findViewById(R.id.image_view);
            vh.vh_tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(vh);
        } else {
            vh = (MyViewHolder) convertView.getTag();
        }
        vh.vh_iv.setBackgroundResource(R.mipmap.ic_launcher);
        vh.vh_tv.setText(mList.get(position));
        return convertView;
    }


    class MyViewHolder {
        ImageView vh_iv;
        TextView vh_tv;
    }
}
