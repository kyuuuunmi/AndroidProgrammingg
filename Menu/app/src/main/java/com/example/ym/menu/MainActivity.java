package com.example.ym.menu;

import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnLongClickListener, ActionMode.Callback {

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.TextView01);
        text.setOnLongClickListener(this);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.apple:
                Toast.makeText(this, "사과", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grape:
                Toast.makeText(this, "포도",  Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(this, "바나나", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.context_action_mode, menu);

        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        TextView text1 = (TextView)findViewById(R.id.TextView01);
        switch (item.getItemId()){
            case R.id.bg_red:
                text1.setBackgroundColor(Color.RED);
                mode.finish();
                return true;
            case R.id.bg_green:
                text1.setBackgroundColor(Color.GREEN);
                mode.finish();
                return true;
            case R.id.bg_blue:
                text1.setBackgroundColor(Color.BLUE);
                mode.finish();
                return true;
            default: return false;

        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

        mActionMode = null;
    }

    @Override
    public boolean onLongClick(View v) {
        if(mActionMode!=null){
            return false;
        }

        mActionMode = this.startActionMode(this);
        v.setSelected(true);
        return true;
    }
}
