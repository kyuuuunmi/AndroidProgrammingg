package com.example.ym.thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AsyncTaskActivity extends AppCompatActivity {


    Button btnSlowWork;
    Button btnQuickwWork;
    EditText txtMsg;
    Long startingMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        txtMsg = (EditText) findViewById(R.id.edit_async);

        btnSlowWork = (Button) findViewById(R.id.btn_slowwork);
        this.btnSlowWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VerySlowTask().execute();

            }
        });

        btnQuickwWork = (Button)findViewById(R.id.btn_quick);
        btnQuickwWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMsg.setText(new Date().toString());
            }
        });
    }

    private class VerySlowTask extends AsyncTask<String, Long, Void> {

        private final ProgressDialog dialog = new ProgressDialog(AsyncTaskActivity.this);

        protected void onPreExecute() {
            startingMillis = System.currentTimeMillis();
            txtMsg.setText("Start Time: " + startingMillis);
            dialog.setMessage("Wait\nSome SLOW job is bening done...");
            dialog.show();
        }

        protected Void doInBackground(final String... args) {
            try {

                for (Long i = 0L; i < 3L; i++) {
                    Thread.sleep(2000);
                    publishProgress((Long) i, i+1, i+2);

                }
            }catch (InterruptedException e){
                Log.v("slow-job interrupted", e.getMessage());
            }
            return null;
        }
        protected  void onProgressUpdate(Long... value){
            super.onProgressUpdate(value);

            txtMsg.append("\nworking..."+ value[0] + " " + value[1] + value[2]);


        }
        protected void onPostExecute(final Void unused){
            if (dialog.isShowing()) {

                dialog.dismiss();
            }
            txtMsg.append("\nEnd TIme:"+(System.currentTimeMillis()-startingMillis)/1000);
            txtMsg.append("\ndone!");
        }
    }

}