package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.annotation.Nonnull;

public class Lomba extends AppCompatActivity
{
	
	private static final String TAG = "Lomba";
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lomba);
		getLomba();
	}


	private void getLomba()
    {
        MyApolloClient.getMyApolloCleint().query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>() {
                    @Override
            public void onResponse(@Nonnull Response<GetAllLombaQuery.Data> response)
                    {
                    Log.d(TAG,"OnResponse: " + response.data().getAllLomba().get(0).title());
                    }
                    @Override
            public void onFailure(@Nonnull ApolloException e)
                    {}
        });

    }

}