package com.example.bookma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class joinActivity extends Activity
{
    BookMadb db;
    SQLiteDatabase sql;
    EditText edtid, edtpw, edtname, edtphonum;
    Button joinbutton;
    private Context context1;
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        db = new BookMadb(this, "user", null, UTIL.DB_VERSION);
        joinbutton = (Button)findViewById(R.id.btn_endJoin);
        edtid =(EditText)findViewById(R.id.edi_inputid);
        edtpw =(EditText)findViewById(R.id.edi_inputpwd);
        edtname =(EditText)findViewById(R.id.edi_inputname);
        edtphonum =(EditText)findViewById(R.id.edi_inputphonum);
        context1=this;
        joinbutton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                sql=db.getWritableDatabase();
                sql.execSQL("INSERT INTO USER VALUES(null,'"+ edtid.getText().toString()+"','"
                        + edtpw.getText().toString()+"','"
                        + edtname.getText().toString()+"','"
                        + edtphonum.getText().toString()+"');");
                sql.close();
                Toast.makeText(getApplicationContext(),"가입되셧습니다.",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(context1, MainActivity.class);
                startActivity(intent1);

            }
        });
    }

}
