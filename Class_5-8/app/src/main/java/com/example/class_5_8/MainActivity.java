package com.example.class_5_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    TextView myName, myText;
    LinearLayout myLinearLayout, friendLinearLayout1, friendLinearLayout2;
    View dialogView;
    EditText inputArea;
    int selectFriends = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLinearLayout = findViewById(R.id.myLayout);
        friendLinearLayout1 = findViewById(R.id.friendLayout1);
        friendLinearLayout2 = findViewById(R.id.friendLayout2);
        myName = findViewById(R.id.myName);
        myText = findViewById(R.id.myText);
        registerForContextMenu(myLinearLayout);
        registerForContextMenu(friendLinearLayout1);
        registerForContextMenu(friendLinearLayout2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.optionMenu_deleteAllFriends:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage("친구를 모두 삭제 하시겠습니까?");
                dlg.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        friendLinearLayout1.setVisibility(View.INVISIBLE);
                        friendLinearLayout2.setVisibility(View.INVISIBLE);
                    }
                });
                dlg.setPositiveButton("아니오",null);
                return true;
            case R.id.optionMenu_restoreAllFriends:
                friendLinearLayout1.setVisibility(View.VISIBLE);
                friendLinearLayout2.setVisibility(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == myLinearLayout){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.mycontext_menu,menu);

        } else if(v == friendLinearLayout1){
            selectFriends = 1;
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.friendcontext_menu,menu);

        } else if (v == friendLinearLayout2){
            selectFriends = 2;
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.friendcontext_menu,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.myContextMenu_changeName:
                dialogView = View.inflate(MainActivity.this, R.layout.input_dialog,null);
                AlertDialog.Builder changeNameDlg = new AlertDialog.Builder(MainActivity.this);
                changeNameDlg.setTitle("이름을 입력하세요");
                changeNameDlg.setView(dialogView);
                changeNameDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputArea = dialogView.findViewById(R.id.imputArea);
                        myName = findViewById(R.id.myName);
                        myName.setText(inputArea.getText().toString());
                    }
                });
                changeNameDlg.setNegativeButton("취소", null);
                return true;
            case R.id.myContextMenu_changeSangme:
                dialogView = View.inflate(MainActivity.this, R.layout.input_dialog,null);
                AlertDialog.Builder changeSangmeDlg = new AlertDialog.Builder(MainActivity.this);
                changeSangmeDlg.setTitle("상태메세지를 입력하세요");
                changeSangmeDlg.setView(dialogView);
                changeSangmeDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputArea = dialogView.findViewById(R.id.imputArea);
                        myText = findViewById(R.id.myText);
                        myName.setText(inputArea.getText().toString());
                    }
                });
                changeSangmeDlg.setNegativeButton("취소", null);
                return true;
            case R.id.friendsContextMenu_delFriend:
                if(selectFriends == 1)
                    friendLinearLayout1.setVisibility(GONE);
                if(selectFriends == 2)
                    friendLinearLayout2.setVisibility(GONE);
                return true;
            default:
                return super.onContextItemSelected(item);


        }
    }
}
