package com.shixing.systeminfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shixing.systeminfo.R;
import com.shixing.systeminfo.bean.MyActivityAppProcessInfo;

import java.util.List;

/**
 * Created by shixing on 2017/9/7.
 */

public class ActivityManagerAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflator;
    private List<MyActivityAppProcessInfo> mList;

    public ActivityManagerAdapter(Context context, List<MyActivityAppProcessInfo> mList) {
        this.mLayoutInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        MyViewHolder myViewHolder;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            convertView = mLayoutInflator.inflate(R.layout.item_activity_manager, null);
            myViewHolder.tv_uid_vh = (TextView) convertView.findViewById(R.id.tv_uid_activity_manager);
            myViewHolder.tv_pid_vh = (TextView) convertView.findViewById(R.id.tv_pid_activity_manager);
            myViewHolder.tv_memorysize_vh = (TextView) convertView.findViewById(R.id.tv_memorysize_activity_manager);
            myViewHolder.tv_proccessname_vh = (TextView) convertView.findViewById(R.id.tv_processname_activity_manager);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.tv_pid_vh.setText(mList.get(position).getPid());
        myViewHolder.tv_uid_vh.setText(mList.get(position).getUid());
        myViewHolder.tv_memorysize_vh.setText(mList.get(position).getMemorySize());
        myViewHolder.tv_proccessname_vh.setText(mList.get(position).getProcessName());
        return convertView;
    }

    public class MyViewHolder {
        TextView tv_uid_vh;
        TextView tv_pid_vh;
        TextView tv_memorysize_vh;
        TextView tv_proccessname_vh;
    }
}
