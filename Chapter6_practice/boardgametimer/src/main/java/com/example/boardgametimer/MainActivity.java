package com.example.boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //region 변수선언
    EditText editTextEnteredSeconds;
    Button btnPauseRestart, btnTimerSwitch, btnReset;
    TextView textViewCopyright;
    CountDownTimer countDownTimer;

    long fullTime, halfTime;
    boolean isPaused = false;

    TextToSpeech textToSpeech;

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

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }

            }
        });
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
                    textToSpeech.speak("restart",TextToSpeech.QUEUE_FLUSH,null);
                    countDownTimer = countDownTimer(Long.parseLong(btnTimerSwitch.getText().toString()));
                    countDownTimer.start();
                    btnPauseRestart.setText(R.string.pause);
                    isPaused = false;
                }else {
                    textToSpeech.speak("pause",TextToSpeech.QUEUE_FLUSH,null);
                    countDownTimer.cancel();
                    btnPauseRestart.setText(R.string.restart);
                    isPaused = true;
                }
            }
        });

        btnReset.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {

                if(editTextEnteredSeconds.hasFocus()){
                    editTextEnteredSeconds.clearFocus();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextEnteredSeconds.getWindowToken(),0);
                }

                resetTimer();
                cancelTimer();

                String msg = String.format("Reset to %d seconds",fullTime);
                textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null);

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
        try {
            fullTime = Long.parseLong(editTextEnteredSeconds.getText().toString());
            halfTime = Math.round(fullTime / 2);
        } catch (Exception e){
            Toast.makeText(this,"제대로 입력해주세요",Toast.LENGTH_SHORT).show();
        }

        changeTextSize(fullTime);

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
                changeTextSize(currentTime);

                if(currentTime == halfTime){
                    MediaPlayer.create(getApplicationContext(),R.raw.warning_sound).start();
                }
                if(currentTime <=10){
                    btnTimerSwitch.setTextColor(Color.RED);
                    textToSpeech.speak(String.valueOf(currentTime),TextToSpeech.QUEUE_FLUSH,null);
                }
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
    private void changeTextSize(long seconds){
        if(seconds>= 100){
            btnTimerSwitch.setTextSize(200);
        }else if(seconds>=10){
            btnTimerSwitch.setTextSize(300);
        } else {
            btnTimerSwitch.setTextSize(400);
        }
    }
}
