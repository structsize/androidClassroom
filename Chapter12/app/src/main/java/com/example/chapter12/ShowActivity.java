package com.example.chapter12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        listView = findViewById(R.id.listView);
        String[] keys = {"title", "contents"};
        int[] ids = {android.R.id.text1,android.R.id.text2};

        //데이터베이스에서 데이터 불러오기
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT title, contents FROM test_table",null);

        //cursor에 담긴 데이터 꺼내오기
        while(cursor.moveToNext()){
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(keys[0], cursor.getString(0));
            hashMap.put(keys[1], cursor.getString(1));
            arrayList.add(hashMap);
        }
        db.close();

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, android.R.layout.simple_list_item_2, keys, ids);
        listView.setAdapter(adapter);
    }
}