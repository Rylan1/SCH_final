package com.example.rylan.scheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rylan.scheduler.Model.SchData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainSchedule extends AppCompatActivity {
    private Date startDate,endDate;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule);
        Button sch= findViewById(R.id.button4);
        sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSchedular();
            }
        });
        Button schView=findViewById(R.id.button1);
        schView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openView();
            }
        });
        realm=Realm.getDefaultInstance();
        getData();


    }

    public void openSchedular(){
        Intent intent=new Intent(this,Schedular.class);
        startActivity(intent);
    }
    public void openView(){
        Intent intent=new Intent(this,DisplaySchedule.class);
        startActivity(intent);
    }
    public void getData(){
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        RealmResults<SchData> results=realm.where(SchData.class).findAll();
        SimpleDateFormat f=new SimpleDateFormat("hh:mm aa");
        for (SchData result:results){
            try {
                if(date.before(result.getDate2())&&date.after(result.getDaa())){
                    TextView topicView=findViewById(R.id.textView2);
                    TextView starttime=findViewById(R.id.textView11);
                    TextView endtime=findViewById(R.id.textView13);
                    topicView.setText(result.getTopic());
                    starttime.setText("Start Time:"+f.format(result.getDaa()));
                    endtime.setText(" End Time:"+f.format(result.getDate2()));
                }
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }

        }
    }
    protected void onDestroy() {
        super.onDestroy();
        realm.close();

    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


}
