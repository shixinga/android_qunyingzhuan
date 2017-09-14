package com.shixing.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixing.listview.ChatItemBean;
import com.shixing.listview.R;

import java.util.List;

/**
 * Created by shixing on 2017/9/1.
 */

public class ChatAdapter extends BaseAdapter {
    LayoutInflater mLayoutInflater;
    List<ChatItemBean> mList;

    public ChatAdapter(Context context, List<ChatItemBean> mList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mList = mList;
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
        ChatItemBean cib = mList.get(position);
        MyViewHolder myViewHolder;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            if (cib.getType() == 0) { //0表示自己， 1表示对方
               convertView = mLayoutInflater.inflate(R.layout.item_chat_in, null);
                myViewHolder.iv_vh = (ImageView) convertView.findViewById(R.id.iv_item_chat_in);
                myViewHolder.tv_vh = (TextView) convertView.findViewById(R.id.tv_item_chat_in);
            } else {
                convertView = mLayoutInflater.inflate(R.layout.item_chat_out, null);
                myViewHolder.iv_vh = (ImageView) convertView.findViewById(R.id.iv_item_chat_out);
                myViewHolder.tv_vh = (TextView) convertView.findViewById(R.id.tv_item_chat_out);
            }
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.iv_vh.setImageBitmap(cib.getIcon_bm());
        myViewHolder.tv_vh.setText(cib.getText());
        return convertView;
    }

    class MyViewHolder {
        ImageView iv_vh;
        TextView tv_vh;
    }
}
