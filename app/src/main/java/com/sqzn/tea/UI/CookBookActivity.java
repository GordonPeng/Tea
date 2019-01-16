package com.sqzn.tea.UI;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;

import com.sqzn.tea.Adapter.ListFoodMaterielAdapter;
import com.sqzn.tea.Adapter.ListStepAdapter;
import com.sqzn.tea.Beans.CookBookDto;
import com.sqzn.tea.Beans.FoodMateriel;
import com.sqzn.tea.Beans.Step;
import com.sqzn.tea.MyApplication;
import com.sqzn.tea.R;
import com.sqzn.tea.Utils.MyUtils;
import com.sqzn.tea.Utils.jsoupUtils.DouGuoCookBook;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CookBookActivity extends BaseActivity {
    private Context mContext;

    @BindView(R.id.lv_food_materiel_list)
    ListView lv_food_materiel_list;
    @BindView(R.id.steps)
    ListView lv_step_list;
    @BindView(R.id.img)
    ImageView img;


    private List<FoodMateriel> foodMaterielList;
    private List<Step> steps = new ArrayList<>();
    private AsyncTask masyn;
    private String id;

    @Override
    public void initViews() {
        mContext = this;
        setContentView(R.layout.activity_cookbook);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);


//        id = getIntent().getStringExtra("id");
        id="2024246";
//        Glide.with(mContext).load(ImgURL.img1).into(img).;

        foodMaterielList = new ArrayList<>();

//        TeaDtoDao teaDtoDao = MyApplication.getInstance().getmDaoSession().getTeaDtoDao();
//        List<CookBookDto> teaDtos = teaDtoDao.loadAll();
        for (int i = 0; i < 6; i++) {
            FoodMateriel foodMateriel = new FoodMateriel();
            foodMateriel.setName("蒜末");
            foodMateriel.setUnit("适量");
            foodMaterielList.add(foodMateriel);
        }
        for (int i = 0; i < 5; i++) {
            Step step = new Step();
            step.setStepImgUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white_fe6da1ec.png");
            step.setStepContent("步骤" + i);
            steps.add(step);
        }

        ListFoodMaterielAdapter foodMaterielAdapter = new ListFoodMaterielAdapter(mContext, foodMaterielList);
        lv_food_materiel_list.setAdapter(foodMaterielAdapter);
        MyUtils.setScrollViewAndListViewBug(lv_food_materiel_list);

        ListStepAdapter stepAdapter = new ListStepAdapter(mContext, steps);
        lv_step_list.setAdapter(stepAdapter);
        MyUtils.setScrollViewAndListViewBug(lv_step_list);

        masyn = new MAsyncTask().execute();
    }

    class MAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            if (isCancelled()) {
                return null;
            } else {
                CookBookDto cookBookDto = DouGuoCookBook.getInstance().getCookBookByID(id);


                return null;
            }
        }

        @Override
        protected void onPostExecute(Object o) {


        }
    }

}
