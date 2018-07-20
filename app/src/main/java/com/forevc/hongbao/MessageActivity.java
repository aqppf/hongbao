package com.forevc.hongbao;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.forevc.adapter.CustomAdapter;
import com.forevc.entity.SimpleMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MessageActivity extends Activity {

    private ListView messageListView;
    private CustomAdapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        messageListView = (ListView) findViewById(R.id.list_view_message);

        adapter = new CustomAdapter(this);

        adapter.getData().add(new SimpleMsg("司马懿", "这是个大人物，牛逼的很"));
        adapter.getData().add(new SimpleMsg("诸葛亮","飞一般的任务"));
        adapter.getData().add(new SimpleMsg("大乔小乔","两个漂亮的美女！"));

        messageListView.setAdapter(adapter);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                messageListView.addFooterView(getView("发红包，成功了"));
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                messageListView.addFooterView(getView("发红包，成功了2"));
            }
        }, 6000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                messageListView.addFooterView(getView("发红包，成功了3"));
            }
        }, 9000);

    }

    private View getView(String con) {

        View view = LayoutInflater.from(this).inflate(R.layout.item_layout, null);

        TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(con);

        TextView content = (TextView) view.findViewById(R.id.item_content);
        content.setText("内容是：88888888"+ con);

        return view;

    }

}
