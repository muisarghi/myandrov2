package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.lbkomunitas.Constant.FIRST_COLUMNBERITA;
import static com.example.lbkomunitas.Constant.SECOND_COLUMNBERITA;
import static com.example.lbkomunitas.Constant.THIRD_COLUMNBERITA;
import static com.example.lbkomunitas.MyApolloClient.*;
//import android.view.View.OnClickListener;

public class Berita extends AppCompatActivity {
   // private TextView beritaku;
   // private TextView headlinex, beritax;
    private ArrayList<HashMap> listberita;
    private String token;
  //  private Integer i, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        beritaList();
    }


    private void beritaList() {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        listberita = new ArrayList<HashMap>();
        ApolloClient query = new MyApolloClient().getMyApolloCleint();

        //MyApolloClient().getMyApolloCleint().query(
        query.query(
                GetAllBeritaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllBeritaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllBeritaQuery.Data> responseberita)
            {

                for (GetAllBeritaQuery.GetBeritaDesc feedberita : responseberita.data().getBeritaDesc())
                {
                    HashMap <String, String> tempberita = new HashMap<String, String>();
                    tempberita.put(FIRST_COLUMNBERITA, feedberita.headline());
                    tempberita.put(SECOND_COLUMNBERITA, feedberita.berita());
                    tempberita.put(THIRD_COLUMNBERITA, "Written By: " + feedberita.writtenBy().nama() + " @ " + feedberita.createdAt());
                    listberita.add(tempberita);
                }

                final beritaViewAdapter adapterberita = new beritaViewAdapter(Berita.this, listberita);


                Berita.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ListView lviewberita = (ListView) findViewById(R.id.listViewBerita);

                        lviewberita.setAdapter(adapterberita);
                    }

                });
            }


            @Override
            public void onFailure(ApolloException e)
            {}


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
        Intent ie = new Intent(this,TmbBerita.class);
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
