package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                Intent a = new Intent(MainActivity.this,Daftar.class);
                startActivity(a);
            }
        });

    }


}
