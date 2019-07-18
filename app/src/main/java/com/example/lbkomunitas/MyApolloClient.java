package com.example.lbkomunitas;

import com.apollographql.apollo.ApolloClient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.Request;

public class MyApolloClient
{
	private static final String BASE_URL = "https://lovebird-komunitas.herokuapp.com/";
	private String AUTH_TOKEN;
	private static ApolloClient myApolloCleint;
	
	public MyApolloClient() {
	}
	
	public MyApolloClient(String tokenUser) {
        this.AUTH_TOKEN = tokenUser;
    }
	
	public ApolloClient getMyApolloCleint()
	{
	HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
	loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
	
	/*
	OkHttpClient okHttpClient = new OkHttpClient.Builder()
			.addInterceptor(loggingInterceptor)
			.build();
			*/
			
	OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new Interceptor() {
					@Override
					public Response intercept(Chain chain) throws IOException {
						Request original = chain.request();
						Request.Builder builder = original.newBuilder().method(original.method(), original.body());
						builder.header("Authorization", "Bearer " + AUTH_TOKEN);
						return chain.proceed(builder.build());
					}
				}).build();

	myApolloCleint = ApolloClient.builder()
			.serverUrl(BASE_URL)
			.okHttpClient(okHttpClient)
			.build();
	return myApolloCleint;
	}
}