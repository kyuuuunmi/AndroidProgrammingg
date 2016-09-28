package com.example.ym.followme01;

import android.animation.ObjectAnimator;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_smile;
    float previous_x= 0;
    float previous_y= 0;
    Vibrator mVibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        iv_smile = (ImageView)findViewById(R.id.smile80by80);

        mVibe = (Vibrator)getSystemService(getApplicationContext().VIBRATOR_SERVICE);
    }


    public boolean onTouchEvent(MotionEvent event){



        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int touch_x = (int)event.getX();
                int touch_y = (int)event.getY();

                ObjectAnimator smileX = ObjectAnimator.ofFloat(iv_smile, "translationX",
                        previous_x, touch_x);
                smileX.start();
                ObjectAnimator smileY = ObjectAnimator.ofFloat(iv_smile, "translationY",
                        previous_y, touch_y);
                smileY.start();
                mVibe.vibrate(50);
                previous_x = touch_x;
                previous_y = touch_y;
                break;
            case MotionEvent.ACTION_UP:
                break;




        }
        return false;
    }

}
