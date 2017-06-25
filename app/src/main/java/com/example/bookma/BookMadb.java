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
        db.execSQL( "Insert into book values (null, \"파이썬기초\", \"조민수\", \"가나\", 5) ");
        db.execSQL( "Insert into book values (null, \"색체심리학\", \"조명진\", \"지학사\", 1) ");
        db.execSQL( "Insert into book values (null, \"c프로그래밍\", \"김정우\", \"교학사\", 3) ");
        db.execSQL( "Insert into book values (null, \"자료구조\", \"김현석\", \"지학사\", 2) ");
        db.execSQL( "Insert into book values (null, \"디지털논리\", \"이형조\", \"new\", 3) ");
        db.execSQL( "Insert into book values (null, \"자바바이블\", \"김철기\", \"항공사\", 2) ");
    }


}
