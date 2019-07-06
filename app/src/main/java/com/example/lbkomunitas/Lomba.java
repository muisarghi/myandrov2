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
import java.util.Map;

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

    private static final String LOMBA_COLUMN = "LOMBA_COLUMN";
    private static final String KETLOMBA_COLUMN = "KETLOMBA_COLUMN";

    private ListView listView;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapterb;

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
        MyApolloClient.getMyApolloCleint().query(GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {


            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response) {
                //ArrayList<Lomba> lombaList = new ArrayList<>();
                final ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
                //final ArrayAdapter<CharSequence> adapter;
                final StringBuffer buffer1 = new StringBuffer();
                final StringBuffer buffer2 = new StringBuffer();
                final ListView listview = (ListView) findViewById(R.id.listView);

                jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;
                //HashMap temp = new HashMap();
                HashMap<String, String> temp = new HashMap<>();
                for (i=0 ; i < jumlah ; ++i)
                {

                    temp.put(LOMBA_COLUMN, response.data().getAllLomba().get(i).lomba());
                    temp.put(KETLOMBA_COLUMN, response.data().getAllLomba().get(i).ketlomba());
                list1.add(temp);
                }


                /*
                for (GetAllLombaQuery.GetAllLomba feed : response.data().getAllLomba()) {
                    buffer1.append(feed.lomba);
                    buffer1.append(',');
                    buffer2.append(feed.ketlomba);
                    buffer2.append(',');
                }
                */

                /*
                String[] buffer1x = buffer1.toString().split(",");
                String[] buffer2x = buffer2.toString().split(",");

                final ArrayAdapter adapter = new ArrayAdapter<String>(Lomba.this, list_item, R.id.lombaxy,buffer1x) ;

                ArrayAdapter adapter = new ArrayAdapter<String>(Lomba.this, list1, R.layout.list_item,
                        new String[]{String.valueOf(LOMBA_COLUMN), String.valueOf(KETLOMBA_COLUMN)},
                        new int[]{R.id.lombaxy, R.id.ketlombaxy}
                );
                */
                final ArrayAdapter adapter;
                /*adapter = new ArrayAdapter(Lomba.this, list1, list_item,
                        new String[]{LOMBA_COLUMN, KETLOMBA_COLUMN},
                        new int[]{R.id.lombaxy, R.id.ketlombaxy});
                        */

                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run() {
                        ListView listView = (ListView) findViewById(R.id.listView);
                        //listView.setAdapter(adapter);
                    }

                });


            }
        @Override
        public void onFailure(ApolloException e)
        {
        }
    });

    }


}