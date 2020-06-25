package com.example.ex08_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    ArrayList<String> dataList = getArrayListData(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        //어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,dataList);
        //drop down 뷰 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //리스트 뷰에 어댑터 연결
        spinner.setAdapter(adapter);
        //리스트 뷰에 아이템 클릭 이벤트 설정
    }
    private ArrayList<String> getArrayListData(int count) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 1; i<= count; i++){
            arrayList.add("스피너 아이템 "+i);
        }
        return arrayList;
    }

}