package com.sqzn.tea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sqzn.tea.Beans.CookBookDto;
import com.sqzn.tea.R;
import com.sqzn.tea.UI.BaseActivity;

import java.util.List;

/**
 * @Create By Pengli
 * @On 2019/1/7 15:25
 * @org www.fictime.com  ( 湖北思勤智能装备有限公司)
 * @describe 类描述：
 **/
public class ListMenuAdapter extends BaseAdapter {
    Context mContext;
    List<CookBookDto> data;

    public ListMenuAdapter(Context mContext, List<CookBookDto> data) {
        this.data=data;
        this.mContext=mContext;
    }

    public List<CookBookDto> getData() {
        return data;
    }

    public void setData(List<CookBookDto> data) {
        this.data = data;
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_list_menu, null);
            holder.imageView = convertView.findViewById(R.id.img_menu_item);
            holder.name =  convertView.findViewById(R.id.tv_menu_item_name);
            holder.author =  convertView.findViewById(R.id.tv_menu_item_author);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        CookBookDto CookBookDto = data.get(position);
        holder.name.setText(CookBookDto.getName());
        holder.author.setText(CookBookDto.getAuthor());
        Glide.with(mContext)
                .load(CookBookDto.getPictureImgUrl())
                .into(holder.imageView);
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView name;
        private TextView author;

    }
}
