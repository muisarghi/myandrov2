package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
//import javax.annotation.Nonnull;

public class Lomba extends AppCompatActivity
{
	
	private static final String TAG = "Lomba";
	private TextView lomba1, lomba2, ketlomba1, ketlomba2;
	private String t1,t2,d1,d2;

	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);

		lomba1 = (TextView) findViewById(R.id.lomba1);
        lomba2 = (TextView) findViewById(R.id.lomba2);
        ketlomba1 = (TextView) findViewById(R.id.ketlomba1);
        ketlomba2 = (TextView) findViewById(R.id.ketlomba2);

		getLomba();
	}


	private void getLomba()
    {
        MyApolloClient.getMyApolloCleint().query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>() {
                    @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
                    {
                    Log.d(TAG,"OnResponse: " + response.data().getAllLomba().get(1).lomba());
                        t1 = response.data().getAllLomba().get(1).lomba();
                        t2 = response.data().getAllLomba().get(2).lomba();
                        d1 = response.data().getAllLomba().get(1).ketlomba();
                        d2 = response.data().getAllLomba().get(2).ketlomba();

                        Lomba.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lomba1.setText(t1);
                                lomba2.setText(t2);
                                ketlomba1.setText(d1);
                                ketlomba2.setText(d2);
                            }
                        });
                    }
                    @Override
            public void onFailure(ApolloException e)
                    {}
        });

    }

}