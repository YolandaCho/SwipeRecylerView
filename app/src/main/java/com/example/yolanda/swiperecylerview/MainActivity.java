package com.example.yolanda.swiperecylerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private ManagerCityAdapter managerCityAdapter;
    private ArrayList<String> stringArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_city_layout);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void initData() {
        stringArrayList = new ArrayList<>();
        for (int i = 0 ; i < 15; i ++) {
            stringArrayList.add(i, "item --> " + i);
        }
        managerCityAdapter = new ManagerCityAdapter(this, stringArrayList);
        recyclerView.setAdapter(managerCityAdapter);
    }
}
