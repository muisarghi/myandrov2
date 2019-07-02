package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import android.view.View.OnClickListener;

public class Diskusi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskusi);
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
        Intent ie = new Intent(this,TmbDiskusi.class);
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


}
