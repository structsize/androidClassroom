package com.example.ex01_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2;
    Button btnThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.progressBar1);
        pb2 = findViewById(R.id.progressBar2);
        btnThread = findViewById(R.id.btnThread);

        //region 1. 스레드 시작 버튼을 클릭하면 pb1과 pb2의 진행상태를 바꾼다.
//        btnThread.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for(int i = 0; i < 100; i++){
//                    pb1.setProgress(pb1.getProgress()+2);
//                    pb2.setProgress(pb2.getProgress()+1);
//                    SystemClock.sleep(100);
//                }
//            }
//        });
        //endregion

        //region 2. Thread 클래스를 상속한 클래스의 인스턴스를 이용한 처리
        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressThread pt1 = new ProgressThread();
            }
        });
    }
    private class ProgressThread extends Thread{
        ProgressBar pb;
        int increaseValue;

        public ProgressThread(ProgressBar pb, int increaseValue){
            this.pb = pb;
            this.increaseValue = increaseValue;
        }

        @Override
        public void run() {

        }
    }
}
