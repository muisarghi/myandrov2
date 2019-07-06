package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
//import javax.annotation.Nonnull;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.SimpleAdapter;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import static com.example.lbkomunitas.R.layout.list_item;

public class Lomba extends AppCompatActivity
{
	
	private static final String TAG = "Lomba";
	private TextView lomba1, lomba2, ketlomba1, ketlomba2;
	private String t1,t2,d1,d2;
	private Integer i, jumlah;

    private ListView listView;
   // ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);

		//lomba1 = (TextView) findViewById(R.id.lomba1);
        //lomba2 = (TextView) findViewById(R.id.lomba2);
        //ketlomba1 = (TextView) findViewById(R.id.ketlomba1);
        //ketlomba2 = (TextView) findViewById(R.id.ketlomba2);

		getLomba();
	}


	private void getLomba()
    {
        MyApolloClient.getMyApolloCleint().query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>() {
                    @Override
                    public void onResponse( Response<GetAllLombaQuery.Data> response)
                    {
                        //ArrayList<Lomba> lombaList = new ArrayList<>();
                        final ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
                        final ArrayAdapter<CharSequence> adapter;
                        final StringBuffer buffer1 = new StringBuffer();
                        final StringBuffer buffer2 = new StringBuffer();
                        final ListView listview = (ListView) findViewById(R.id.listView);

                        jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;


                        /*
                        jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;
                        GetAllLombaQuery.GetAllLomba feed = response.data().getAllLomba();
                        for (i = 0; i < jumlah; i++)
                        {
                            String mylomba=response.data().getAllLomba().get(i).lomba();
                            String myketlomba=response.data().getAllLomba().get(i).ketlomba()
                        }
                        */


                        for (GetAllLombaQuery.GetAllLomba feed : response.data().getAllLomba())

                        {
                            buffer1.append(feed.lomba);
                            buffer1.append('*');
                            //buffer2.append(" Keterangan: " + feed.ketlomba);
                            //list1.add(buffer1);
                        }
                        String [] buffer1x= buffer1.toString().split("*");
                        ArrayAdapter adapter = new ArrayAdapter<String>(Lomba.this, list_item, buffer1x);


                        Lomba.this.runOnUiThread(new Runnable()
                        //Lomba.this.listView.R.layout.list_item()
                        {
                            @Override
                            public void run()
                            {
                                ListView listView = (ListView) findViewById(R.id.listView);
                                listView.setAdapter(adapter);

                                    /*
                                    for (i = 0; i < jumlah; i++) {
                                        TextView txtResponse = (TextView) findViewById(R.id.lombaxy);
                                        txtResponse.setText(buffer1.toString());
                                        TextView txtResponse2 = (TextView) findViewById(R.id.ketlombaxy);
                                        txtResponse2.setText(buffer2.toString());
                                    }

                                    */
                            }
                                //TextView txtResponse = (TextView) findViewById(R.id.lombax);
                                //txtResponse.setText(buffer1.toString());

                                //TextView txtResponse2 = (TextView) findViewById(R.id.ketlombax);
                                //txtResponse2.setText(buffer2.toString());

                        }
                    });


                    }
                        /*
                    Log.d(TAG,"OnResponse: " + response.data().getAllLomba().get(1).lomba());
                        t1 = response.data().getAllLomba().get(1).lomba();
                        d1 = response.data().getAllLomba().get(1).ketlomba();


                        Lomba.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lomba1.setText(t1);
                                lomba2.setText(t2);
                                ketlomba1.setText(d1);
                                ketlomba2.setText(d2);
                            }
                        });
*/
                        @Override
            public void onFailure(ApolloException e)
                    {}
        });

    }

}