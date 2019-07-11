package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

public class Daftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        /*
        Button btn = (Button) findViewById(R.id.daftarsimpan);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(Daftar.this,Dashboard.class);
                startActivity(i);
            }
        });
        */
    }
    public void nTmbUser(View v)
    {
        /*
        EditText editLombas = (EditText)findViewById(R.id.editLomba);
        EditText editKetLombas = (EditText)findViewById(R.id.editKetlomba);
        */
        EditText editNamas = (EditText)findViewById(R.id.editTextNama);
        EditText editAlamats = (EditText)findViewById(R.id.editTextAlamat);
        EditText editEmails = (EditText)findViewById(R.id.editTextEmail);
        EditText editNohps = (EditText)findViewById(R.id.editTextNohp);
        EditText editBiografis = (EditText)findViewById(R.id.editTextBiografi);
        EditText editPasswords = (EditText)findViewById(R.id.editTextPassword);


        MyApolloClient.getMyApolloCleint().mutate(NewUserMutation.builder()
                .nama(editNamas.getText().toString())
                .alamat(editAlamats.getText().toString())
                .email(editEmails.getText().toString())
                .nohp(editNohps.getText().toString())
                .biografi(editBiografis.getText().toString())
                .password(editPasswords.getText().toString())
                .build())
                .enqueue(new ApolloCall.Callback<NewUserMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<NewUserMutation.Data> response)
                    {
                        Intent intenti=new Intent(Daftar.this,MainActivity.class);
                        intenti.putExtra("Pendaftaran", "Pendaftaran Anggota Berhasil");
                        startActivity(intenti);

                        /*
                        TmbLomba.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(TmbLomba.this,"Data Telah Masuk", Toast.LENGTH_SHORT).show();

                            }
                        });*/

                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {

                    }



                });
    }


}
