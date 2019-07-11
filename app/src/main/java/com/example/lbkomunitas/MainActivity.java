package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            Bundle dataExtra = getIntent().getExtras();
            String HslDaftar = dataExtra.getString("Pendaftaran");
            Toast.makeText(this, HslDaftar, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show();
        }


        Button btn = (Button) findViewById(R.id.buttonlogin);
        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,Dashboard.class);
                startActivity(i);
            }
        });

        Button btnb = (Button) findViewById(R.id.buttondaftar);
        btnb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v){


                //Intent a = new Intent(MainActivity.this,Daftar.class);
                Intent a = new Intent(MainActivity.this,Daftar.class);

                startActivity(a);
            }
        });

    }


}
