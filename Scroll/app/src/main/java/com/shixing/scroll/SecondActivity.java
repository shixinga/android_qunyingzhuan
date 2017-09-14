package com.shixing.scroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by shixing on 2017/9/2.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra("flag", 0);
        switch (flag) {
            case 1:
                setContentView(R.layout.activity_layout);
                break;

            case 2:
                setContentView(R.layout.activity_offset_leftandright_topandbottom);
                break;
            case 3:
                setContentView(R.layout.activity_layoutparams);
                break;
            case 4:
                setContentView(R.layout.activity_scrollby);
                break;
            case 5:
                setContentView(R.layout.activity_scrollto);
                break;
            default:
                break;
        }
    }

}
