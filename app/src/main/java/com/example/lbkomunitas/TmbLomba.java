package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

public class TmbLomba extends AppCompatActivity {
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmblomba);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
       // TextView myOutputBox = (TextView) findViewById(R.id.cubo);
       // myOutputBox.setText(token);

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
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        //EditText myOutputBox = (EditText) findViewById(R.id.cubo);
        //myOutputBox.setText(token);

        EditText editLombas = (EditText)findViewById(R.id.editLomba);
        EditText editKetLombas = (EditText)findViewById(R.id.editKetlomba);

        //MyApolloClient(token).getMyApolloCleint().mutate(NewLombaMutation.builder()
        ApolloClient mutation = new MyApolloClient(token).getMyApolloCleint();
        //((MyApolloClient) mutation).mutate(NewLombaMutation.builder()
        //((ApolloClient) mutation).mutate(NewLombaMutation.builder()
        mutation.mutate(NewLombaMutation.builder()
        .lomba(editLombas.getText().toString())
        .ketlomba(editKetLombas.getText().toString()).build())
                .enqueue(new ApolloCall.Callback<NewLombaMutation.Data>() {


                    @Override
                    public void onResponse(@NotNull Response<NewLombaMutation.Data> response)
                    {
                        Intent intenti=new Intent(TmbLomba.this,Lomba.class);
                        intenti.putExtra("token", token);
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
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent i = new Intent(this,Lomba.class);
        i.putExtra("token", token);
        startActivity(i);
    }
	
	public void mDiskusi(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ia = new Intent(this,Diskusi.class);
        ia.putExtra("token", token);
        startActivity(ia);
    }
	
	public void mHome(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ib = new Intent(this,Dashboard.class);
        ib.putExtra("token", token);
        startActivity(ib);
    }
	
	public void mBerita(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ic = new Intent(this,Berita.class);
        ic.putExtra("token", token);
        startActivity(ic);
    }
	
	public void mCari(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent id = new Intent(this,Pencarian.class);
        id.putExtra("token", token);
        startActivity(id);
    }
	
	public void mTmb(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ie = new Intent(this,TmbLomba.class);
        ie.putExtra("token", token);
        startActivity(ie);
    }
	
	public void mLike(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ig = new Intent(this,Like.class);
        ig.putExtra("token", token);
        startActivity(ig);
    }
	
	public void mProfile(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ih = new Intent(this,Profile.class);
        ih.putExtra("token", token);
        startActivity(ih);
    }
}
