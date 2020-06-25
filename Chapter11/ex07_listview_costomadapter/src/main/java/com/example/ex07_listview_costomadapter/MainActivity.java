package com.example.ex07_listview_costomadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button btnAdd;

    ArrayList<ItemV0> dataList = new ArrayList<ItemV0>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        // dataList에 초기 데이터 추가
        dataList.add(new ItemV0("doc", "Document 1", "Sample Data"));
        dataList.add(new ItemV0("img", "Image 1", "Sample Data"));
        dataList.add(new ItemV0("file", "File 1", "Sample Data"));

        // CustomAdapter 생성
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        // 리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                final View myView = inflater.inflate(R.layout.alert_dialog_view,null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("리스트 아이템 추가")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(true)
                        .setView(myView)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String type= null, title, content;

                                int checkedId = ((RadioGroup)myView.findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
                                switch (checkedId){
                                    case R.id.rbDoc:
                                        type = "doc";
                                        break;
                                    case R.id.rbImg:
                                        type = "img";
                                        break;
                                    case R.id.rbFile:
                                        type = "file";
                                        break;
                                }
                                title = ((EditText)myView.findViewById(R.id.editTextTitle)).getText().toString();
                                content = ((EditText)myView.findViewById(R.id.editTextContent)).getText().toString();

                                dataList.add(new ItemV0(type,title,content));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position).getTitleStr());
            }
        });
        
    }
}