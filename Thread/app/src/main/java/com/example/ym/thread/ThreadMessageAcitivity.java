package com.example.ym.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class ThreadMessageAcitivity extends AppCompatActivity {

    ProgressBar bar1;
    ProgressBar bar2;

    TextView msgWorking;
    TextView msgReturned;

    boolean isRunning = false;

    final int MAX_SEC = 30;

    int globalIntTest = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String returnedValue = (String) msg.obj;

            msgReturned.append("\n returned value: " + returnedValue);

            bar1.incrementProgressBy(2);

            if (bar1.getProgress() == MAX_SEC) {
                msgReturned.append("\nDone \n back thread has been stopped");
                isRunning = false;
            }
            if (bar1.getProgress() == bar1.getMax()) {
                msgWorking.setText("Done");
                bar1.setVisibility(View.INVISIBLE);
                bar2.setVisibility(View.INVISIBLE);
            } else
                msgWorking.setText("Working..." + bar1.getProgress());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_message);

        bar1 = (ProgressBar) findViewById(R.id.progressbar1);
        bar1.setProgress(0);
        bar1.setMax(MAX_SEC);

        bar2 = (ProgressBar)findViewById(R.id.progressbar2);

        msgWorking = (TextView)findViewById(R.id.txtWorkprogress);
        msgReturned = (TextView)findViewById(R.id.txtReturnValues);

        globalIntTest = 1;
    }
    @Override
    public void onStart(){
        super.onStart();
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<MAX_SEC && isRunning ; i++){
                        Thread.sleep(1000);

                        Random rnd = new Random();
                        int localData = (int)rnd.nextInt(101);

                        String data = "Data-" + globalIntTest + "-" + localData;
                        globalIntTest++;

                        Message msg = handler.obtainMessage(1, (String)data);

                        if(isRunning){
                            handler.sendMessage(msg);
                        }
                    }
                }
                catch (Throwable t){
                    isRunning = false;
                }
            }
        });
        isRunning = true;
        background.start();

    }


}

