package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetImage extends AppCompatActivity {
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detimage);
        Button btnAddKomentar = (Button) findViewById(R.id.btnAddKomentar);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        btnAddKomentar.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v){
                Intent iz = new Intent(DetImage.this,DetImage.class);
                iz.putExtra("token", token);
                startActivity(iz);
            }
        });
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

    public void mBack(View vj)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ij = new Intent(this,DetImage.class);
        ij.putExtra("token", token);
        startActivity(ij);
    }

    public void nCari(View vk)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        Intent ik = new Intent(this,ProfileC.class);
        ik.putExtra("token", token);
        startActivity(ik);
    }
}
