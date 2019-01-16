package com.sqzn.tea.UI;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.sqzn.tea.Adapter.FlowAdapter;
import com.sqzn.tea.Adapter.ListMainTuijianAdapter;
import com.sqzn.tea.Beans.CookBookDto;
import com.sqzn.tea.MyApplication;
import com.sqzn.tea.R;
import com.sqzn.tea.Utils.MyUtils;
import com.sqzn.tea.Utils.jsoupUtils.DouGuoMain;
import com.sqzn.tea.Views.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private Context mContext;

    @BindView(R.id.flowlayout_hot)
    FlowLayout flowlayout_hot;
    @BindView(R.id.lv_tuijian)
    ListView lv_tuijian;

    private List<String> data = new ArrayList<>();
    private List<CookBookDto> dataTuijian = new ArrayList<>();
    private FlowAdapter flowAdapter;
    private ListMainTuijianAdapter listMainTuijianAdapter;
    private AsyncTask masyn;
    private List<String> getcookbookIds = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private List<String> author = new ArrayList<>();
    private List<String> imgUrl = new ArrayList<>();

    @Override
    public void initViews() {
        mContext = this;
        setContentView(R.layout.activity_main);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);

        data.add("早餐");
        data.add("蛋糕");
        data.add("茶");
        data.add("烘焙");
        flowAdapter = new FlowAdapter(mContext, data);
        flowlayout_hot.setAdapter(flowAdapter);

        flowlayout_hot.setOnItemClickListener(new FlowLayout.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                startActivity(new Intent(mContext, MenuActivity.class));
            }
        });

        initTuiJian();

    }

    class MAsyncTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            if (isCancelled()) {
                return null;
            } else {
                DouGuoMain getCookBook = new DouGuoMain();
                getcookbookIds = getCookBook.getcookbookId();
                title = getCookBook.getcookbookTitle();
                author = getCookBook.getcookbookAuthor();
                imgUrl = getCookBook.getcookbookImgUrl();
                Log.d(">>>", getcookbookIds.toString());
                Log.d(">>>", title.toString());
                Log.d(">>>", author.toString());
                Log.d(">>>", imgUrl.toString());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Object o) {
            if (getcookbookIds != null && title != null && author != null && imgUrl != null) {
                for (int i = 0; i < getcookbookIds.size(); i++) {
                    CookBookDto cookBookDto = new CookBookDto();
                    cookBookDto.setId(getcookbookIds.get(i));
                    cookBookDto.setName(title.get(i));
                    cookBookDto.setAuthor(author.get(i));
                    cookBookDto.setPictureImgUrl(imgUrl.get(i));
                    dataTuijian.add(cookBookDto);
                }


                listMainTuijianAdapter.setData(dataTuijian);
//                MyUtils.setScrollViewAndListViewBug(lv_tuijian);

            } else {
//                lv_menu.setEmptyView();
            }
        }
    }

    private void initTuiJian() {
        listMainTuijianAdapter = new ListMainTuijianAdapter(mContext, dataTuijian);
        lv_tuijian.setAdapter(listMainTuijianAdapter);
        lv_tuijian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, CookBookWebView.class);
                intent.putExtra("id", listMainTuijianAdapter.getData().get(position).getId());
                startActivity(intent);
            }
        });

        masyn = new MAsyncTask().execute();

    }


    //双击退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            MyUtils.BackToLanuch(mContext);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
