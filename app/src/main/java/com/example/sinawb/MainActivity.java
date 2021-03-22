package com.example.sinawb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

import Util.HttpUtil;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static RvAdapter rvAdapter=null;


    public static Handler mHandler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            ArrayList<RvData> list2 =(ArrayList)msg.obj;
            rvAdapter.setData(list2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAdapter=new RvAdapter();
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);

        HttpUtil.sendHttpGetRequest("https://v2.alapi.cn/api/new/wbtop?token=YKFChO0a2thlNZ99");

    }
}