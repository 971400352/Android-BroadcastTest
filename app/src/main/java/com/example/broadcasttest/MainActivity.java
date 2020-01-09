package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onOne(View view){
        Intent intent = new Intent();
        intent.setAction("dynamic-normal");
        intent.putExtra("flag", "1");
        intent.putExtra("data", "动态注册——普通广播");
        sendBroadcast(intent);
    }

    public void onTwo(View view){
        Intent intent = new Intent();
        intent.setAction("static——normal");
        intent.putExtra("flag", "1");
        intent.putExtra("data", "静态注册——普通广播");
        sendBroadcast(intent);
    }


    //在activity唤醒的时候注册广播
    @Override
    protected void onResume() {
        super.onResume();
        mBroadcastReceiver = new BroadcastReceiver() {
            private static final String TAG = "mBroadcastReceiver";
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getStringExtra("flag").equals("1")){
                    Toast.makeText(getApplication(), intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplication(), "动态注册——系统广播", Toast.LENGTH_SHORT).show();
                    //遍历intent数据
                    Bundle extras = intent.getExtras();
                    Set<String> strings = extras.keySet();
                    for (String keyStr:strings) {
                        if(extras.get(keyStr) instanceof Integer){
                            Log.v(TAG,"intent extras(int) :"+ keyStr + ":" + extras.get(keyStr));
                        }else if(extras.get(keyStr) instanceof String){
                            Log.v(TAG,"intent extras(String) :" + keyStr + ":" + extras.get(keyStr));
                        }else{
                            Log.v(TAG,"intent extras() :" + keyStr + ":" + extras.get(keyStr));
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        //普通广播
        intentFilter.addAction("dynamic-normal");
        //监听耳机插入——系统广播 注意动态注册的系统广播不能监听app没有启动的情况下的系统动作
        intentFilter.addAction("Intent.ACTION_HEADSET_PLUG");
        registerReceiver(mBroadcastReceiver, intentFilter);
    }


    //最好在activity即将不可见的时候注销广播
    @Override
    protected void onPause() {
        super.onPause();
        if(mBroadcastReceiver != null){
            unregisterReceiver(mBroadcastReceiver);
        }
        mBroadcastReceiver = null;
    }
}
