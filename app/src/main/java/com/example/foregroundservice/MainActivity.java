package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.foregroundservice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ButtonClickCallback{

    private final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setCallBack(this);
    }

    @Override
    public void onStartService() {
        Log.v(TAG,"===>>> onStartService");

        Intent intent = new Intent(this, DemoForegroundService.class);
        startService(intent);
    }

    @Override
    public void onStopService() {
        Log.v(TAG,"===>>> onStopService");
        Intent serviceIntent = new Intent(this, DemoForegroundService.class);
        stopService(serviceIntent);
    }
}