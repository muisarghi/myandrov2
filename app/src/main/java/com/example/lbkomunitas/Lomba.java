package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import javax.annotation.Nonnull;
import android.widget.ListView;
import java.util.HashMap;

import java.util.ArrayList;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;
import static com.example.lbkomunitas.Constant.THIRD_COLUMN;


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
    private String token;



	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        //TextView myOutputBox = (TextView) findViewById(R.id.cubo);
        //myOutputBox.setText(token);


        lombax = (TextView) findViewById(R.id.lombaxy);

        ketlombax = (TextView) findViewById(R.id.ketlombaxy);

        ListView lview = (ListView) findViewById(R.id.listView);


        populateList();

	}



    private void populateList() {

        list = new ArrayList<HashMap>();

        //MyApolloClient.getMyApolloCleint().query(
        ApolloClient query = new MyApolloClient().getMyApolloCleint();
        query.query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {
                jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;
                final StringBuffer buffer1 = new StringBuffer();

                for (GetAllLombaQuery.GetLombaDesc feed : response.data().getLombaDesc())
                {
                    HashMap <String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, feed.lomba());
                    temp.put(SECOND_COLUMN, feed.ketlomba());
                    temp.put(THIRD_COLUMN, "Written By: " + feed.writtenBy().nama() + " @ " + feed.createdAt());
                    //temp.put(SECOND_COLUMN, feed.writtenBy().nama());
                    //temp.put(THIRD_COLUMN, feed.ketlomba());
                    list.add(temp);
                }

                Integer akuo = response.data().countLomba().aggregate().count();
                final String akuob = "Terdapat " + akuo + " Daftar Lomba ";
               /* for (GetAllLombaQuery.CountLomba feedc : response.data().countLomba())
                {
                    buffer1.append("Terdapat " + feedc.aggregate().count() + " Daftar Lomba");
                }*/

                final listViewAdapter adapter = new listViewAdapter(Lomba.this, list);


                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        ListView lview = (ListView) findViewById(R.id.listView);

                        lview.setAdapter(adapter);
                        TextView txtResponse = (TextView) findViewById(R.id.countLomba);
                        txtResponse.setText(akuob.toString());
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