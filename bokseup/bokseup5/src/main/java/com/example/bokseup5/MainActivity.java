package com.example.bokseup5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater(); // xml 코드를 객체화하기 위한

        switch (v.getId()){
            case R.id.textView:
                menu.setHeaderTitle("TextView의 컨텍스트 메뉴");
                menuInflater.inflate(R.menu.menu, menu);
                break;
        }

    }


    // 컨텍스트 메뉴 아이템 선택에 따른 이벤트 처리

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.text1:
                textView.setText("메뉴1 선택함");
                break;
            case R.id.text2:
                textView.setText("메뉴2 선택.");
                break;
            case R.id.submenutext1:
                textView.setText("서브 메뉴 1 선택");
                break;
            case R.id.submenutext2:
                textView.setText("서브 메뉴 2 선택");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
