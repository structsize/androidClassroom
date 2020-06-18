package com.example.class615;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnAdd, btnNotify, btnDelete;
    ListView listView;

    int setNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnNotify = findViewById(R.id.btnNotify);
        btnDelete = findViewById(R.id.btnDelete);
        textView = findViewById(R.id.textView);

        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1");
        dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3");
        dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,dataSet);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataSet.get(position));
                setNum = position;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("리스트 데이터" + (dataSet.size()+1));
                adapter.notifyDataSetChanged();
            }
        });
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("리스트아이템 수정")
                        .setMessage(dataSet.get(setNum))
                        .setIcon(R.mipmap.ic_launcher_round);
                final EditText et = new EditText(MainActivity.this);
                dlg.setView(et);
                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataSet.add(setNum, et.getText().toString());
                        dataSet.remove(setNum+1);
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(setNum);
                adapter.notifyDataSetChanged();
            }
        });


    }
}
