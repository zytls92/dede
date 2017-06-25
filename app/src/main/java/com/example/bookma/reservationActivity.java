package com.example.bookma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by user on 2017-06-09.
 */

public class reservationActivity extends Activity {
    ListView list;
    BookMadb db;
    Cursor cursor;
    SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        list = (ListView) findViewById(R.id.reserList);
        db = new BookMadb(this, "book", null, UTIL.DB_VERSION);
        sql = db.getWritableDatabase();
        cursor = sql.rawQuery("SELECT * FROM BOOK;", null);
        MyCursorAdapter myAdapter = new MyCursorAdapter(this, cursor);
        list.setAdapter(myAdapter);

        list.setOnItemLongClickListener(new ListViewItemLongClickListener());

    }


    int selectedPos = -1;

    private class ListViewItemLongClickListener implements android.widget.AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            selectedPos = position;
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
            alertDlg.setTitle(R.string.alert_title_question);

            alertDlg.setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            return false;

        }
    }
}