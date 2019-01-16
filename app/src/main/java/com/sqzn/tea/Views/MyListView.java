package com.sqzn.tea.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @Create By Pengli
 * @On 2019/1/12 15:56
 * @org www.fictime.com  ( 湖北思勤智能装备有限公司)
 * @describe 类描述：
 **/
public class MyListView  extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
