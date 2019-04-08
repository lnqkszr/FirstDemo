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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource, parent, false);

        ImageView img = view.findViewById(R.id.img);
        TextView textView = view.findViewById(R.id.text);
        img.setImageResource(item.getResource());
        textView.setText(item.getName());

        return view;
    }
}
