package com.example.rylan.scheduler;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rylan.scheduler.Model.SchData;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class Schedular extends AppCompatActivity {
    private EditText topic,time2,time;
    private TextView date;
    Realm realm;
    private String date1,date2;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedular);
        topic= findViewById(R.id.tpoicTxt);
        time2=findViewById(R.id.time2);
        date=findViewById(R.id.datepick);

        time=findViewById(R.id.timetdxt);
        realm = Realm.getDefaultInstance();
        /*realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();*/


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(Schedular.this,
                        R.style.Theme_AppCompat_Dialog_MinWidth,dateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(232,0,8)));
                dialog.show();
            }
        });
        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date1=year+"/0"+month+"/"+dayOfMonth;
                date2=year+"/0"+month+"/"+dayOfMonth;
                date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            }
        };

        Button button= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveData();

            }
        });
    }
    private void saveData(){
        date2+=" "+time2.getText();
        date1+=" "+time.getText();


        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                SchData schData=bgRealm.createObject(SchData.class);
                schData.setTopic(topic.getText().toString().trim());
                SimpleDateFormat f=new SimpleDateFormat("yyyy/mm/dd hh:mm aa");
                ParsePosition pp=new ParsePosition(0);
                schData.setDaa(f.parse(date1,pp));
                ParsePosition pp2=new ParsePosition(0);
                schData.setDate2(f.parse(date2,pp2));

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
