package com.example.lbkomunitas;

import static com.example.lbkomunitas.Constant.FIRST_COLUMNBERITA;
import static com.example.lbkomunitas.Constant.SECOND_COLUMNBERITA;

 
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 

public class beritaViewAdapter extends BaseAdapter
{
    public ArrayList<HashMap> listberita;
    Activity activityberita;
 
    public beritaViewAdapter(Activity activityberita, ArrayList<HashMap> listberita) {
        super();
        this.activityberita = activityberita;
        this.listberita = listberita;
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listberita.size();
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listberita.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    private class ViewHolderBerita {
           TextView txtFirstberita;
           TextView txtSecondberita;

      }
 
    @Override
    public View getView(int position, View convertViewberita, ViewGroup parent) {
        // TODO Auto-generated method stub
 
        // TODO Auto-generated method stub
                ViewHolderBerita holderberita;
                LayoutInflater inflaterberita =  activityberita.getLayoutInflater();
 
                if (convertViewberita == null)
                {
                    convertViewberita = inflaterberita.inflate(R.layout.list_itemberita, null);
                    holderberita = new ViewHolderBerita();
                    holderberita.txtFirstberita = (TextView) convertViewberita.findViewById(R.id.headlinexy);
                    holderberita.txtSecondberita = (TextView) convertViewberita.findViewById(R.id.beritaxy);
                    convertViewberita.setTag(holderberita);
                }
                else
                {
                    holderberita = (ViewHolderBerita) convertViewberita.getTag();
                }
 
                HashMap mapberita = listberita.get(position);
                holderberita.txtFirstberita.setText((CharSequence) mapberita.get(FIRST_COLUMNBERITA));
                holderberita.txtSecondberita.setText((CharSequence) mapberita.get(SECOND_COLUMNBERITA));

 
            return convertViewberita;
    }
 
}