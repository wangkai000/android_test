package com.test.android_demo1.android_demo1.api;

import com.test.android_demo1.android_demo1.bean.LogInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/10/16.
 */
//接口类名
public interface NetWorks {
    @GET("/registerLogin")
    Call<LogInfo> startLogin(@Query("name") String name,
                             @Query("password") String pwd
    );



    @POST("/registerLogin")
    Call<LogInfo> startLogin1(@Query("name") String name,
                             @Query("password") String pwd
    );
}
