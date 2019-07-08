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

		lomba1 = (TextView) findViewById(R.id.lombax);
        //lomba2 = (TextView) findViewById(R.id.lomba2);
        ketlomba1 = (TextView) findViewById(R.id.ketlombax);
        //ketlomba2 = (TextView) findViewById(R.id.ketlomba2);

		getLomba();
	}


	private void getLomba()
    {
        MyApolloClient.getMyApolloCleint().query(GetAllLombaQuery.builder().build()).enqueue
                (new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {


            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {
                final StringBuffer buffer = new StringBuffer();
                for (GetAllLombaQuery.GetAllLomba feed : response.data().getAllLomba()) {
                    buffer.append(feed.lomba);
                    buffer.append(" \n ");
                    buffer.append(feed.ketlomba);
                    buffer.append(" \n \n ");
                }




                Lomba.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run() {
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


}