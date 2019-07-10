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
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;
//import android.view.View.OnClickListener;

public class Berita extends AppCompatActivity {
    private TextView beritaku;
    private TextView headlinex, beritax;
    private ArrayList<HashMap> listberita;
    private Integer i, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.activity_berita);
        beritaku = (TextView) findViewById(R.id.beritax);
        */
        headlinex = (TextView) findViewById(R.id.headlinexy);

        beritax = (TextView) findViewById(R.id.beritaxy);

        ListView lviewberita = (ListView) findViewById(R.id.listViewBerita);
        beritaList();
        //getBerita();
    }


    private void beritaList() {

        listberita = new ArrayList<HashMap>();

        MyApolloClient.getMyApolloCleint().query(
                GetAllBeritaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllBeritaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllBeritaQuery.Data> response)
            {
                //jumlah = GetAllBeritaQuery.GetBeritaDesc.$responseFields.length;

                for (GetAllBeritaQuery.GetBeritaDesc feedberita : response.data().getBeritaDesc())
                {
                    HashMap <String, String> tempberita = new HashMap<String, String>();
                    tempberita.put(FIRST_COLUMN, feedberita.headline());
                    tempberita.put(SECOND_COLUMN, feedberita.berita());
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
    /*
    private void getBerita()
    {
        MyApolloClient.getMyApolloCleint().query(GetAllBeritaQuery.builder().build()).enqueue
                (new ApolloCall.Callback<GetAllBeritaQuery.Data>()
                {

                    @Override
                    public void onResponse( Response<GetAllBeritaQuery.Data> response)
                    {
                        final StringBuffer bufferber = new StringBuffer();
                        for (GetAllBeritaQuery.GetAllBeritum feed : response.data().getAllBerita()) {
                            bufferber.append(feed.headline);
                            bufferber.append(" \n ");
                            bufferber.append(feed.berita);
                            bufferber.append(" \n \n ");
                        }


                        Berita.this.runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                beritaku.setText(bufferber.toString());

                            }

                        });


                    }
                    @Override
                    public void onFailure(ApolloException e)
                    {
                    }
                });

    }
   */
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
        Intent ie = new Intent(this,TmbBerita.class);
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
