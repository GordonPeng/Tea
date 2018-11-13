package com.sqzn.tea.UI;

import android.content.Context;

import com.sqzn.tea.MyApplication;
import com.sqzn.tea.R;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private Context mContext;

    @Override
    public void initViews() {
        mContext = this;
        setContentView(R.layout.activity_main);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);



    }
}
