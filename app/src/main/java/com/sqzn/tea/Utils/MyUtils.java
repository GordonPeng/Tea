package com.sqzn.tea.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyUtils {
    /**
     * 解决ScrollView和Listview结合使用，高度显示错误的Bug
     *
     * @param view
     */
    public static void setScrollViewAndListViewBug(ListView viewList) {
        ListAdapter adapter = viewList.getAdapter();
        int count = adapter.getCount();// 获取行数
        int totalHeight = 0;// 总高度
        for (int i = 0; i < count; i++) {
            View view = adapter.getView(i, null, viewList);
            view.measure(View.MeasureSpec.UNSPECIFIED,
                    View.MeasureSpec.UNSPECIFIED);
            if (i == count - 1) {
                totalHeight += (view.getMeasuredHeight() + 70);
                break;
            }
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = viewList.getLayoutParams();
        params.height = totalHeight
                + (viewList.getDividerHeight() * (adapter.getCount() - 1));
        viewList.setLayoutParams(params);
    }
}
