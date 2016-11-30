package com.example.ym.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable myRunnable1 = new MyRunnableClass();
        Thread t1 = new Thread(myRunnable1);
        t1.start();

        MyThread t = new MyThread();
        t.start();

    }
}

class MyRunnableClass implements Runnable {
    @Override
    public void run() {

        try {
            for (int i = 100; i < 105; i++) {
                Thread.sleep(1000);
                Log.e("<<runnable>>", "runnable talking " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for(int i=0; i<5; i++) {
                Thread.sleep(1000);
                Log.e("[[thread]]", "Thread talking " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
