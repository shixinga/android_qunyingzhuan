package com.shixing.customview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by shixing on 2017/8/30.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra("flag", 0);
        switch (flag) {
            case 0:
                setContentView(R.layout.view_first);
                break;
            case 1:
                setContentView(R.layout.view_text);
                break;
            case 2:
                setContentView(R.layout.view_shine);
                break;
            case 3:
                setContentView(R.layout.viewgroup_topbar);
                MyTopBarAttr my_top_bar = (MyTopBarAttr) findViewById(R.id.my_top_bar);
                my_top_bar.setmITopBarListener(new MyTopBarAttr.ITopBarListener() {
                    @Override
                    public void leftClick() {
                        Toast.makeText(SecondActivity.this, "点击了左边按钮", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void rightClick() {
                        Toast.makeText(SecondActivity.this, "点了右边！", Toast.LENGTH_SHORT).show();
                    }
                });

            case 4:
                setContentView(R.layout.include_topbar);
                break;

            case 5:
                setContentView(R.layout.view_cricle);
                break;
            case 6:
                setContentView(R.layout.view_volume);
                break;
            case 7:
                setContentView(R.layout.view_scroll);
                break;
            case 8:
                setContentView(R.layout.touch_event);
                break;
            default:
                break;
        }
    }
}
