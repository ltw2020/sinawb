package com.example.sinawb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;

import Util.HttpCallbackListener;
import Util.HttpUtil;
import Util.Json;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static RvAdapter rvAdapter=null;
    private SwipeRefreshLayout swipeRefresh;


    public static Handler mHandler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            ArrayList<RvData> list2 =(ArrayList)msg.obj;
            rvAdapter.setData(list2);
        }
    };

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAdapter=new RvAdapter();
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);

        HttpUtil.sendHttpGetRequest("https://v2.alapi.cn/api/new/wbtop?token=YKFChO0a2thlNZ99", new HttpCallbackListener() {
            @Override
            public void onResponse(String response) {
                Json json=new Json(response);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        swipeRefresh=findViewById(R.id.refreshlayout);
        swipeRefresh.setColorSchemeColors(R.color.design_default_color_primary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                HttpUtil.sendHttpGetRequest("https://v2.alapi.cn/api/new/wbtop?token=YKFChO0a2thlNZ99", new HttpCallbackListener() {
                    @Override
                    public void onResponse(String response) {
                        Json json=new Json(response);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                rvAdapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);

            }
        });

    }
}