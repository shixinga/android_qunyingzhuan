package com.shixing.systeminfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixing.systeminfo.R;
import com.shixing.systeminfo.bean.MyPackageAppInfo;

import java.util.List;

/**
 * Created by shixing on 2017/9/7.
 */

public class PackageManagerAdapter extends BaseAdapter {
    LayoutInflater mLayoutInflater;
    List<MyPackageAppInfo> mList;

    public PackageManagerAdapter(Context context, List<MyPackageAppInfo> mList) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_package_manager,null);
            viewHolder.tv_applabel_vh = (TextView) convertView.findViewById(R.id.tv_label_package_manager);
            viewHolder.tv_apppackagename_vh = (TextView) convertView.findViewById(R.id.tv_packagename_package_manager);
            viewHolder.iv_appicon_vh = (ImageView) convertView.findViewById(R.id.iv_package_manager);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_appicon_vh.setImageDrawable(mList.get(position).getAppIcon());
        viewHolder.tv_applabel_vh.setText(mList.get(position).getAppLabel());
        viewHolder.tv_apppackagename_vh.setText(mList.get(position).getPackageName());
        return convertView;
    }

    public class ViewHolder {
        ImageView iv_appicon_vh;
        TextView tv_applabel_vh;
        TextView tv_apppackagename_vh;
    }
}
