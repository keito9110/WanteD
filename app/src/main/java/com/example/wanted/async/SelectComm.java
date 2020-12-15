package com.example.wanted.async;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import com.example.wanted.R;
import com.example.wanted.api.Test;
import com.example.wanted.session.Comm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectComm extends Http {

    MutableLiveData<String> result;

    public SelectComm(Activity activity) {
        super(activity);
    }

    public MutableLiveData<String> getResult() {
        if (result == null) {
            result = new MutableLiveData<>();
        }
        return result;
    }

    @Override
    protected JSONObject doInBackground(URL... urls) {
        JSONObject resJson = super.doInBackground(urls);
        return resJson;
    }

    protected void onPostExecute(JSONObject resJson) {
        ArrayAdapter adapter;
        ListView lstv = (ListView) activity.findViewById(R.id.scroll);
        com.example.wanted.session.Comm comm = new com.example.wanted.session.Comm();
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        try {
            HashMap<String, String> data = new HashMap<String,String>();
            int listSize = resJson.getInt("size");
            for (int i = 0; i < listSize; i++) {
                comm.setComm_id(resJson.getJSONArray("lst").getJSONObject(i).getString("comm_id"));
                comm.setComm_name(resJson.getJSONArray("lst").getJSONObject(i).getString("comm_name"));
                comm.setComm_intro(resJson.getJSONArray("lst").getJSONObject(i).getString("comm_intro"));

                data.put("comm_id",comm.getComm_id());
                data.put("comm_name",comm.getComm_name());
                data.put("comm_intro",comm.getComm_intro());
                list.add(data);

                TextView btnTV = activity.findViewById(R.id.btn_scroll);
                btnTV.setText("APEXyoro");

                Button btn = activity.findViewById(R.id.btn_scroll);
                adapter = new ArrayAdapter<Test>
                        (activity, R.layout.scroll_view, R.id.btn_scroll);
                adapter.add(btn);
                lstv.setAdapter(adapter);

                result.setValue("success");
            }
            comm.setList(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
