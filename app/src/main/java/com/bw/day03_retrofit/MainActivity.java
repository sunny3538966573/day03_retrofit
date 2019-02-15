package com.bw.day03_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.adapter.MyAdapter;
import com.bw.bean.Goods;
import com.bw.config.HttpConfig;
import com.bw.core.IRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recy)
    RecyclerView recy;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getDataFromNet();
    }

    private void getDataFromNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRequest iRequest = retrofit.create(IRequest.class);
        iRequest.getGoods("板鞋", 1, 5).enqueue(new Callback<Goods>() {
            @Override
            public void onResponse(Call<Goods> call, Response<Goods> response) {
                Goods goods = response.body();
                List<Goods.ResultBean> result = goods.getResult();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.VERTICAL, false);
                recy.setLayoutManager(gridLayoutManager);
                myAdapter = new MyAdapter(MainActivity.this, result);
                recy.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Goods> call, Throwable t) {

            }
        });
    }
}
