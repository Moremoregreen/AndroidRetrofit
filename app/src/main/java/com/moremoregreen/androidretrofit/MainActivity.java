package com.moremoregreen.androidretrofit;


import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moremoregreen.androidretrofit.Model.Ip;
import com.moremoregreen.androidretrofit.Remote.IpService;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private IpService mService;
    private TextView tvIP;
    private Button btnGetIP;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();
        btnGetIP =  findViewById(R.id.btnGetIP);
        tvIP = findViewById(R.id.tvIP);
        dialog = new SpotsDialog(MainActivity.this);  //不要import到V7

        btnGetIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                getIPAddress();

            }
        });


    }

    private void getIPAddress() {
        mService.getIP().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                dialog.dismiss();
                tvIP.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                dialog.dismiss();
            }
        });
    }
}
