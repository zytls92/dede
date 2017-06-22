package com.example.bookma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class joinActivity extends Activity
{
    private Context context1;
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        context1=this;
        Button btnCheckOverlap = (Button) findViewById(R.id.btn_checkOverlap);
        Button btnEndJoin = (Button) findViewById(R.id.btn_endJoin);
    }
    View.OnClickListener listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn_checkOverlap:

                    break;
                case R.id.btn_endJoin:
                    Intent intent1=new Intent(context1,MainActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };

}
