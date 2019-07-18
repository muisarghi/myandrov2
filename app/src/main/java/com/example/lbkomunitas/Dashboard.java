package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
//import android.view.View.OnClickListener;

public class Dashboard extends AppCompatActivity
{
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        //TextView myOutputBox = (TextView) findViewById(R.id.cubo);
       // myOutputBox.setText(token);
        /*
         Intent intent = new Intent(this, Lomba.class);
        intent.putExtra("token", token);
        startActivity(intent);
        */
    }


    public void mLomba(View vdash)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent idashboard = new Intent(Dashboard.this,Lomba.class);
        idashboard.putExtra("token", token);
        startActivity(idashboard);
    }
	
	public void mDiskusi(View vadash)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent iadashboard = new Intent(Dashboard.this,Diskusi.class);
        iadashboard.putExtra("token", token);
        startActivity(iadashboard);
    }
	
	public void mHome(View vbdash)
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

        Intent ie = new Intent(this,TmbLomba.class);
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

    public void mBack(View vk)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ik = new Intent(this,Dashboard.class);
        ik.putExtra("token", token);
        startActivity(ik);
    }

    public void nCari(View vl)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent il = new Intent(this,ProfileC.class);
        il.putExtra("token", token);
        startActivity(il);
    }


}
