package com.example.wanted.async;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import com.example.wanted.R;
import com.example.wanted.android.AuthToken;
import com.example.wanted.android.game_genre;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class AuthUser extends Http {

    MutableLiveData<String> result;

    public AuthUser(Activity activity) {
        super(activity);
    }

    public MutableLiveData<String> getResult(){
        if(result == null){
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
        Boolean re = false;
        String err = "認証失敗";
        try {
            re = resJson.getBoolean("auth");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (re == true){
            err = "認証成功";
            TextView tv = activity.findViewById(R.id.err);
            tv.setText(err);
            result.setValue("success");
        }
        else {
            TextView tv = activity.findViewById(R.id.err);
            tv.setText(err);
        }
    }
}
