package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import javax.annotation.Nonnull;
import android.widget.ListView;
import java.util.HashMap;
import android.widget.ArrayAdapter;

import java.util.ArrayList;




import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;
import static com.example.lbkomunitas.Constant.THIRD_COLUMN;
import static com.example.lbkomunitas.Constant.FOURTH_COLUMN;

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
   // private ArrayList<LombaModel> lombaModelArrayList;
    private ListView listView;
   // ArrayAdapter<CharSequence> adapter;
    //ArrayAdapter<CharSequence> adapterb;

    //20190710
    private ArrayList<HashMap> list;
    //List<GetAllLombaQuery.GetAllLomba> dummyData = new ArrayList<>();
   // static CustomListAdapter customListAdapter;


	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);

		//lomba1 = (TextView) findViewById(R.id.lombax);
        lombax = (TextView) findViewById(R.id.lombax);
        //lomba2 = (TextView) findViewById(R.id.lomba2);
        ketlombax = (TextView) findViewById(R.id.ketlombax);
        //ketlomba2 = (TextView) findViewById(R.id.ketlomba2);
        //listView = findViewById(R.id.listView);

        //foodModelArrayList = new ArrayList<>();
        //lombaModelArrayList = populateList();

		//getLomba();


        ListView lview = (ListView) findViewById(R.id.listView);
        populateList();



	}



    private void populateList() {

        list = new ArrayList<HashMap>();

        /*
        HashMap temp = new HashMap();
        temp.put(FIRST_COLUMN,"Colored Notebooks");
        temp.put(SECOND_COLUMN, "By NavNeet");

        list.add(temp);

        HashMap temp1 = new HashMap();
        temp1.put(FIRST_COLUMN,"Diaries");
        temp1.put(SECOND_COLUMN, "By Amee Products");

        list.add(temp1);

        HashMap temp2 = new HashMap();
        temp2.put(FIRST_COLUMN,"Note Books and Stationery");
        temp2.put(SECOND_COLUMN, "By National Products");

        list.add(temp2);

        HashMap temp3 = new HashMap();
        temp3.put(FIRST_COLUMN,"Corporate Diaries");
        temp3.put(SECOND_COLUMN, "By Devarsh Prakashan");

        list.add(temp3);

        HashMap temp4 = new HashMap();
        temp4.put(FIRST_COLUMN,"Writing Pad");
        temp4.put(SECOND_COLUMN, "By TechnoTalaktive Pvt. Ltd.");

        list.add(temp4);
       */

        MyApolloClient.getMyApolloCleint().query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {


            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {
                jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;
                //GetAllLombaQuery.GetAllLomba feed = (GetAllLombaQuery.GetAllLomba) response.data().getAllLomba();

                //for (GetAllLombaQuery.GetAllLomba feed : response.data().getAllLomba())

                for (GetAllLombaQuery.GetLombaDesc feed : response.data().getLombaDesc())
                {
                    HashMap <String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, feed.lomba());
                    temp.put(SECOND_COLUMN, feed.ketlomba());
                    list.add(temp);
                }
                /*
                for (i = 0; i < jumlah; i++)

                {
                    //Object getrow = response.data().getAllLomba.get(i);

                    String lombaxx=response.data().getAllLomba().get().lomba().get(i);
                    String lombaxy=response.data().getAllLomba().get().ketlomba().get(i);
                   // String lombaxx=temp.get("lomba");
                    //String lombaxy=temp.get("ketlomba");
                    //String lombaxx=response.data().getAllLomba().get(i).get("lomba");
                    temp.put(FIRST_COLUMN, lombaxx.toString());
                    temp.put(SECOND_COLUMN, lombaxy.toString());
                    list.add(temp);
                }
                */

                final listViewAdapter adapter = new listViewAdapter(Lomba.this, list);

                /*
                for (i = 0; i < jumlah; i++)
                {
                    HashMap temp = new HashMap();
                    //String mylomba=response.data().getAllLomba().get(i).lomba();
                    //String myketlomba=response.data().getAllLomba().get(i).ketlomba()
                    temp.put(FIRST_COLUMN, response.data().getAllLomba().get(i).lomba());
                    temp.put(SECOND_COLUMN, response.data().getAllLomba().get(i).ketlomba());
                    list.add(temp);
                }
                */
                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //lomba1.setText(buffer.toString());
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


/*
	private void getLomba()
    {
        MyApolloClient.getMyApolloCleint().query(GetAllLombaQuery.builder().build()).enqueue
                (new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {


                final StringBuffer buffer = new StringBuffer();

               ////
                jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;
                for (i = 0; i < jumlah; i++)

                {
                    buffer.append(response.data().getAllLomba().get(i).lomba());
                }
                ////


                for (GetAllLombaQuery.GetAllLomba feed : response.data().getAllLomba()) {
                    buffer.append(feed.lomba);
                    buffer.append(" \n ");
                    buffer.append(feed.ketlomba);
                    buffer.append(" \n \n ");
                }


                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        lomba1.setText(buffer.toString());


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