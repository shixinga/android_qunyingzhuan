package com.shixing.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shixing on 2017/8/30.
 */

public class MyTopBarAttr extends RelativeLayout {

    //MyTopBar的3个控件
    Button mLeftButton,mRightButton;
    TextView mTitleTextView;

    //title的属性
    float mTitleTextSize;
    String mTitleText;
    int mTitleTextColor;

    //左边按钮的属性
    String mLeftButtonText;
    int mLeftButtonBackground;
    int mLeftButtonTextColor;

    //右边按钮的属性
    String mRightButtonText;
    int mRightButtonBackground;
    int mRightButtonTextColor;

    //上面3个view的布局变量
    LayoutParams mLeftLayoutParams,mTitleLayoutParams,mRightLayoutParams;

    public MyTopBarAttr(Context context) {
        super(context);
    }

    public MyTopBarAttr(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(MainActivity.TAG, "MyTopBarAttr attrs:" + attrs.toString());
        Log.d(MainActivity.TAG, "MyTopBarAttr topbar:" + R.styleable.TopBar);

        setBackgroundColor(Color.GREEN);

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleTextView = new TextView(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mTitleText = typedArray.getString(R.styleable.TopBar_title);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 10);

        mLeftButtonText = typedArray.getString(R.styleable.TopBar_leftText);
        mLeftButtonBackground = typedArray.getColor(R.styleable.TopBar_leftBackground,0);
        mLeftButtonTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);

        mRightButtonText = typedArray.getString(R.styleable.TopBar_rightText);
        mRightButtonBackground = typedArray.getColor(R.styleable.TopBar_rightBackground, 0);
        mRightButtonTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);

        // 获取完TypedArray的值后，一般要调用
        // recyle方法来避免重新创建的时候的错误
        typedArray.recycle();

        mTitleTextView.setText(mTitleText);
        mTitleTextView.setTextColor(mTitleTextColor);
        mTitleTextView.setTextSize(mTitleTextSize);
        mTitleTextView.setGravity(Gravity.CENTER);

        mLeftButton.setText(mLeftButtonText);
        mLeftButton.setTextColor(mLeftButtonTextColor);
        mLeftButton.setBackgroundColor(mLeftButtonBackground);

        mRightButton.setText(mRightButtonText);
        mRightButton.setTextColor(mRightButtonTextColor);
        mRightButton.setBackgroundColor(mRightButtonBackground);

        mLeftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        mRightLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        mTitleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);


        addView(mLeftButton,mLeftLayoutParams);
        addView(mTitleTextView,mTitleLayoutParams);
        addView(mRightButton,mRightLayoutParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mITopBarListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mITopBarListener.rightClick();
            }
        });
    }

    public MyTopBarAttr(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //添加点击事件
    private ITopBarListener mITopBarListener;

    //暴露借口给调用者
    public void setmITopBarListener(ITopBarListener mITopBarListener) {
        this.mITopBarListener = mITopBarListener;
    }

    public interface ITopBarListener {

        void leftClick();
        void rightClick();
    }

}
