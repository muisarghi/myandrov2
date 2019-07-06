package com.example.lbkomunitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
//public class Lomba extends AppCompatActivity {


    //protected void onCreate(Bundle savedInstanceState) implements ListView.OnItemClickListener {
    public class Lomba extends AppCompatActivity implements ListView.OnItemClickListener {
        private ListView listView;

        private String JSON_STRING;

        //super.onCreate(savedInstanceState);
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lomba);
            listView = (ListView) findViewById(R.id.listView);
            listView.setOnItemClickListener(this);
            getJSON();
        }

        private void showLomba() {
            JSONObject jsonObject = null;
            ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            try {
                jsonObject = new JSONObject(JSON_STRING);
                JSONArray result = jsonObject.getJSONArray(Konfig.TAG_JSON_ARRAY);

                for (int i = 0; i < result.length(); i++) {
                    JSONObject jo = result.getJSONObject(i);
                    String id = jo.getString(Konfig.TAG_ID);
                    String lomba = jo.getString(Konfig.TAG_LOMBA);
                    String ketlomba = jo.getString(Konfig.TAG_KETLOMBA);

                    HashMap<String, String> employees = new HashMap<>();
                    employees.put(Konfig.TAG_ID, id);
                    employees.put(Konfig.TAG_LOMBA, lomba);
                    employees.put(Konfig.TAG_KETLOMBA, ketlomba);
                    list.add(employees);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            ListAdapter adapter = new SimpleAdapter(
                    Lomba.this, list, R.layout.list_item,
                    new String[]{Konfig.TAG_ID, Konfig.TAG_LOMBA, Konfig.TAG_KETLOMBA},
                    new int[]{R.id.id, R.id.lomba, R.id.ketlomba});

            listView.setAdapter(adapter);
        }

        private void getJSON() {
            class GetJSON extends AsyncTask<Void, Void, String> {

                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(Lomba.this, "Mengambil Data", "Mohon Tunggu...", false, false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    JSON_STRING = s;
                    showLomba();
                }

                @Override
                protected String doInBackground(Void... params) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequest(Konfig.URL_GET_ALL);
                    return s;
                }
            }
            GetJSON gj = new GetJSON();
            gj.execute();
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(this, Lomba.class);
            HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
            String empId = map.get(Konfig.TAG_ID).toString();
            intent.putExtra(Konfig.EMP_ID, id);
            startActivity(intent);
        }

        public void mLomba(View v) {
            Intent i = new Intent(this, Lomba.class);
            startActivity(i);
        }

        public void mDiskusi(View va) {
            Intent ia = new Intent(this, Diskusi.class);
            startActivity(ia);
        }

        public void mHome(View vb) {
            Intent ib = new Intent(this, Dashboard.class);
            startActivity(ib);
        }

        public void mBerita(View vc) {
            Intent ic = new Intent(this, Berita.class);
            startActivity(ic);
        }

        public void mCari(View vd) {
            Intent id = new Intent(this, Pencarian.class);
            startActivity(id);
        }

        public void mTmb(View ve) {
            Intent ie = new Intent(this, TmbLomba.class);
            startActivity(ie);
        }

        public void mLike(View vg) {
            Intent ig = new Intent(this, Like.class);
            startActivity(ig);
        }

        public void mProfile(View vh) {
            Intent ih = new Intent(this, Profile.class);
            startActivity(ih);
        }

    }


