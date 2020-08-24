package com.example.ex01_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    //서비스가 가동될때 호출되는 메서드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "서비스 시작");
        Toast.makeText(this,"서비스 시작", Toast.LENGTH_LONG).show();

        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        return super.onStartCommand(intent, flags, startId);
    }


    //서비스가 중지될 때 호출되는 메서드
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "서비스 중지");
        Toast.makeText(this,"서비스 종료", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class ThreadClass extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                SystemClock.sleep(1000);
                long time = System.currentTimeMillis();
                Log.d("test", "Service Running...." + time);
            }
        }
    }
}
