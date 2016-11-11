package com.dsdm.yuuuuunmi.sujin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;

/**
 * Created by user on 2016-11-05.
 */
public class First extends Activity{
    @Override
    public void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_screen);

        Button tv = (Button) findViewById(R.id.opr1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button tv2 = (Button) findViewById(R.id.opr2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button tv3 = (Button) findViewById(R.id.oprX);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "작업을 수행할 때 사용하는 애플리케이션"), 0);
            }
        });
    }
}
