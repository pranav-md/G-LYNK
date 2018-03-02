package com.m.govfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 02-Mar-18.
 */

public class FileDescrib extends AppCompatActivity {
    ArrayList<Files> reqfiles=new ArrayList<Files>();
    ArrayList<Files> workdfiles=new ArrayList<Files>();
    ArrayList<Officials> officials_list=new ArrayList<Officials>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.file_desc);
        Bundle extras = getIntent().getExtras();
        int position=extras.getInt("position");
        TextView tvname=(TextView)findViewById(R.id.filename);
        //TextView tvdescrib=(TextView)findViewById(R.id.descri);
        TextView tvstatus=(TextView)findViewById(R.id.status);
        TextView tvdate=(TextView)findViewById(R.id.date);
        String aorb=extras.getString("aorb");
        ListView listView=(ListView)findViewById(R.id.emp_list);
        officials_list.add(new Officials("35","I'm a workaholic person","Shameer","8 years",5,1,1,"a"));
        officials_list.add(new Officials("24","Government job is life","Shaji","2 months",5,3,1,"b"));
        officials_list.add(new Officials("28","I'm every effiecent and just","Divakaraan","1 years",5,4,3,"c"));
        officials_list.add(new Officials("21","I always works for the best interest of my clients","Shibin","5 years",5,6,1,"d"));

        reqfiles.add(new Files("12-March-2015","File to sanction rock sand for house buliding","Rock Sand Sanction","80% Completed"));
        reqfiles.add(new Files("31-October-2016","Motor vehicle license approval","Motor vehicle licence","75% Completed"));
        workdfiles.add(new Files("9-Sep-2017","Application to fitness is a regular check to ensure that vehicle meets requied safety standards.","Fitness checking","Completed"));
        workdfiles.add(new Files("10-Aug-2016","Print out application to check the pollution control certificate","Documents to submit in RTO/SRTO office","Completed"));
        if(aorb.equals("a"))
        {
            tvname.setText(reqfiles.get(position).file_name);
            tvstatus.setText(reqfiles.get(position).file_status);
            tvdate.setText(reqfiles.get(position).file_date);
            OfficialAdapter officialAdapter=new OfficialAdapter(FileDescrib.this,officials_list);
            listView.setAdapter(officialAdapter);
        }
        else
        {
            tvname.setText(workdfiles.get(position).file_name);
            tvstatus.setText(workdfiles.get(position).file_status);
            tvdate.setText(workdfiles.get(position).file_date);
            OfficialAdapter officialAdapter=new OfficialAdapter(FileDescrib.this,officials_list);
            listView.setAdapter(officialAdapter);

        }
    }
}
