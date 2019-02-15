package com.bw.core;

import com.bw.bean.Goods;
import com.bw.config.HttpConfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 1607c王晴
 * date 2019/2/15
 * Describe:
 */
public interface IRequest {
    @GET(HttpConfig.Goods_url)
    Call<Goods> getGoods(@Query("keyword")String keyword,
                         @Query("page")int page,
                         @Query("count")int count);
}
