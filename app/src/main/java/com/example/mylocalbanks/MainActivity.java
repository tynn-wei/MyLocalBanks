package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs;
    TextView tvOcbc;
    TextView tvUob;

    String clicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v == tvDbs){
            clicked = "dbs";
        }
        else if(v == tvOcbc){
            clicked = "ocbc";
        }
        else if(v == tvUob){
            clicked = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(clicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+1111111));
                startActivity(intentCall);
                return true;
            }
        }

        else if(clicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+3633333));
                startActivity(intentCall);
                return true;
            }
        }

        else if(clicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+2222121));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText("DBS ");
            tvOcbc.setText("OCBC ");
            tvUob.setText("UOB ");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDbs.setText("星展银行 ");
            tvOcbc.setText("华侨银行 ");
            tvUob.setText("大华银行 ");
            return true;
        } else {
            tvDbs.setText("Error translation");
            tvOcbc.setText("Error translation");
            tvUob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

}