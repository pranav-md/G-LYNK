package com.m.govfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hsalf.smilerating.SmileRating;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 02-Mar-18.
 */

public class OfficialRating extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.official_rating);
        final CircleImageView c_dp=(CircleImageView)findViewById(R.id.dp);
        TextView textView=(TextView)findViewById(R.id.textView7);
        SmileRating pleasant=findViewById(R.id.pleasant);
        SmileRating honest=findViewById(R.id.honesty);
        SmileRating service=findViewById(R.id.service);
        Button done_rating=(Button)findViewById(R.id.done_rating);
        done_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

    }
}
