package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import javax.annotation.Nonnull;
import android.widget.ListView;
import java.util.HashMap;

import java.util.ArrayList;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;


public class Lomba extends AppCompatActivity
{
	
	private static final String TAG = "Lomba";
	private TextView lomba1, lombax, ketlombax;
    private String lomba2;
    private TextView ketlomba1;
    private String ketlomba2;
	private String t1,t2,d1,d2;
	private Integer i, jumlah;

    private static final String LOMBA_COLUMN = "LOMBA_COLUMN";
    private static final String KETLOMBA_COLUMN = "KETLOMBA_COLUMN";

    private ListView listView;

    private ArrayList<HashMap> list;




	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);

        lombax = (TextView) findViewById(R.id.lombaxy);

        ketlombax = (TextView) findViewById(R.id.ketlombaxy);

        ListView lview = (ListView) findViewById(R.id.listView);
        populateList();

	}



    private void populateList() {

        list = new ArrayList<HashMap>();

        MyApolloClient.getMyApolloCleint().query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {
                jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;

                for (GetAllLombaQuery.GetLombaDesc feed : response.data().getLombaDesc())
                {
                    HashMap <String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, feed.lomba());
                    temp.put(SECOND_COLUMN, feed.ketlomba());
                    list.add(temp);
                }


                final listViewAdapter adapter = new listViewAdapter(Lomba.this, list);


                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        ListView lview = (ListView) findViewById(R.id.listView);

                        lview.setAdapter(adapter);
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