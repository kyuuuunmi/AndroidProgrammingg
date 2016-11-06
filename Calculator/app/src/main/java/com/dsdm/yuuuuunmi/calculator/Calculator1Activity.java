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
import android.widget.TextView;

public class Calculator1Activity extends AppCompatActivity {

    TextView txtOper1;
    TextView txtOper2;
    TextView txtResult;

    Button btn[];
    Button btnDiv;
    Button btnMul;
    Button btnSub;
    Button btnAdd;
    Button btnEnter;

    final static int NEXT = 1;
    final static int BACK = 2;

    int enterState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1);

        init();
    }

    private void init() {
        btn = new Button[10];

        txtOper1 = (TextView) findViewById(R.id.txt_oper1);
        txtOper2 = (TextView) findViewById(R.id.txt_oper2);
        txtResult = (TextView) findViewById(R.id.txt_result);

        btn[0] = (Button) findViewById(R.id.btn0);
        btn[1] = (Button) findViewById(R.id.btn1);
        btn[2] = (Button) findViewById(R.id.btn2);
        btn[3] = (Button) findViewById(R.id.btn3);
        btn[4] = (Button) findViewById(R.id.btn4);
        btn[5] = (Button) findViewById(R.id.btn5);
        btn[6] = (Button) findViewById(R.id.btn6);
        btn[7] = (Button) findViewById(R.id.btn7);
        btn[8] = (Button) findViewById(R.id.btn8);
        btn[9] = (Button) findViewById(R.id.btn9);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);
        btnEnter = (Button) findViewById(R.id.btnEnter);

        NumButtonListener numButtonListener = new NumButtonListener();
        OperButtonListener operButtonListener = new OperButtonListener();

        for (Button btns : btn)
            btns.setOnClickListener(numButtonListener);

        btnAdd.setOnClickListener(operButtonListener);
        btnSub.setOnClickListener(operButtonListener);
        btnMul.setOnClickListener(operButtonListener);
        btnDiv.setOnClickListener(operButtonListener);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterState == NEXT) {
                    enterState = BACK;
                    btnEnter.setText("☜");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("RESULT", txtResult.getText().toString());
                    setResult(200, intent);
                    finish();
                }
            }
        });
        enterState = NEXT;
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
                                Calculator1Activity.this.finish();
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
                txtOper1.setText("");
                txtOper2.setText("");
                txtResult.setText("");
                enterState = NEXT;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    class NumButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String oper;
            TextView textView; // current focused textView

            if (enterState == NEXT) {
                oper = txtOper1.getText().toString();
                textView = txtOper1;
            } else {
                oper = txtOper2.getText().toString();
                textView = txtOper2;
            }

            switch (v.getId()) {
                case R.id.btn0:
                    if (!textView.equals(""))
                        textView.setText(oper + "0");
                    break;
                case R.id.btn1:
                    textView.setText(oper + "1");
                    break;
                case R.id.btn2:
                    textView.setText(oper + "2");
                    break;
                case R.id.btn3:
                    textView.setText(oper + "3");
                    break;
                case R.id.btn4:
                    textView.setText(oper + "4");
                    break;
                case R.id.btn5:
                    textView.setText(oper + "5");
                    break;
                case R.id.btn6:
                    textView.setText(oper + "6");
                    break;
                case R.id.btn7:
                    textView.setText(oper + "7");
                    break;
                case R.id.btn8:
                    textView.setText(oper + "8");
                    break;
                case R.id.btn9:
                    textView.setText(oper + "9");
                    break;
            }
        }
    }

    class OperButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            try {

                double oper1 = Double.parseDouble(txtOper1.getText().toString());
                double oper2 = Double.parseDouble(txtOper2.getText().toString());
                switch (v.getId()) {
                    case R.id.btn_add:
                        txtResult.setText(oper1 + "+" + oper2 + "=" + (oper1 + oper2));
                        break;
                    case R.id.btn_sub:
                        txtResult.setText(oper1 + "-" + oper2 + "=" + (oper1 - oper2));
                        break;
                    case R.id.btn_mul:
                        txtResult.setText(oper1 + "*" + oper2 + "=" + (oper1 * oper2));
                        break;
                    case R.id.btn_div:
                        txtResult.setText(oper1 + "/" + oper2 + "=" + (oper1 / oper2));
                        break;
                }

            } catch (NumberFormatException e) {
                Log.e("exception", "NumberFormatException");
            }
        }
    }
}

