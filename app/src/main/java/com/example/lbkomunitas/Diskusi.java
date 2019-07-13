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
import java.util.HashMap;
import java.util.ArrayList;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import android.view.View.OnClickListener;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;


public class Diskusi extends AppCompatActivity {
    //private TextView discussi;
	private ArrayList<HashMap> listdiskusi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskusi);
        //discussi = (TextView) findViewById(R.id.discuss);

        //getDiskusi();
        diskusiList();
    }

    private void diskusiList() {

        listdiskusi = new ArrayList<HashMap>();

        MyApolloClient.getMyApolloCleint().query(
                GetAllDiskusiQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllDiskusiQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllDiskusiQuery.Data> responsediskusi)
            {

                for (GetAllDiskusiQuery.GetDiskusiDesc feeddiskusi : responsediskusi.data().getDiskusiDesc())
                {
                    HashMap <String, String> tempdiskusi = new HashMap<String, String>();
                    tempdiskusi.put(FIRST_COLUMN, feeddiskusi.judul());
                    tempdiskusi.put(SECOND_COLUMN, feeddiskusi.isi());
                    listdiskusi.add(tempdiskusi);
                }

                final listViewAdapterDiskusi adapterdiskusi = new listViewAdapterDiskusi(Diskusi.this, listdiskusi);


                Diskusi.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ListView lviewberita = (ListView) findViewById(R.id.listViewDiskusi);

                        lviewberita.setAdapter(adapterdiskusi);
                    }

                });
            }


            @Override
            public void onFailure(ApolloException e)
            {}


        });

    }
/*
    private void getDiskusi()
    {
        MyApolloClient.getMyApolloCleint().query(GetAllDiskusiQuery.builder().build()).enqueue
                (new ApolloCall.Callback<GetAllDiskusiQuery.Data>()
                {

                    @Override
                    public void onResponse( Response<GetAllDiskusiQuery.Data> response)
                    {
                        final StringBuffer bufferdis = new StringBuffer();
                        for (GetAllDiskusiQuery.GetAllDiskusi feed : response.data().getAllDiskusi()) {
                            bufferdis.append(feed.judul);
                            bufferdis.append(" \n ");
                            bufferdis.append(feed.isi);
                            bufferdis.append(" \n \n ");
                        }


                        Diskusi.this.runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                discussi.setText(bufferdis.toString());

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

    public void nDetDiskusi(View vj)
    {
        Intent ij = new Intent(this,DetDiskusi.class);
        startActivity(ij);
    }


}
