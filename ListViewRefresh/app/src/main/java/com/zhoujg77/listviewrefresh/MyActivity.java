package com.zhoujg77.listviewrefresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by 建刚 on 2014/11/16.
 */
public class MyActivity extends Activity implements  SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mListView = (ListView) findViewById(R.id.lv_list);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData()));

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.ly_swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }





    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },5000);

    }

    public ArrayList<String> getData() {
        list.add("你好！");
        list.add("下拉刷新！");
        list.add("你好!!！");
        list.add("下拉刷新!!！");
        list.add("你好!!！");
        list.add("下拉刷新!!!！");
        return list;
    }
}
