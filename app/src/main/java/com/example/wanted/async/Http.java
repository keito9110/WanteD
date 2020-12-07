package com.example.wanted.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.wanted.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http extends AsyncTask<URL, Void, JSONObject> {
    protected Activity activity;

    public Http(Activity activity) {
        this.activity = activity;
    }


    /**
     * 非同期処理で天気情報を取得する.
     * @param urls 接続先のURL
     * @return 取得した天気情報
     */
    @Override
    protected JSONObject doInBackground(URL... urls) {

        final URL url = urls[0];
        HttpURLConnection con = null;

        try {

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setInstanceFollowRedirects(false);
            con.connect();

            final int statusCode = con.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK) {
                return null;
            }

            final InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            if(null == encoding){
                encoding = "UTF-8";
            }
            final InputStreamReader inReader = new InputStreamReader(in, encoding);
            final BufferedReader bufReader = new BufferedReader(inReader);
            StringBuilder response = new StringBuilder();
            String line = null;

            while((line = bufReader.readLine()) != null) {
                response.append(line);
            }
            bufReader.close();
            inReader.close();
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}