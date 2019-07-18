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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmbdiskusi);
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
        EditText editdiskusis = (EditText)findViewById(R.id.editDiskusi);
        EditText editisidiskusis = (EditText)findViewById(R.id.editIsiDiskusi);

        //MyApolloClient.getMyApolloCleint().mutate(NewDiskusiMutation.builder()
        ApolloClient mutation = new MyApolloClient().getMyApolloCleint();
        mutation.mutate(NewDiskusiMutation.builder()
                .judul(editdiskusis.getText().toString())
                .isi(editisidiskusis.getText().toString()).build())
                .enqueue(new ApolloCall.Callback<NewDiskusiMutation.Data>() {


                    @Override
                    public void onResponse(@NotNull Response<NewDiskusiMutation.Data> response)
                    {
                        Intent intenti=new Intent(TmbDiskusi.this,Diskusi.class);
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
	
	public void mDiskusi(View va)
    {
        Intent ia = new Intent(this,Diskusi.class);
        startActivity(ia);
    }
	
	public void mHome(View vb)
    {
        Intent ib = new Intent(this,Dashboard.class);
        startActivity(ib);
    }
	
	public void mBerita(View vc)
    {
        Intent ic = new Intent(this,Berita.class);
        startActivity(ic);
    }
	
	public void mCari(View vd)
    {
        Intent id = new Intent(this,Pencarian.class);
        startActivity(id);
    }
	
	public void mTmb(View ve)
    {
        Intent ie = new Intent(this,TmbDiskusi.class);
        startActivity(ie);
    }
	
	public void mLike(View vg)
    {
        Intent ig = new Intent(this,Like.class);
        startActivity(ig);
    }
	
	public void mProfile(View vh)
    {
        Intent ih = new Intent(this,Profile.class);
        startActivity(ih);
    }
}
