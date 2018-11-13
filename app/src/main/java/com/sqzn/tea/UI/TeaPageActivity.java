package com.sqzn.tea.UI;

import android.content.Context;
import android.widget.ListView;

import com.sqzn.tea.Adapter.FoodMaterielAdapter;
import com.sqzn.tea.Beans.FoodMateriel;
import com.sqzn.tea.Beans.TeaDto;
import com.sqzn.tea.MyApplication;
import com.sqzn.tea.R;
import com.sqzn.tea.Utils.MyUtils;
import com.sqzn.tea.greendao.TeaDtoDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeaPageActivity extends BaseActivity {
    private Context mContext;

    @BindView(R.id.lv_food_materiel_list)
    ListView lv_food_materiel_list;
    private List<FoodMateriel> data;

    @Override
    public void initViews() {
        mContext = this;
        setContentView(R.layout.activity_tea);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);

        data = new ArrayList<>();

//        TeaDtoDao teaDtoDao = MyApplication.getInstance().getmDaoSession().getTeaDtoDao();
//        List<TeaDto> teaDtos = teaDtoDao.loadAll();
        for (int i = 0; i < 6; i++) {
            FoodMateriel foodMateriel = new FoodMateriel();
            foodMateriel.setName("蒜末");
            foodMateriel.setUnit("适量");
            data.add(foodMateriel);
//            TeaDto teaDto = teaDtos.get(0);
//            data= teaDto.getFoodMaterielList();
        }

        FoodMaterielAdapter foodMaterielAdapter = new FoodMaterielAdapter(mContext, data);
        lv_food_materiel_list.setAdapter(foodMaterielAdapter);
        MyUtils.setScrollViewAndListViewBug(lv_food_materiel_list);

    }
}
