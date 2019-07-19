package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TmbPost extends AppCompatActivity {
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmbpost);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
    }





    public void mLomba(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent i = new Intent(this,Lomba.class);
        i.putExtra("token", token);
        startActivity(i);
    }

    public void mDiskusi(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ia = new Intent(this,Diskusi.class);
        ia.putExtra("token", token);
        startActivity(ia);
    }

    public void mHome(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ib = new Intent(this,Dashboard.class);
        ib.putExtra("token", token);
        startActivity(ib);
    }

    public void mBerita(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ic = new Intent(this,Berita.class);
        ic.putExtra("token", token);
        startActivity(ic);
    }

    public void mCari(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent id = new Intent(this,Pencarian.class);
        id.putExtra("token", token);
        startActivity(id);
    }

    public void mTmb(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ie = new Intent(this,TmbPost.class);
        ie.putExtra("token", token);
        startActivity(ie);
    }

    public void mLike(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ig = new Intent(this,Like.class);
        ig.putExtra("token", token);
        startActivity(ig);
    }

    public void mProfile(View v)
    {
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Intent ih = new Intent(this,Profile.class);
        ih.putExtra("token", token);
        startActivity(ih);
    }

}
