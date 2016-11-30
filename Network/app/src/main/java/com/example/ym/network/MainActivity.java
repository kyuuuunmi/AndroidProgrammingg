package com.example.ym.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload = (Button) findViewById(R.id.btn_download);
        View.OnClickListener downloadListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetWorkAvailable()) {
                    EditText url = (EditText) findViewById(R.id.edit_url);
                    DownloadTask downloadTask = new DownloadTask();
                    downloadTask.execute(url.getText().toString());
                }
                else{
                    Toast.makeText(getBaseContext(), "Network is not Available", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnDownload.setOnClickListener(downloadListener);
    }

    private boolean isNetWorkAvailable() {
        boolean available = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable())
            available = true;
        return available;
    }
    private  String downloadUrl(String strUrl) throws IOException{
        String s = null;
        byte[] buffer = new byte[1000];
        InputStream inputStream = null;

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();
            inputStream.read(buffer);
            s = new String(buffer);
        } catch (Exception e){
         //   Log.d("Exception while downloading url", e.toString());

        }finally {
            inputStream.close();
        }
        return s;
    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {
        String s = null;

        protected String doInBackground(String... url){

            try {
                s = downloadUrl(url[0]);
            } catch (IOException e) {
                Log.d("Background Task", e.toString());
            }
            return s;

        }
        protected void onPostExecute(String result){
            TextView textView = (TextView) findViewById(R.id.txt_tv);
            textView.setText(result);
            Toast.makeText(getBaseContext(), "Web page downloaded successfully", Toast.LENGTH_SHORT).show();
        }
    }

}
