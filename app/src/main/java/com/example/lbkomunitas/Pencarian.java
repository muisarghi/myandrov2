package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.ListView;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;

public class Pencarian extends AppCompatActivity {
    private ArrayList<HashMap> listsUser;
    private EditText Search;
    private TextView s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);

        //ListView lview = (ListView) findViewById(R.id.listViewsUser);

        final EditText searchNamas = (EditText)findViewById(R.id.editSearch);
        EditText myTextBox = (EditText) findViewById(R.id.editSearch);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s)
            {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after)
            {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                //TextView myOutputBox = (TextView) findViewById(R.id.hslCari);
                //TextView myOutputBox = (TextView) findViewById(R.id.editSearch);
               // myOutputBox.setText(s);
                //Search search = new Search();
                //search.(searchNamas.toString());

                populateListsUser(s);
                //String searchNama=myOutputBox;

            }
        });

    }


    private void populateListsUser(CharSequence s) {
        TextView myOutputBox = (TextView) findViewById(R.id.hslCari);


        //EditText searchNamas = (EditText)findViewById(R.id.editSearch);
        //TextView searchNamas = setText(s);
        String searchNamas = String.valueOf(s);
        myOutputBox.setText(searchNamas);
        listsUser = new ArrayList<HashMap>();
        //.searchNama(searchNamas.getText().toString())
        /*
        *final HeroAndFriendsNames heroAndFriendsQuery = HeroAndFriendsNames.builder()
    .episode(NEWHOPE)
    .build();
        *
        MyApolloClient.getMyApolloCleint().query(
                SearchUserQuery.builder()
                        .searchNama(searchNamas)
                        .build())
                .enqueue(new ApolloCall.Callback<SearchUserQuery.Data>()
                .searchNama(findViewById(R.id.editSearch).toString())
                */
        /*
        final SearchUserQuery searchUserQuerys = SearchUserQuery.builder()
                .searchNama(searchNamas)
                .build();
        MyApolloClient.getMyApolloCleint().query(searchUserQuerys)
                .enqueue(new ApolloCall.Callback<SearchUserQuery.Data>()
            */
        MyApolloClient.getMyApolloCleint().query(
                SearchUserQuery.builder()
                        .searchNama(searchNamas)
                        .build())
                .enqueue(new ApolloCall.Callback<SearchUserQuery.Data>()
        {

            @Override
            public void onResponse( Response<SearchUserQuery.Data> response)
            {
                //jumlah = GetAllLombaQuery.GetAllLomba.$responseFields.length;

                for (SearchUserQuery.SearchUser feedsUser : response.data().searchUser())
                {
                    HashMap <String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, feedsUser.nama());
                    temp.put(SECOND_COLUMN, feedsUser.email());
                    listsUser.add(temp);
                }


                final listViewAdaptersUser adaptersUser = new listViewAdaptersUser(Pencarian.this, listsUser);


                Pencarian.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        ListView lviewsUser = (ListView) findViewById(R.id.listViewsUser);

                        lviewsUser.setAdapter(adaptersUser);
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
	
	public void mDiskusi(View va)
    {
        Intent ia = new Intent(this,Diskusi.class);
        startActivity(ia);
    }
	
	public void mHome(View vb)
    {
        Intent ib = new Intent(this,Dashboard.class);
        startActivity(ib);
    }
	
	public void mBerita(View vc)
    {
        Intent ic = new Intent(this,Berita.class);
        startActivity(ic);
    }
	
	public void mCari(View vd)
    {
        Intent id = new Intent(this,Pencarian.class);
        startActivity(id);
    }
	
	public void mTmb(View ve)
    {
        Intent ie = new Intent(this,TmbPost.class);
        startActivity(ie);
    }
	
	public void mLike(View vg)
    {
        Intent ig = new Intent(this,Like.class);
        startActivity(ig);
    }
	
	public void mProfile(View vh)
    {
        Intent ih = new Intent(this,Profile.class);
        startActivity(ih);
    }

    public void nCari(View vi)
    {
        Intent ii = new Intent(this,ProfileC.class);
        startActivity(ii);
    }

}
