package com.example.hp.pokemon_dispute;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    int p1s=0,p2s=0,c1=0,c2=0,vn=4,f=0,mc=0,p1c=Color.BLUE,p2c=Color.YELLOW;
    Button b1,b2,b3,b4,n,r;
    TextView ashs,picas,p,lead;
    String p1="Ash",p2="Pickachu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String s=intent.getStringExtra("name");
        vn=Integer.parseInt(intent.getStringExtra("vicnum"));

        if(!s.equalsIgnoreCase(p1))
        {

            s=p1;
            p1=p2;
            p2=s;
        }
        p1c=Integer.valueOf(intent.getStringExtra("p1col"));
        p2c=Integer.valueOf(intent.getStringExtra("p2col"));
        init();
        p.setText(p1);
        b1.setOnClickListener(MainActivity2.this);
        b2.setOnClickListener(MainActivity2.this);
        b3.setOnClickListener(MainActivity2.this);
        b4.setOnClickListener(MainActivity2.this);
        n.setOnClickListener(MainActivity2.this);
        r.setOnClickListener(MainActivity2.this);
    }
    public void init()
    {
        ashs=findViewById(R.id.ash);
        picas=findViewById(R.id.picca);
        p=findViewById(R.id.cnm);
        lead=findViewById(R.id.sb);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        r=findViewById(R.id.rev);
        n=findViewById(R.id.nxt);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        if(id==R.id.b1&&(c1==0||c2==0))
        {
            Log.e("ak47",("ch1="+c1+"ch2"+c2));

            if(c1==0)
            {
                b1.setBackgroundColor(p1c);
                c1=1;
            }
            else if(c1!=1)
            {
                b1.setBackgroundColor(p2c);
                c2=1;

            }
            else if(c1==1)
                Toast.makeText(MainActivity2.this,"invalid choice",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.b2&&(c1==0||c2==0))
        {
            Log.e("ak47",("ch1="+c1+"ch2"+c2));
            if(c1==0)
            {
                b2.setBackgroundColor(p1c);

                c1=2;
            }
            else if(c1!=2)
            {
                b2.setBackgroundColor(p2c);

                c2=2;

            }
            else if(c1==2)
                Toast.makeText(MainActivity2.this,"invalid choice",Toast.LENGTH_SHORT).show();

        }
        else if(id==R.id.b3&&(c1==0||c2==0))
        {
            Log.e("ak47",("ch1="+c1+"ch2"+c2));

            if(c1==0)
            {
                b3.setBackgroundColor(p1c);

                c1=3;
            }
            else if (c1!=3)
            {
                b3.setBackgroundColor(p2c);

                c2=3;

            }
            else if(c1==3)
            {
                Toast.makeText(MainActivity2.this,"invalid choice",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.b4&&(c1==0||c2==0))
        {
            Log.e("ak47",("ch1="+c1+"ch2"+c2));

            if(c1==0)
            {
                b4.setBackgroundColor(p1c);

                c1=4;
            }
            else if(c1!=4)
            {
                b4.setBackgroundColor(p2c);

                c2=4;

            }
            else if(c1==4)
                Toast.makeText(MainActivity2.this,"invalid choice",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.rev&&f!=1)
        {

            if(c1==0)
            {
                Toast.makeText(MainActivity2.this,p1+" and "+p2+" Please make choice",Toast.LENGTH_SHORT).show();
            }
            else if (c2==0)
            {
                Toast.makeText(MainActivity2.this,p2+" Please make choice",Toast.LENGTH_SHORT).show();

            }
            else
            {
                f=1;
                score();
            }
        }
        else if(id==R.id.nxt&&f!=0)
        {
            f=0;
            c1=0;c2=0;
            ashs.setText(p1+":-"+p1s);
            picas.setText(p2+":-"+p2s);
            b1.setBackgroundResource(android.R.drawable.btn_default);
            b2.setBackgroundResource(android.R.drawable.btn_default);
            b3.setBackgroundResource(android.R.drawable.btn_default);
            b4.setBackgroundResource(android.R.drawable.btn_default);
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            Log.e("ak47","values reset");
            mc++;
            if(mc==vn) {
                String c="";
                if(p1s>p2s)
                    c=p1;
                else if(p2s>p1s)
                    c=p2;
                else
                    c="none";

                Log.e("ak47", "match complete");
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity2.this);
                b.setMessage("Winner of the game is:-"+c).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();


                    }
                });
                AlertDialog a=b.create();
                a.setTitle("Results");
                a.show();
            }


        }
        else if(id==R.id.nxt)
            Toast.makeText(MainActivity2.this,"PLEASE REVELE THE SCORES",Toast.LENGTH_SHORT).show();
        else if(id==R.id.rev)
            Toast.makeText(MainActivity2.this,"ALREADY REVELED! CLICK NEXT",Toast.LENGTH_SHORT).show();
        if(c1==0&&c2==0)
            p.setText(p1);
        else
            p.setText(p2);

    }
    public void score()
    {
        int bv1=(int)(Math.random()*30+1),bv2=(int)(Math.random()*30+1),bv3=(int)(Math.random()*30+1),bv4=(int)(Math.random()*30+1);
        b1.setText(String.valueOf(bv1));
        b2.setText(String.valueOf(bv2));
        b3.setText(String.valueOf(bv3));
        b4.setText(String.valueOf(bv4));
        switch (c1)
        {
            case 1:
                p1s+=bv1;
                break;
            case 2:
                p1s+=bv2;
                break;
             case 3:
                 p1s+=bv3;
                 break;
            case 4:
                p1s+=bv4;
                break;



        }
        switch (c2)
        {
            case 1:
                p2s+=bv1;
                break;
            case 2:
                p2s+=bv2;
                break;
            case 3:
                p2s+=bv3;
                break;
            case 4:
                p2s+=bv4;
                break;



        }
        Log.e("ak47",p1s+"p1s"+p2s+"p2s");

        if(p1s>p2s) {
            lead.setText(p1 + " is laeding by " + (p1s - p2s));
        }
        else if(p2s>p1s)
        {
            lead.setText(p2+" is leading by "+(p2s-p1s));
        }


    }
}
