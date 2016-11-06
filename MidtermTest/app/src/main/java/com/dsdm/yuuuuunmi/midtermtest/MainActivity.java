package com.dsdm.yuuuuunmi.midtermtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback{

    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_pinewheel = (ImageView)findViewById(R.id.pinwheel01);

        iv_pinewheel.setOnLongClickListener(this);

    }


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
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        switch (item.getItemId()){
            case R.id.item_red:
                layout.setBackgroundColor(Color.RED);
                mode.finish();
                return true;
            case R.id.item_green:
                layout.setBackgroundColor(Color.GREEN);
                mode.finish();
                return true;
            case R.id.item_blue:
                layout.setBackgroundColor(Color.BLUE);
                mode.finish();
                return true;
            default:
                return false;
        }

    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionMode=null;

    }

    @Override
    public boolean onLongClick(View v) {
        if(actionMode!=null){
            return false;
        }
        actionMode=this.startActionMode(this);
        v.setSelected(true);
        return false;
    }






/*


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fruitmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.apple:
                Toast.makeText(this, "apple", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grape:
                Toast.makeText(this, "grape", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(this, "banana", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
*/



}
/*      Listener

public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()){

            case R.id.checkBox1:
                if(checked)
                    Toast.makeText(getApplicationContext(),"고기선택", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"고기선택 해제", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox2:
                if(checked)
                    Toast.makeText(getApplicationContext(),"치즈선택", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"치즈 선택 해제", Toast.LENGTH_SHORT).show();
                break;
        }

    }*/
/* pinewheel
        ImageView iv_pinewheel = (ImageView)findViewById(R.id.pinwheel01);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_pinewheel, "rotation", 360);

        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
*/
