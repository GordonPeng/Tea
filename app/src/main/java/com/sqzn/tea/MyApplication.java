package com.sqzn.tea;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;


import com.sqzn.tea.greendao.DaoMaster;
import com.sqzn.tea.greendao.DaoSession;

import java.util.LinkedList;
import java.util.List;


public class MyApplication extends Application {
    private static final String DBNAME = "se.db";
    private static MyApplication instance;
    private List<Activity> activitys = new LinkedList<Activity>();
    private DaoMaster.DevOpenHelper helper;
    private DaoSession mDaoSession;

    /**
     * 单例模式中获取唯一的MyApplication实例
     */
    public static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        helper = new DaoMaster.DevOpenHelper(this, DBNAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();


    }


    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activitys != null && activitys.size() >= 0) {
            activitys.add(activity);
        }
    }

    public void removelastActivity() {
        if (activitys != null && activitys.size() > 0) {
            activitys.remove(activitys.size() - 1);
        }
    }

    public Activity getlastActivity() {
        if (activitys.size() >= 1) {
            return activitys.get(activitys.size() - 1);
        } else {
            return null;
        }
    }

    // 遍历所有Activity并finish
    public void exit() {
        if (activitys != null && activitys.size() > 0) {
            for (Activity activity : activitys) {
                activity.finish();
            }
            activitys.clear();
        }
    }

}
