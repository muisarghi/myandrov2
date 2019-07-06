package com.example.lbkomunitas;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.Request;

public class MyApolloClient
{
	private static final String BASE_URL = "https://lovebird-komunitas.herokuapp.com/";
	private static ApolloClient myApolloCleint;

	public static ApolloClient getMyApolloCleint()
	{
	HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
	loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
	OkHttpClient okHttpClient = new OkHttpClient.Builder()
			.addInterceptor(loggingInterceptor)
			.build();

	myApolloCleint = ApolloClient.builder()
			.serverUrl(BASE_URL)
			.okHttpClient(okHttpClient)
			.build();
	return myApolloCleint;
	}
}