package com.example.ym.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ThreadMessageAcitivity extends AppCompatActivity {
    /*
        ProgressBar bar1;
        ProgressBar bar2;

        TextView msgWorking;
        TextView msgReturned;

        boolean isRunning = false;
        final int MAX_SEC = 30;

        int globalInteTest = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thread_message);
        }

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                String returnedValue = (String)msg.obj;

                msgReturned.append("\n returned value: "+ returnedValue);

                bar1.incrementProgressBy(2);

                if(bar1.getProgress()==MAX_SEC){
                    msgReturned.append("\nDone \n back thread has been stopped");
                    isRunning = false;
                }
                if(bar1.getProgress()== bar1.getMax()){
                    msgWorking.setText("Done");
                    bar1.setVisibility(View.INVISIBLE);
                    bar2.setVisibility(View.INVISIBLE);
                }
                else
                    msgWorking.setText("Working..." + bar1.getProgress());
            }
        };
        */
    ProgressBar progressView;
    boolean isRunning = false;


    Handler handler = new Handler() {
        public void handleMessage(Message empty) {
            progressView.incrementProgressBy(5);
        }
    };

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_thread_message);
        progressView = (ProgressBar) findViewById(R.id.progressbar);

    }

    public void onStop() {
        super.onStop();
        isRunning = false;
    }

    public void onStart() {
        super.onStart();
        progressView.setProgress(0);

        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());
                    }
                } catch (Throwable t) {
                }
            }
        });
            isRunning=true;
            background.start();
        }
    }
