package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

public class TmbLomba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmblomba);

        /*
        Button btnSaveLomba = (Button) findViewById(R.id.btnTmbLomba);
        btnSaveLomba.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v){
                Intent iz = new Intent(TmbLomba.this,Lomba.class);
                startActivity(iz);
            }
        });
        */

    }

    public void nTmbLomba(View v)
    {
        EditText editLombas = (EditText)findViewById(R.id.editLomba);
        EditText editKetLombas = (EditText)findViewById(R.id.editKetlomba);

        MyApolloClient.getMyApolloCleint().mutate(NewLombaMutation.builder()
        .lomba(editLombas.getText().toString())
        .ketlomba(editKetLombas.getText().toString()).build())
                .enqueue(new ApolloCall.Callback<NewLombaMutation.Data>() {





                    @Override
                    public void onResponse(@NotNull Response<NewLombaMutation.Data> response)
                    {
                        Intent intenti=new Intent(TmbLomba.this,Lomba.class);
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
	
	public void mLomba(View v)
    {
        Intent i = new Intent(this,Lomba.class);
        startActivity(i);
    }
	
	public void mDiskusi(View v)
    {
        Intent ia = new Intent(this,Diskusi.class);
        startActivity(ia);
    }
	
	public void mHome(View v)
    {
        Intent ib = new Intent(this,Dashboard.class);
        startActivity(ib);
    }
	
	public void mBerita(View v)
    {
        Intent ic = new Intent(this,Berita.class);
        startActivity(ic);
    }
	
	public void mCari(View v)
    {
        Intent id = new Intent(this,Pencarian.class);
        startActivity(id);
    }
	
	public void mTmb(View v)
    {
        Intent ie = new Intent(this,TmbLomba.class);
        startActivity(ie);
    }
	
	public void mLike(View v)
    {
        Intent ig = new Intent(this,Like.class);
        startActivity(ig);
    }
	
	public void mProfile(View v)
    {
        Intent ih = new Intent(this,Profile.class);
        startActivity(ih);
    }
}
