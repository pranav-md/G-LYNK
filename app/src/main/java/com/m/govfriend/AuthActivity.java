package com.m.govfriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by User on 01-Mar-18.
 */

public class AuthActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.auth_layout);
            TextView tv=findViewById(R.id.imemployee);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.auth_employee);

                    final EditText emp_name=(EditText)findViewById(R.id.name);
                    final EditText emp_pw=(EditText)findViewById(R.id.pw2);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference();
                    Button done=(Button) findViewById(R.id.emp_done);
                    myRef.child("Officials").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot!=null)
                            {
                                int i=0;
                                for(DataSnapshot ds:dataSnapshot.getChildren())
                                {
                                    ++i;
                                    if (emp_name.getText().toString().equals(dataSnapshot.child("Name").getValue().toString())) {
                                        Toast.makeText(AuthActivity.this, "Sign in successful", Toast.LENGTH_LONG).show();
                                        SharedPreferences preferences = getSharedPreferences("Details", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString("emp_num", i + "");
                                        editor.putString("Mode", "emp");
                                        editor.commit();

                                        break;
                                    }
                                }
                                if(dataSnapshot.getChildrenCount()==i)
                                {
                                    Toast.makeText(AuthActivity.this,"Wrong password or Aadhar num",Toast.LENGTH_LONG).show();
                                }

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            });
            final EditText ad_num=(EditText)findViewById(R.id.ppl_name);
            final EditText pw=(EditText)findViewById(R.id.ppl_pw);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference();
            Button done=(Button) findViewById(R.id.done);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myRef.child("People").child("332166489975").child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot!=null)
                            {
                               // if(pw.getText().toString().equals(dataSnapshot.getValue().toString()))
                                //{
                                    Toast.makeText(AuthActivity.this,"Sign in successful",Toast.LENGTH_LONG).show();
                                    SharedPreferences preferences=getSharedPreferences("Details",MODE_PRIVATE);
                                    SharedPreferences.Editor editor=preferences.edit();
                                    editor.putString("Aadhar no",ad_num.getText().toString());
                                    editor.putString("Mode", "ppl");
                                    Intent intent=new Intent(AuthActivity.this,UserStartScreen.class);
                                    startActivity(intent);
                                    finish();
                                    editor.commit();
                              //  }
                             //   else
                             //   {
                             //       Toast.makeText(AuthActivity.this,"Wrong password or Aadhar num",Toast.LENGTH_LONG).show();
                            //    }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            });



        }

}
