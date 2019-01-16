package com.sqzn.tea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sqzn.tea.Beans.FoodMateriel;
import com.sqzn.tea.Beans.Step;
import com.sqzn.tea.R;

import java.util.List;

public class ListStepAdapter extends BaseAdapter {
    private List<Step> data;
    private Context context;

    public ListStepAdapter(Context context, List<Step> data) {
        this.context = context;
        this.data = data;
    }

    public List<Step> getData() {
        return data;
    }

    public void setData(List<Step> data) {
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
                    R.layout.item_list_steps, null);
            holder.stepImg =  convertView.findViewById(R.id.iv_item_list_steps_img);
            holder.stepContent =  convertView.findViewById(R.id.tv_item_list_steps_content);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Step step = data.get(position);

        holder.stepImg.setImageDrawable(context.getResources().getDrawable(R.mipmap.img1));
        holder.stepContent.setText(step.getStepContent());
        return convertView;
    }

    class ViewHolder {
        private ImageView stepImg;
        private TextView stepContent;
    }
}
