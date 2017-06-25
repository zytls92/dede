package com.example.bookma;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sql;
    BookMadb db_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookMadb db = new BookMadb(this, "book", null, UTIL.DB_VERSION);
        db_user=new BookMadb(this, "user", null, UTIL.DB_VERSION);

        final EditText editId = (EditText) findViewById(R.id.edit_id);
        final EditText editPw = (EditText) findViewById(R.id.edit_pw);
        Button btnLogin = (Button) findViewById(R.id.btn_log);
        Button btnJoin = (Button) findViewById(R.id.btn_join);
        Button btnMana=(Button) findViewById(R.id.btn_manage);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sql = db_user.getReadableDatabase();
                String db_id = null;
                String db_pwd = null;
                String id = editId.getText().toString();
                String pwd = editPw.getText().toString();
                Cursor cursor = sql.rawQuery("SELECT * FROM USER;", null);
                while (cursor.moveToNext()) {
                    db_id = cursor.getString(1);
                    db_pwd = cursor.getString(2);
                }
                if (id.equals(db_id) && pwd.equals(db_pwd)) {
                    Intent intent = new Intent(getApplicationContext(), bookmainActivity.class);
                    startActivity(intent);
                } else if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "id와 패스워드를입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "id또는 패스워드가 틀렸습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnMana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sql=db_user.getReadableDatabase();
                String db_id = null;
                String db_pwd = null;
                String id = editId.getText().toString();
                String pwd = editPw.getText().toString();
                Cursor cursor = sql.rawQuery("SELECT * FROM USER;", null);
                while (cursor.moveToNext()) {
                    db_id = cursor.getString(1);
                    db_pwd = cursor.getString(2);
                }
                if (id.equals("master") && pwd.equals("0000")) {
                    Intent intent = new Intent(getApplicationContext(), ManagerPageActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "당신은 관리자가 아닙니다", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

        public void onClick(View view) {
        Intent intent = new Intent(this, joinActivity.class);
        startActivity(intent);
        }
    }

