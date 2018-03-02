package com.m.govfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 02-Mar-18.
 */

public class OfficialDescrib extends AppCompatActivity {
    ArrayList<Officials> officials_list=new ArrayList<Officials>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] reaction={"good","great","okay","bad","terrible"};

        setContentView(R.layout.official_profile);
        Bundle extras = getIntent().getExtras();
        int position=extras.getInt("position");
        Button btn1=(Button)findViewById(R.id.rate_me);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setContentView(R.layout.official_rating);
            }
        });
        Button btn2=(Button)findViewById(R.id.complaint_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.complaint);
            }
        });

    }
}
