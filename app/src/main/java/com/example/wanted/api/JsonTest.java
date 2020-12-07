package com.example.wanted.api;

import android.app.Activity;
import android.widget.TextView;

import com.example.wanted.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class JsonTest extends Http{

    public JsonTest(Activity activity) {
        super(activity);
    }
    
    @Override
    protected JSONObject doInBackground(URL... urls) {
        JSONObject resJson = super.doInBackground(urls);
        return resJson;
    }
    protected void onPostExecute(JSONObject resJson) {
        String result = "";
        try {
            result = resJson.getString("token");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView tv = activity.findViewById(R.id.textView8);
        tv.setText(result);
    }
}
