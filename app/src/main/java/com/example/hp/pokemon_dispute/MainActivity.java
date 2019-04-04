package com.example.hp.pokemon_dispute;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    String vicno;
    Button play,toss,exchange;
    TextView t1,t2;
    String player1="Ash";
    int tc=0,eno=0,c1,c2;
    ColorStateList oc;
    EditText e;
    Spinner s1,s2;
    ArrayAdapter<CharSequence> a1,a2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        toss=findViewById(R.id.toss) ;

        s1=findViewById(R.id.spinner1);
        s2=findViewById(R.id.spinner2);

        a1= ArrayAdapter.createFromResource(this,
                R.array.colour, android.R.layout.simple_spinner_item);
        a2= ArrayAdapter.createFromResource(this,
                R.array.colour, android.R.layout.simple_spinner_item);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);
        s2.setAdapter(a2);
        s1.setEnabled(false);
        s2.setEnabled(false);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 1:
                            t1.setTextColor(Color.BLUE);
                            break;
                        case 2:
                            t1.setTextColor(Color.GREEN);
                            break;
                            case 3 :
                            t1.setTextColor(Color.RED);
                            break;
                        case 4:
                            t1.setTextColor(Color.YELLOW);
                            break;



                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        t2.setTextColor(Color.BLUE);
                        break;
                    case 2:
                        t2.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        t2.setTextColor(Color.RED);
                        break;
                    case 4:
                        t2.setTextColor(Color.YELLOW);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tc==1) {
                    e=findViewById(R.id.vn);
                    if(!e.getText().toString().equalsIgnoreCase(""))
                    vicno=e.getText().toString();
                    else {
                        Toast.makeText(MainActivity.this,"NO OF ROUND :-4",Toast.LENGTH_LONG).show();
                        vicno=String.valueOf(4);
                    }

                    Intent in = new Intent(MainActivity.this, MainActivity2.class);
                    Log.e("ak47", "intent created");
                    in.putExtra("name", player1);
                    in.putExtra("vicnum",vicno);
                    in.putExtra("p1col",String.valueOf(t1.getCurrentTextColor()));
                    in.putExtra("p2col",String.valueOf(t2.getCurrentTextColor()));
                    Log.e("ak47", "messege send");
                    tc=0;
                    t1.setText("not decide");
                    t2.setText("not decide");
                    t1.setTextColor(oc);
                    t2.setTextColor(oc);
                    if(Integer.parseInt(vicno)>=1)
                    {
                        startActivity(in);}

                    else{
                        Toast.makeText(MainActivity.this,"Enter valid no",Toast.LENGTH_SHORT).show();}

                    Log.e("ak47", "called");
                }
                else
                    Toast.makeText(MainActivity.this,"NOT TOSSED",Toast.LENGTH_LONG).show();


            }
        });
        toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tc==0) {
                    s1.setEnabled(true);
                    s2.setEnabled(true);
                    t1 = findViewById(R.id.play1);
                    t2 = findViewById(R.id.play2);
                    oc=t1.getTextColors();


                    int bv1 = (int) (Math.random() * 2 + 1);
                    if (bv1 == 1) {
                        t1.setText("Ash");
                        t1.setTextColor(Color.BLUE);
                        t2.setText("Pickachu");
                        t2.setTextColor(Color.YELLOW);
                    } else {
                        t2.setText("Ash");
                        t2.setTextColor(Color.BLUE);
                        t1.setText("Pickachu");
                        t1.setTextColor(Color.YELLOW);
                        player1 = "Pickachu";

                    }
                    tc=1;
                }
                else
                    Toast.makeText(MainActivity.this,"TOSS CAN BE DONE ONLY ONCE",Toast.LENGTH_LONG).show();

            }
        });



    }
}
