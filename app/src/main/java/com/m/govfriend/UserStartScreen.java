package com.m.govfriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by User on 01-Mar-18.
 */

public class UserStartScreen extends AppCompatActivity {
    ArrayList<Files> reqfiles=new ArrayList<Files>();
    ArrayList<Files> workdfiles=new ArrayList<Files>();
    ArrayList<Officials> officials_list=new ArrayList<Officials>();

    LinearLayout item=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_start_screen);
        reqfiles.add(new Files("12-March-2015","File to sanction rock sand for house buliding","Rock Sand Sanction","80% Completed"));
        reqfiles.add(new Files("31-October-2016","Motor vehicle license approval","Motor vehicle licence","75% Completed"));
        workdfiles.add(new Files("9-Sep-2017","Application to fitness is a regular check to ensure that vehicle meets requied safety standards.","Fitness checking","Completed"));
        workdfiles.add(new Files("10-Aug-2016","Print out application to check the pollution control certificate","Documents to submit in RTO/SRTO office","Completed"));
        officials_list.add(new Officials("35","I'm a workaholic person","Shameer","8 years",5,1,1,"a"));
        officials_list.add(new Officials("24","Government job is life","Shaji","2 months",5,3,1,"b"));
        officials_list.add(new Officials("28","I'm every effiecent and just","Divakaraan","1 years",5,4,3,"c"));
        officials_list.add(new Officials("21","I always works for the best interest of my clients","Shibin","5 years",5,6,1,"d"));


        item = (LinearLayout) findViewById(R.id.usr_lyt);

        viewSetter(R.id.tab_file);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
               viewSetter(tabId);
            }
        });

    }
    void viewSetter(int tabId) {
        if (tabId == R.id.tab_file) {
            item.removeAllViews();
            View user_file = getLayoutInflater().inflate(R.layout.user_files, null);
            item.addView(user_file);
            SharedPreferences preferences = getSharedPreferences("Details", MODE_PRIVATE);
            ListView listView=(ListView)user_file.findViewById(R.id.workreqlist);
            ListView listView2=(ListView)user_file.findViewById(R.id.workdonelist);
            FileAdapter fileAdapter = new FileAdapter(UserStartScreen.this, reqfiles);
            FileAdapter fileAdapter2 = new FileAdapter(UserStartScreen.this, workdfiles);
            listView.setAdapter(fileAdapter);
            listView2.setAdapter(fileAdapter2);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(UserStartScreen.this,FileDescrib.class);
                    intent.putExtra("position",position);
                    intent.putExtra("aorb","a");
                    startActivity(intent);

                }
            });
            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(UserStartScreen.this,FileDescrib.class);
                    intent.putExtra("position",position);
                    intent.putExtra("aorb","b");
                    startActivity(intent);
                }
            });
        }
        else
        {
            item.removeAllViews();
            View user_officials = getLayoutInflater().inflate(R.layout.user_officials, null);
            item.addView(user_officials);
            SharedPreferences preferences = getSharedPreferences("Details", MODE_PRIVATE);
            final ListView listView = (ListView) user_officials.findViewById(R.id.officials);
            ListView listView1 = (ListView) user_officials.findViewById(R.id.workreqlist);
            OfficialAdapter officialAdapter =new OfficialAdapter(UserStartScreen.this,officials_list);
            listView.setAdapter(officialAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(UserStartScreen.this,OfficialDescrib.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            });
        }
    }
}
