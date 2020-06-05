package com.example.ex05_listview_simpleadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    //리스트뷰에 표시할 데이터
    int[] imgResArray = {R.drawable.kakao01,R.drawable.kakao02,R.drawable.kakao03,R.drawable.kakao04,R.drawable.kakao05,R.drawable.kakao06,R.drawable.kakao07,R.drawable.kakao08,R.drawable.kakao09};
    ArrayList<String> titleData = getStringListForListView("title", 9);
    ArrayList<String> contentsData = getStringListForListView("contents", 9);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        //Simple Adapter 에 연결한 리스트 생성
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

        for(int i = 0; i < titleData.size(); i++){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("img",imgResArray[i]);
            hashMap.put("title", titleData.get(i));
            hashMap.put("contents",contentsData.get(i));

            arrayList.add(hashMap);
        }



        //Simple Adapter 객체 생성
        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.row, new String[]{"img","title","contents"},new int[]{R.id.imageView,R.id.textViewTitle,R.id.textViewContents});


        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

        //리스트뷰의 특정항목 클릭시 발생하는 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 화면의 TextView에 선택된 항목의 데이터 출력하기
                textView.setText(titleData.get(position)+", " +contentsData.get(position) );
            }
        });
    }

    // 리스트뷰에 들어가는 리스트 데이터 생성
    private ArrayList<String> getStringListForListView(String str, int count) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < count; i++){
            list.add(str + (i+1));
        }
        return list;
    }
}
