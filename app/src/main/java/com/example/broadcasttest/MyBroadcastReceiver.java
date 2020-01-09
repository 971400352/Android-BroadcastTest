package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * author ：ykq
 * date : 2020/1/9 10:14
 * package：com.example.broadcasttest
 * description :
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = MyBroadcastReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("static——normal")){
            Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
        }
    }
}
