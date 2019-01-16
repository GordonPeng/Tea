package com.sqzn.tea.UI;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sqzn.tea.Adapter.ListMenuAdapter;
import com.sqzn.tea.Beans.CookBookDto;
import com.sqzn.tea.MyApplication;
import com.sqzn.tea.R;
import com.sqzn.tea.Utils.jsoupUtils.DouGuoMain;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Create By Pengli
 * @On 2019/1/7 15:15
 * @org www.fictime.com  ( 湖北思勤智能装备有限公司)
 * @describe 类描述：
 **/
public class MenuActivity extends BaseActivity {
    private Context mContext;
    @BindView(R.id.lv_menu)
    ListView lv_menu;
    private ListMenuAdapter listMenuAdapter;
    private List<CookBookDto> data = new ArrayList<>();
    private AsyncTask masyn;
    private List<String> getcookbookIds = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private List<String> author = new ArrayList<>();
    private List<String> imgUrl = new ArrayList<>();

    @Override
    public void initViews() {
        mContext = this;
        setContentView(R.layout.activity_menu);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);


        masyn = new MAsyncTask().execute();
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
            if (getcookbookIds != null && title != null && author != null&& imgUrl != null) {
                for (int i = 0; i < getcookbookIds.size(); i++) {
                    CookBookDto cookBookDto = new CookBookDto();
                    cookBookDto.setId(getcookbookIds.get(i));
                    cookBookDto.setName(title.get(i));
                    cookBookDto.setAuthor(author.get(i));
                    cookBookDto.setPictureImgUrl(imgUrl.get(i));
                    data.add(cookBookDto);
                }
                listMenuAdapter = new ListMenuAdapter(mContext, data);
                lv_menu.setAdapter(listMenuAdapter);
                lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent intent = new Intent(mContext, CookBookActivity.class);
                        Intent intent = new Intent(mContext, CookBookWebView.class);
                        intent.putExtra("id" ,listMenuAdapter.getData().get(position).getId());
                        startActivity(intent);
                    }
                });

            } else {
//                lv_menu.setEmptyView();
            }
        }
    }
}
