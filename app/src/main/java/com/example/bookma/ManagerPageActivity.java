package com.example.bookma;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 2017-06-22.
 */

public class ManagerPageActivity extends Activity {

    private Context context;
    BookMadb db;
    EditText edittext1, edittext2, edittext3,edittext4;
    TextView bookname, writer, publisher,suryang;
    Button btn1,btn2,btn3;
    SQLiteDatabase sql;
    ListView list;
    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mana);
        context=this;
        db = new BookMadb(this, "book", null, UTIL.DB_VERSION);

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        bookname = (TextView) findViewById(R.id.bookname);
        writer = (TextView) findViewById(R.id.writer);
        publisher = (TextView) findViewById(R.id.publisher);
        suryang=(TextView)findViewById(R.id.suryang);
        edittext1=(EditText) findViewById(R.id.editText1);
        edittext2=(EditText) findViewById(R.id.editText2);
        edittext3=(EditText) findViewById(R.id.editText3);
        edittext4=(EditText) findViewById(R.id.editText4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sql = db.getWritableDatabase();
                db.onUpgrade(sql, 1, 2);
                sql.close();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = (ListView)findViewById(R.id.listManage);
                sql=db.getWritableDatabase();
                cursor = sql.rawQuery("SELECT * FROM BOOK;", null);
                MyCursorAdapter myAdapter = new MyCursorAdapter(getApplicationContext(),cursor);

                list.setAdapter(myAdapter);
            }

        });
        btn3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                sql=db.getWritableDatabase();
                sql.execSQL("INSERT INTO book VALUES(null,'"+ edittext1.getText().toString()+"','"
                        + edittext2.getText().toString()+"','"
                        + edittext3.getText().toString()+"','"
                        + edittext4.getText().toString()+"');");
                sql.close();
                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();

            }
        });

    }
}