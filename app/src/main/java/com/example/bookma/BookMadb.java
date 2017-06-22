package com.example.bookma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2017-06-09.
 */

public class BookMadb extends SQLiteOpenHelper {
    public BookMadb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
        initTable(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists book; ");
        db.execSQL(" DROP TABLE IF EXISTS reservation; ");
        db.execSQL(" DROP TABLE IF EXISTS user; ");

        createTable(db);
        initTable(db);
    }


    private void createTable(SQLiteDatabase db) {
        db.execSQL(" create table book ( _id integer primary key autoincrement, title text, author text, publisher text, count integer ); ");
        db.execSQL(" create table reservation ( _id integer primary key autoincrement, id text, title text, state_date text, end_date text, flag integer); ");
        db.execSQL(" create table user ( _id integer primary key autoincrement, id text, pwd text, name text, phone text); ");
    }

    private void initTable(SQLiteDatabase db) {

        //db.execSQL( "Insert into reservation values (null, \"12345\", \"만화책\", \"2017-06-09 15:00:00\", \"2017-06-11 15:00:00\", 0) ");
        db.execSQL( "Insert into book values (null, \"책1\", \"뺑덕\", \"가나출판사\", 5) ");
        db.execSQL( "Insert into book values (null, \"책2\", \"심청\", \"지학사\", 1) ");
        db.execSQL( "Insert into book values (null, \"책3\", \"변사또\", \"가출판사\", 0) ");
        db.execSQL( "Insert into book values (null, \"책4\", \"이몽룡\", \"지학사\", 2) ");
        db.execSQL( "Insert into book values (null, \"책5\", \"춘향\", \"뉴출판사\", 3) ");
        db.execSQL( "Insert into book values (null, \"책6\", \"홍길동\", \"동아출판사\", 2) ");
        db.execSQL( "Insert into user values (null, \"11111\", \"1111\", \"민수\", \"01000000001\") ");
        db.execSQL( "Insert into user values (null, \"22222\", \"1111\", \"정우\", \"01000000002\") ");
        db.execSQL( "Insert into user values (null, \"33333\", \"1111\", \"현석\", \"01000000003\") ");
        db.execSQL( "Insert into user values (null, \"44444\", \"1111\", \"형조\", \"01000000004\") ");
        db.execSQL( "Insert into user values (null, \"55555\", \"1111\", \"정호\", \"01000000005\") ");
        db.execSQL( "Insert into user values (null, \"66666\", \"1111\", \"성환\", \"01000000006\") ");
    }

}
