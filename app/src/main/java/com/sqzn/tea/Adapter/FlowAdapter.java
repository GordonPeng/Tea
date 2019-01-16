package com.sqzn.tea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sqzn.tea.R;

import java.util.List;

/**
 * @Create By Pengli
 * @On 2019/1/7 14:38
 * @org www.fictime.com  ( 湖北思勤智能装备有限公司)
 * @describe 类描述：
 **/
public class FlowAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public FlowAdapter(Context context, List<String> data) {
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewHolder holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.flowlayout_item_terms, null);
            holder.type = (TextView) convertView.findViewById(R.id.tv_gv_item_new);
            convertView.setTag(holder);
        }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.type.setText(data.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView type;
    }
}
