package com.bawei.dayds_20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.dayds_20.adapter.MyAdapter;
import com.bawei.dayds_20.bean.UserBean;
import com.bawei.dayds_20.mvp.RegisPresenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Icunt.IView {

    private Icunt.IPresenter iPresenter;
    private RecyclerView recycleview;
    private String path="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        iPresenter=new RegisPresenter(this);
        iPresenter.startFrimdata(this,path);
    }

    @Override
    public void getData(String json) {
        Gson gson=new Gson();
        Log.i("sss",json);
        UserBean userBean = gson.fromJson(json, UserBean.class);
        List<UserBean.ResultBean> result = userBean.getResult();
        Log.i("sss",result.size()+"");

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycleview.setLayoutManager(linearLayoutManager);

        MyAdapter adapter=new MyAdapter(result,this);
        recycleview.setAdapter(adapter);


    }
}
