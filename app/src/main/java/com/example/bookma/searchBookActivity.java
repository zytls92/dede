package com.example.bookma;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.onClick;

/**
 * Created by user on 2017-06-09.
 */

public class searchBookActivity extends Activity {
    ListView list;
    BookMadb db;
    SQLiteDatabase sql;
    Cursor cursor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);
            list = (ListView)findViewById(R.id.lv_bookinfo);
            db = new BookMadb(this, "book", null, UTIL.DB_VERSION);
            sql=db.getWritableDatabase();
            cursor = sql.rawQuery("SELECT * FROM BOOK;", null);
            MyCursorAdapter myAdapter = new MyCursorAdapter(this,cursor);

            list.setAdapter(myAdapter);



        }

}
