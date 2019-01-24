package com.example.rylan.scheduler;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.rylan.scheduler.Model.SchData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class arrayAdapter extends BaseAdapter {
    Context mcontext;
    ArrayList<SchData>data=new ArrayList<>();
    public arrayAdapter(Context context, ArrayList<SchData> data){
        mcontext=context;
        this.data=data;

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(mcontext).inflate(R.layout.sch_row,parent,false);
        }
        SchData tempData=(SchData) getItem(position);
        TextView topic=(TextView)convertView.findViewById(R.id.topicTxt);
        TextView sTime=(TextView)convertView.findViewById(R.id.satrtTxt);
        TextView eTime=(TextView)convertView.findViewById(R.id.endTxt);
        topic.setText(tempData.getTopic());
        SimpleDateFormat f=new SimpleDateFormat("hh:mm aa");
        sTime.setText(f.format(tempData.getDaa()));
        eTime.setText(f.format(tempData.getDate2()));
        return convertView;
    }

}
