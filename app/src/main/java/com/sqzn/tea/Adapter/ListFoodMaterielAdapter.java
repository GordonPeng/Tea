package com.sqzn.tea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sqzn.tea.Beans.FoodMateriel;
import com.sqzn.tea.R;

import java.util.List;

public class ListFoodMaterielAdapter extends BaseAdapter {
    private List<FoodMateriel> data;
    private Context context;

    public ListFoodMaterielAdapter(Context context, List<FoodMateriel> data) {
        this.context = context;
        this.data = data;
    }

    public List<FoodMateriel> getData() {
        return data;
    }

    public void setData(List<FoodMateriel> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewHolder holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_list_food_materiel, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.unit = (TextView) convertView.findViewById(R.id.unit);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        FoodMateriel foodMateriel = data.get(position);

        holder.name.setText(foodMateriel.getName());
        holder.unit.setText(foodMateriel.getUnit());
        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private TextView unit;
    }
}
