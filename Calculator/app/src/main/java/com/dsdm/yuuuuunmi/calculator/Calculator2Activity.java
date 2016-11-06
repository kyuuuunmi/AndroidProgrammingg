package com.dsdm.yuuuuunmi.calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator2Activity extends AppCompatActivity {


    EditText editOper1;
    EditText editOper2;
    TextView txtOper1;
    TextView txtOper2;
    TextView txtOperation;
    TextView txtResult;

    Button btnDiv;
    Button btnMul;
    Button btnSub;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);
        init();
    }

    private void init() {
        editOper1 = (EditText) findViewById(R.id.edt_opr1);
        editOper2 = (EditText) findViewById(R.id.edt_opr2);
        txtOper1 = (TextView) findViewById(R.id.cal2_txt_op1);
        txtOper2 = (TextView) findViewById(R.id.cal2_txt_op2);
        txtOperation = (TextView) findViewById(R.id.cal2_txt_operation);
        txtResult = (TextView) findViewById(R.id.cal2_txt_result);
        btnAdd = (Button) findViewById(R.id.cal2_btn_add);
        btnSub = (Button) findViewById(R.id.cal2_btn_sub);
        btnMul = (Button) findViewById(R.id.cal2_btn_mul);
        btnDiv = (Button) findViewById(R.id.cal2_btn_div);

        OperButtonListener operButtonListener = new OperButtonListener();

        btnAdd.setOnClickListener(operButtonListener);
        btnSub.setOnClickListener(operButtonListener);
        btnMul.setOnClickListener(operButtonListener);
        btnDiv.setOnClickListener(operButtonListener);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_quit:
                Log.i("menu", "quit_menu");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("종료 확인")
                        .setMessage("종료하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.putExtra("RESULT", getResultString());
                                setResult(200, intent);
                                Calculator2Activity.this.finish();
                            }
                        }).
                        setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });
                builder.show();

                return true;
            case R.id.menu_reset:
                Log.i("menu", "reset_menu");
                editOper1.setText("");
                editOper2.setText("");
                txtOper1.setText("");
                txtOper2.setText("");
                txtOperation.setText("");
                txtResult.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
    class OperButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            try {
                double oper1 = Double.parseDouble(editOper1.getText().toString());
                double oper2 = Double.parseDouble(editOper2.getText().toString());
                switch (v.getId()) {
                    case R.id.cal2_btn_add:
                        txtOper1.setText("" + oper1);
                        txtOper2.setText("" + oper2);
                        txtOperation.setText("+");
                        txtResult.setText("" + (oper1 + oper2));
                        break;
                    case R.id.cal2_btn_sub:
                        txtOper1.setText("" + oper1);
                        txtOper2.setText("" + oper2);
                        txtOperation.setText("-");
                        txtResult.setText("" + (oper1 - oper2));
                        break;
                    case R.id.cal2_btn_mul:
                        txtOper1.setText("" + oper1);
                        txtOper2.setText("" + oper2);
                        txtOperation.setText("*");
                        txtResult.setText("" + (oper1 * oper2));
                        break;
                    case R.id.cal2_btn_div:
                        txtOper1.setText("" + oper1);
                        txtOper2.setText("" + oper2);
                        txtOperation.setText("/");
                        txtResult.setText("" + (oper1 / oper2));
                        break;
                }


            } catch (NumberFormatException e) {
                Log.e("exception", "NumberFormatException");
            }

        }
    }

    // return Result
    public String getResultString() {
        String resultString = "";
        if (!(txtOper1.getText().toString().equals("") && txtOper2.getText().toString().equals(""))) {
            resultString = txtOper1.getText().toString()
                    + txtOperation.getText().toString()
                    + txtOper2.getText().toString()
                    + "=" + txtResult.getText().toString();

        }

        return resultString;
    }



}
