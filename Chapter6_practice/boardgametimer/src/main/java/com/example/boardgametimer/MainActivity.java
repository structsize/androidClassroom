package com.example.boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //region 변수선언
    EditText editTextEnteredSeconds;
    Button btnPauseRestart, btnTimerSwitch, btnReset;
    TextView textViewCopyright;
    CountDownTimer countDownTimer;

    long fullTime, halfTime;
    boolean isPaused = false;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region 변수 연결
        editTextEnteredSeconds = findViewById(R.id.editTextEnteredSeconds);
        btnPauseRestart = findViewById(R.id.btnPauseRestart);
        btnReset = findViewById(R.id.btnReset);
        btnTimerSwitch = findViewById(R.id.btnTimerSwitch);
        textViewCopyright = findViewById(R.id.textViewCopyright);
        //endregion

        btnTimerSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer.create(getApplicationContext(), R.raw.bell_sound).start();
                cancelTimer();
                resetTimer();

                countDownTimer = countDownTimer(fullTime);
                countDownTimer.start();

            }
        });

        btnPauseRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPaused){
                    countDownTimer = countDownTimer(Long.parseLong(btnTimerSwitch.getText().toString()));
                    countDownTimer.start();
                    btnPauseRestart.setText(R.string.pause);
                    isPaused = false;
                }else {
                    countDownTimer.cancel();
                    btnPauseRestart.setText(R.string.restart);
                    isPaused = true;
                }
            }
        });

        btnReset.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                resetTimer();
                cancelTimer();

                btnTimerSwitch.setEnabled(true);
                return true;
            }
        });




    }

    private void cancelTimer(){
        if(countDownTimer != null)
            countDownTimer.cancel();
    }
    private void resetTimer(){
        fullTime = Long.parseLong(editTextEnteredSeconds.getText().toString());
        halfTime = Math.round(fullTime/2);

        btnTimerSwitch.setBackgroundColor(Color.YELLOW);
        btnTimerSwitch.setTextColor(Color.BLACK);
        btnTimerSwitch.setEnabled(true);
        btnTimerSwitch.setText(String.valueOf(fullTime));

    }
    private CountDownTimer countDownTimer(long t ){
        return new CountDownTimer(t*1000 + 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long currentTime = millisUntilFinished/1000;
                btnTimerSwitch.setText(String.valueOf(currentTime));
            }

            @Override
            public void onFinish() {
                btnTimerSwitch.setBackgroundColor(Color.DKGRAY);
                btnTimerSwitch.setTextColor(Color.GRAY);
                MediaPlayer.create(getApplicationContext(), R.raw.gameover_sound).start();
                btnTimerSwitch.setEnabled(false);
            }
        };
    }
}
