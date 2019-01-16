package com.sqzn.tea.Utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sqzn.tea.MyApplication;

public class MyUtils {
    /**
     *  双击退出程序
     */
    private static long mExitTime = 0;
    public static void BackToLanuch(Context mContext) {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(mContext,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
//            Glide.get(mContext).clearMemory();//清除内存缓存
            MyApplication.getInstance().exit();
        }
    }

    /**
     * 解决ScrollView和Listview结合使用，高度显示错误的Bug
     *
     */
    public static void setScrollViewAndListViewBug(ListView viewList) {
//        ListAdapter adapter = viewList.getAdapter();
//        int count = adapter.getCount();// 获取行数
//        int totalHeight = 0;// 总高度
//        for (int i = 0; i < count; i++) {
//            View view = adapter.getView(i, null, viewList);
//            view.measure(View.MeasureSpec.UNSPECIFIED,
//                    View.MeasureSpec.UNSPECIFIED);
//            if (i == count - 1) {
//                totalHeight += (view.getMeasuredHeight() + 70);
//                break;
//            }
//            totalHeight += view.getMeasuredHeight();
//        }
//        ViewGroup.LayoutParams params = viewList.getLayoutParams();
//        params.height = totalHeight
//                + (viewList.getDividerHeight() * (adapter.getCount() - 1));
//        viewList.setLayoutParams(params);



        if(viewList == null) return;

        ListAdapter listAdapter = viewList.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, viewList);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = viewList.getLayoutParams();
        params.height = totalHeight + (viewList.getDividerHeight() * (listAdapter.getCount() - 1));
        viewList.setLayoutParams(params);
    }
}
