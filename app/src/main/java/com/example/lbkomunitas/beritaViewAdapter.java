package com.example.lbkomunitas;

import static com.example.lbkomunitas.Constant.FIRST_COLUMN;
import static com.example.lbkomunitas.Constant.SECOND_COLUMN;

 
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
    Activity activity;
 
    public beritaViewAdapter(Activity activity, ArrayList<HashMap> listberita) {
        super();
        this.activity = activity;
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
 
    private class ViewHolder {
           TextView txtFirst;
           TextView txtSecond;

      }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
 
        // TODO Auto-generated method stub
                ViewHolder holder;
                LayoutInflater inflater =  activity.getLayoutInflater();
 
                if (convertView == null)
                {
                    convertView = inflater.inflate(R.layout.list_itemberita, null);
                    holder = new ViewHolder();
                    holder.txtFirst = (TextView) convertView.findViewById(R.id.headlinexy);
                    holder.txtSecond = (TextView) convertView.findViewById(R.id.beritaxy);
                    convertView.setTag(holder);
                }
                else
                {
                    holder = (ViewHolder) convertView.getTag();
                }
 
                HashMap map = listberita.get(position);
                holder.txtFirst.setText((CharSequence) map.get(FIRST_COLUMN));
                holder.txtSecond.setText((CharSequence) map.get(SECOND_COLUMN));

 
            return convertView;
    }
 
}