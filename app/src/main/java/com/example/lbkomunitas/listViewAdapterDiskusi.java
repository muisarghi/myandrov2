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
 

public class listViewAdapterDiskusi extends BaseAdapter
{
    public ArrayList<HashMap> list;
    Activity activity;
 
    public listViewAdapterDiskusi(Activity activity, ArrayList<HashMap> list) {
        super();
        this.activity = activity;
        this.list = list;
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
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
                    convertView = inflater.inflate(R.layout.list_itemdiskusi, null);
                    holder = new ViewHolder();
                    holder.txtFirst = (TextView) convertView.findViewById(R.id.diskusixy);
                    holder.txtSecond = (TextView) convertView.findViewById(R.id.isixy);
                    convertView.setTag(holder);
                }
                else
                {
                    holder = (ViewHolder) convertView.getTag();
                }
 
                HashMap map = list.get(position);
                holder.txtFirst.setText((CharSequence) map.get(FIRST_COLUMN));
                holder.txtSecond.setText((CharSequence) map.get(SECOND_COLUMN));

 
            return convertView;
    }
 
}