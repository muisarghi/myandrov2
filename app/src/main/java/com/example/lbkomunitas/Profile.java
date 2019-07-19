package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.support.design.widget.FloatingActionButton;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;
import static com.example.lbkomunitas.Constant.THIRD_COLUMN;


public class Profile extends AppCompatActivity {
    private FloatingActionButton fab;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        jmllomba();
        jmlberita();


/*pada method onCreate, panggil fab dari xml
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */

    }

    public void jmllomba()
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        ApolloClient query = new MyApolloClient(token).getMyApolloCleint();
        query.query(
                GetAllLombaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllLombaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllLombaQuery.Data> response)
            {
                final StringBuffer buffer1 = new StringBuffer();

                Integer akuo = response.data().countLombaId().aggregate().count();
                //GetAllLombaQuery.CountLomba buffer1 : response.data().countLombaId().aggregate()
                //Integer akuo = 100;
                final String akuob = " " + akuo + " ";


                Profile.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        TextView txtJCId = (TextView) findViewById(R.id.countLombaId);
                        txtJCId.setText(akuob.toString());
                    }

                });
            }


            @Override
            public void onFailure(ApolloException e)
            {}


        });
    }

    public void jmlberita()
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        ApolloClient query = new MyApolloClient(token).getMyApolloCleint();
        query.query(
                GetAllBeritaQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllBeritaQuery.Data>()
        {

            @Override
            public void onResponse( Response<GetAllBeritaQuery.Data> responseb)
            {


                Integer akuob = responseb.data().countBeritaId().aggregate().count();
                //GetAllLombaQuery.CountLomba buffer1 : response.data().countLombaId().aggregate()
                //Integer akuo = 100;
                final String akuobb = " " + akuob + " ";


                Profile.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        TextView txtJCIdb = (TextView) findViewById(R.id.countBeritaId);
                        txtJCIdb.setText(akuobb.toString());
                    }

                });
            }


            @Override
            public void onFailure(ApolloException e)
            {}


        });
    }


    public void nBtnEditProfile(View vk)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ik = new Intent(this,EditProfile.class);
        ik.putExtra("token", token);
        startActivity(ik);
    }


    public void mLomba(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent i = new Intent(this,Lomba.class);
        i.putExtra("token", token);
        startActivity(i);
    }
	
	public void mDiskusi(View va)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ia = new Intent(this,Diskusi.class);
        ia.putExtra("token", token);
        startActivity(ia);
    }
	
	public void mHome(View vb)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ib = new Intent(this,Dashboard.class);
        ib.putExtra("token", token);
        startActivity(ib);
    }
	
	public void mBerita(View vc)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ic = new Intent(this,Berita.class);
        ic.putExtra("token", token);
        startActivity(ic);
    }
	
	public void mCari(View vd)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent id = new Intent(this,Pencarian.class);
        id.putExtra("token", token);
        startActivity(id);
    }
	
	public void mTmb(View ve)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ie = new Intent(this,TmbPost.class);
        ie.putExtra("token", token);
        startActivity(ie);
    }
	
	public void mLike(View vg)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ig = new Intent(this,Like.class);
        ig.putExtra("token", token);
        startActivity(ig);
    }
	
	public void mProfile(View vh)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ih = new Intent(this,Profile.class);
        ih.putExtra("token", token);
        startActivity(ih);
    }

    public void mDetImage(View vj)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ij = new Intent(this,DetImage.class);
        ij.putExtra("token", token);
        startActivity(ij);
    }

}
