package com.shixing.listview.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by shixing on 2017/9/1.
 */

public class FlexableListView extends ListView {
    int mMaxOverDistance = 50;

    public FlexableListView(Context context) {
        super(context);
        initView(context);
    }

    public FlexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FlexableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float density = dm.density;
        mMaxOverDistance = (int)(density * mMaxOverDistance);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
                mMaxOverDistance,
                isTouchEvent);
    }
}
