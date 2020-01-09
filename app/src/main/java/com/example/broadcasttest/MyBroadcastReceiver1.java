package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * author ：ykq
 * date : 2020/1/9 11:08
 * package：com.example.broadcasttest
 * description :
 */
public class MyBroadcastReceiver1 extends BroadcastReceiver {
    private static final String TAG = MyBroadcastReceiver1.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
//        if(intent.getAction().equals("Intent.ACTION_AIRPLANE_MODE_CHANGED")) {
//            Toast.makeText(context, "onReceive: 静态注册——系统广播", Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(context, "onReceive: 静态注册——系统广播", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: 静态注册——系统广播");
    }
}
