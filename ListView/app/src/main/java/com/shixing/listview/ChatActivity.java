package com.shixing.listview;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.shixing.listview.adapter.ChatAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixing on 2017/9/1.
 */

public class ChatActivity extends Activity {

    private List<ChatItemBean> mList = new ArrayList<>();
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mList.add(new ChatItemBean(0,"how are you?", BitmapFactory.decodeResource(getResources(), R.drawable.in_icon)));
        mList.add(new ChatItemBean(1,"I'm fine,thanks,how are you?", BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
        mList.add(new ChatItemBean(0,"I am fine,thanks", BitmapFactory.decodeResource(getResources(), R.drawable.in_icon)));
        mList.add(new ChatItemBean(1,"bye bye", BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
        mList.add(new ChatItemBean(0,"see you", BitmapFactory.decodeResource(getResources(), R.drawable.in_icon)));
        mListView = (ListView) findViewById(R.id.lv_chat);
        mListView.setAdapter(new ChatAdapter(this, mList));

    }
}
