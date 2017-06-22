package com.example.bookma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookMadb db = new BookMadb(this, "book", null, UTIL.DB_VERSION);

        EditText editId = (EditText) findViewById(R.id.edit_id);
        EditText editPw = (EditText) findViewById(R.id.edit_pw);
        Button btnLogin = (Button) findViewById(R.id.btn_log);
        Button btnJoin = (Button) findViewById(R.id.btn_join);
    }
        public void onClick(View view) {
        Intent intent = new Intent(this, joinActivity.class);
        startActivity(intent);
        }
    public void onClick1(View view) {
        Intent intent = new Intent(this, bookmainActivity.class);
        startActivity(intent);
    }



    }

