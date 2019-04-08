package com.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstdemo.R;
import com.example.model.Item;

import java.util.List;

public class InitAtapter extends ArrayAdapter<Item> {

    private int resource;

    public InitAtapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    /**
     * @param position list数据下标
     * @param convertView 当前布局的缓存
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item item = getItem(position);

        /**
         * 使用缓存避免每次都加载布局
         */
        View view;
        ViewHolder viewHolder = null;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resource, parent, false);

            viewHolder = new ViewHolder();
            ImageView imageView = view.findViewById(R.id.img);
            TextView textView = view.findViewById(R.id.text);

            viewHolder.imageView = imageView;
            viewHolder.textView = textView;
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(item.getName());
        viewHolder.imageView.setImageResource(item.getResource());

        return view;
    }

    class ViewHolder{
        ImageView imageView;

        TextView textView;
    }
}
