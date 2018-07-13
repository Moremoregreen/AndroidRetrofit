package com.moremoregreen.androidretrofit.Remote;

import com.moremoregreen.androidretrofit.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {
    @GET("/")
    Call<Ip> getIP();
}
