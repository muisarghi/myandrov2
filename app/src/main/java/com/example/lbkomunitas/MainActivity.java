package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPref();
        initLogin();
    }


    private void checkPref()
    {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
        String userToken = pref.getString("token", null);
        if(userToken != null){
            finish();
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            intent.putExtra("token",userToken);
            startActivity(intent);
        }

    }

    private void initLogin()
    {
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
                loginis();
                //Intent i = new Intent(MainActivity.this,Dashboard.class);
                //startActivity(i);
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



    private void loginis()
    {

        EditText emails = (EditText)findViewById(R.id.editTextEmail);
        EditText passwords = (EditText)findViewById(R.id.editTextPassword);
        //MyApolloClient.getMyApolloCleint().mutate(LoginMutation.builder()
        ApolloClient mutation = new MyApolloClient().getMyApolloCleint();
        mutation.mutate(LoginMutation.builder()
                .email(emails.getText().toString())
                .password(passwords.getText().toString())
                .build())
                .enqueue(new ApolloCall.Callback<LoginMutation.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<LoginMutation.Data> response)
                    {
                        //Intent intenti=new Intent(MainActivity.this,Dashboard.class);
                        //intenti.putExtra("Pendaftaran", "Pendaftaran Anggota Berhasil");
                        //startActivity(intenti);
                       // editor.putString("token", response);
                        editor.putString("token", response.data().login().token());
                        editor.apply();
                        //Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        Intent intent = new Intent(MainActivity.this, Dashboard.class);
                        //intent.putExtra("token", response);
                        intent.putExtra("token", response.data().login().token());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {

                    }
                });
    }

}
