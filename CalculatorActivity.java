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

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextnumber1;
    EditText editTextnumber2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    Button btnSave;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // находим элементы
        editTextnumber1 = (EditText) findViewById(R.id.editTextNumber1);
        editTextnumber2 = (EditText) findViewById(R.id.editTextNumber2);

        btnAdd = (Button) findViewById(R.id.buttonPlus);
        btnSub = (Button) findViewById(R.id.buttonMinus);
        btnMult = (Button) findViewById(R.id.buttonMultiply);
        btnDiv = (Button) findViewById(R.id.buttonDevision);

        btnSave = (Button) findViewById(R.id.buttonSaveCalculator);

        tvResult = (TextView) findViewById(R.id.textViewResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(editTextnumber1.getText().toString())
                || TextUtils.isEmpty(editTextnumber2.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Есть незаполненные поля", Toast.LENGTH_SHORT).show();
            return;
        }
        // читаем EditText и заполняем переменные числами
        num1 = Float.parseFloat(editTextnumber1.getText().toString());
        num2 = Float.parseFloat(editTextnumber2.getText().toString());

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.buttonPlus:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.buttonMinus:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.buttonMultiply:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.buttonDevision:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // формируем строку вывода
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        // формируем строку вывода
        String output = num1 + " " + oper + " " + num2 + " = " + result;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", output);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
