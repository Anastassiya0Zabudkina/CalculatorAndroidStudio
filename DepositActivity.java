package com.example.a2lessom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DepositActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTXT1;
    EditText editTXT2;
    EditText editTXT3;

    Button btnEQUELS;
    Button btnSave;

    TextView Res;

    String txt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        editTXT1 = (EditText) findViewById(R.id.editTextTextStart);
        editTXT2 = (EditText) findViewById(R.id.editTextProcent);
        editTXT3 = (EditText) findViewById(R.id.editTextTime);


        btnEQUELS = (Button) findViewById(R.id.buttonEquelsDeposit);
        btnSave = (Button) findViewById(R.id.buttonSaveDeposit);


        Res = (TextView) findViewById(R.id.textViewResultDeposit);

        btnEQUELS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double sum = 0;
        double result = 0;


        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(editTXT1.getText().toString())
                || TextUtils.isEmpty(editTXT2.getText().toString()) || TextUtils.isEmpty(editTXT3.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Есть незаполненные поля", Toast.LENGTH_SHORT).show();
            return;
        }
        num1 = Float.parseFloat(editTXT1.getText().toString());
        num2 = Float.parseFloat(editTXT2.getText().toString());
        num3 = Float.parseFloat(editTXT3.getText().toString());
        sum = num1;
        switch (v.getId()) {
            case R.id.buttonEquelsDeposit:
                for (int i = 1; i < num3 + 1; i++) {
                    sum += (sum * num2) / 100;
                }
                result = sum;
                break;
            default:
                break;
        }
        Res.setText("Депозит с начальным взносом " + num1 + " процентной ставкой " + num2 + "и количеством лет " + num3 + " = " + result);
        String output = "Депозит с начальным взносом " + num1 + " процентной ставкой " + num2 + "и количеством лет " + num3 + " = " + result;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", output);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
        // создаем новый Intent для возвращения результата

    }


}