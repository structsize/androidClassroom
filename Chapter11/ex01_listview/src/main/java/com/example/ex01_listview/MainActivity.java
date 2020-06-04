package com.example.ex01_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    //리스트뷰에 표시할 데이터
    //String[] dataArray = getStringArrayForListView(100);
    ArrayList<String> dataList = getStringListForListView(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        //ArrayAdapter 객체 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,dataList);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

        //리스트뷰의 특정항목 클릭시 발생하는 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 화면의 TextView에 선택된 항목의 데이터 출력하기
                textView.setText(dataList.get(position));
            }
        });
    }

    // 리스트뷰에 들어가는 배열 데이터 생성
//    private String[] getStringArrayForListView(int count){
//        String[] strings = new String[count];
//        for(int i = 0; i < count; i++){
//            strings[i] = "배열 데이터" + (i+1);
//        }
//        return strings;
//    }

    // 리스트뷰에 들어가는 리스트 데이터 생성
    private ArrayList<String> getStringListForListView(int count) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < count; i++){
            list.add("리스트 데이터" + (i+1));
        }
        return list;
    }
}
