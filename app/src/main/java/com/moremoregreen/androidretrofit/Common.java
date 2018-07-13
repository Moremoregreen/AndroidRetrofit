package com.moremoregreen.androidretrofit;

import com.moremoregreen.androidretrofit.Remote.IpService;
import com.moremoregreen.androidretrofit.Remote.RetrofitClient;



public class Common {
    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService(){
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
