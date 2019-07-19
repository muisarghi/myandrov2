package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

public class TmbDiskusi extends AppCompatActivity {
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmbdiskusi);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        /*Button btnSaveDiskusi= (Button) findViewById(R.id.btnTmbDiskusi);
        btnSaveDiskusi.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v){
                Intent iz = new Intent(TmbDiskusi.this,Diskusi.class);
                startActivity(iz);
            }
        });
        */
    }


    public void nTmbDiskusi(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        EditText editdiskusis = (EditText)findViewById(R.id.editDiskusi);
        EditText editisidiskusis = (EditText)findViewById(R.id.editIsiDiskusi);

        //MyApolloClient.getMyApolloCleint().mutate(NewDiskusiMutation.builder()
        ApolloClient mutation = new MyApolloClient(token).getMyApolloCleint();
        mutation.mutate(NewDiskusiMutation.builder()
                .judul(editdiskusis.getText().toString())
                .isi(editisidiskusis.getText().toString()).build())
                .enqueue(new ApolloCall.Callback<NewDiskusiMutation.Data>() {


                    @Override
                    public void onResponse(@NotNull Response<NewDiskusiMutation.Data> response)
                    {
                        Intent intenti=new Intent(TmbDiskusi.this,Diskusi.class);
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
	
	public void mDiskusi(View va)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ia = new Intent(this,Diskusi.class);
        ia.putExtra("token", token);
        startActivity(ia);
    }
	
	public void mHome(View vb)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ib = new Intent(this,Dashboard.class);
        ib.putExtra("token", token);
        startActivity(ib);
    }
	
	public void mBerita(View vc)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ic = new Intent(this,Berita.class);
        ic.putExtra("token", token);
        startActivity(ic);
    }
	
	public void mCari(View vd)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent id = new Intent(this,Pencarian.class);
        id.putExtra("token", token);
        startActivity(id);
    }
	
	public void mTmb(View ve)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ie = new Intent(this,TmbDiskusi.class);
        ie.putExtra("token", token);
        startActivity(ie);
    }
	
	public void mLike(View vg)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ig = new Intent(this,Like.class);
        ig.putExtra("token", token);
        startActivity(ig);
    }
	
	public void mProfile(View vh)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ih = new Intent(this,Profile.class);
        ih.putExtra("token", token);
        startActivity(ih);
    }
}
