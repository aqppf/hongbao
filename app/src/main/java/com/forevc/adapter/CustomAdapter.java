package com.forevc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.forevc.entity.SimpleMsg;
import com.forevc.hongbao.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<SimpleMsg> data;

    public CustomAdapter(Context context) {
        super();
        this.context = context;
        data = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);

        TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(data.get(i).getTitle());

        TextView content = (TextView) view.findViewById(R.id.item_content);
        content.setText(data.get(i).getContent());

        return view;
    }

    public List getData() {
        return this.data;
    }
}
