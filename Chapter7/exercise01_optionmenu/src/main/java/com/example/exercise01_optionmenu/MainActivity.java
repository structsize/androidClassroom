package com.example.exercise01_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.option_menu,menu);

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "Java코드에서 추가한 메뉴");
        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "Java코드에서 추가한 메뉴");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                textView.setText("메뉴1 선택됨");
                break;
            case R.id.item2:
                textView.setText("메뉴2 선택됨");
                break;
            case R.id.subitem1:
                textView.setText("서브메뉴1 선택됨");
                break;
            case R.id.subitem2:
                textView.setText("서브메뉴2 선택됨");
                break;
            case Menu.FIRST:
                textView.setText("Java코드에서 추가한 아이템1 선택");
                break;
            case Menu.FIRST + 1:
                textView.setText("Java코드에서 추가한 아이템2 선택");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
