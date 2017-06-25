package com.example.bookma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class bookmainActivity extends Activity
{
    private BookMadb db,db1;
    private Context context;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmain);
        context = this;

        db = new BookMadb(this, "book", null, UTIL.DB_VERSION);
        db1 = new BookMadb(this, "user", null, UTIL.DB_VERSION);
        Log.e("!!!" ,"db create");

        Button btnSearch = (Button) findViewById(R.id.btn_search);
        Button btnReservation = (Button) findViewById(R.id.btn_reservation);
        Button btnRenew = (Button) findViewById(R.id.btn_renew);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.btn_search:
                        Intent intent=new Intent(context,searchBookActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_reservation:
                        Intent intent1=new Intent(context,reservationActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.btn_renew:
                        Intent intent2=new Intent(context,renewActivity.class);
                        startActivity(intent2);
                        break;

                }
            }
        };
        btnSearch.setOnClickListener(listener);
        btnReservation.setOnClickListener(listener);
        btnRenew.setOnClickListener(listener);

        getBookResult("");
        getUserResult();
    }

    public String getBookResult(String str) {
        SQLiteDatabase dbq = db.getReadableDatabase();
        String result = "";

        String query = "SELECT * FROM book";
        if ( !str.equals("") ) {
            query = query + " WHERE title like \"%"+str+"%\" ";
        }
        Log.e("!!!", "query = "+query);
        Cursor cursor = dbq.rawQuery(query, null);
        Log.e("!!!", "cursor = "+cursor.getCount());
        while (cursor.moveToNext()) {
            result += " 책 이름 : " +cursor.getString(cursor.getColumnIndex("title"))
                    + ", 지은이 : "
                    + cursor.getString(cursor.getColumnIndex("author"))
                    + " , 출판사 : "
                    + cursor.getString(cursor.getColumnIndex("publisher"))
                    + ", 수량 : "
                    + cursor.getInt(cursor.getColumnIndex("count"))
                    + "\n";
            Log.e("!!!", "[BOOK] "+result);
        }

        return result;
    }
    public String getUserResult() {
        SQLiteDatabase dbq = db1.getReadableDatabase();
        String result = "";

        Cursor cursor = dbq.rawQuery("SELECT * FROM user", null);
        while (cursor.moveToNext()) {
            result += " 아이디 : " +cursor.getString(cursor.getColumnIndex("id"))
                    + ", 비밀번호 : "
                    + cursor.getString(cursor.getColumnIndex("pwd"))
                    + " , 이름 : "
                    + cursor.getString(cursor.getColumnIndex("name"))
                    + ", 전화번호 : "
                    + cursor.getString(cursor.getColumnIndex("phone"))
                    + "\n";
            Log.e("!!!", "[USER] "+result);
        }

        return result;
    }


}
