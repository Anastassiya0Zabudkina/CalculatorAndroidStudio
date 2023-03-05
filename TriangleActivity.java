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

public class TriangleActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTxt1;
    EditText editTxt2;
    EditText editTxt3;

    Button btnEquels;

    Button btnSave;

    TextView Result;

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        // находим элементы
        editTxt1 = (EditText) findViewById(R.id.editTexta);
        editTxt2 = (EditText) findViewById(R.id.editTextb);
        editTxt3 = (EditText) findViewById(R.id.editTextc);


        btnEquels = (Button) findViewById(R.id.buttonEquelsTriangle);

        btnSave = (Button) findViewById(R.id.buttonSaveTriangle);


        Result = (TextView) findViewById(R.id.textResult);

        btnEquels.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double p = 0;
        double result = 0;

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(editTxt1.getText().toString())
                || TextUtils.isEmpty(editTxt2.getText().toString()) || TextUtils.isEmpty(editTxt3.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Есть незаполненные поля", Toast.LENGTH_SHORT).show();
            return;
        }
        // читаем EditText и заполняем переменные числами
        num1 = Float.parseFloat(editTxt1.getText().toString());
        num2 = Float.parseFloat(editTxt2.getText().toString());
        num3 = Float.parseFloat(editTxt3.getText().toString());

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.buttonEquelsTriangle:
                p = (num1 + num2 + num3) / 2;
                result = Math.sqrt(p * (p - num1) * (p - num2) * (p - num3));
                break;
            default:
                break;
        }
        // формируем строку вывода
        Result.setText("Площадь треугольника со сторонами " + num1 + ", " + num2 + ", " + num3 + " = " + result);

        // формируем строку вывода
        String resultText = "Площадь треугольника со сторонами " + num1 + ", " + num2 + ", " + num3 + " = " + result;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", resultText);
                setResult(Activity.RESULT_OK, resultIntent);

                // Закрываем текущую Activity
                finish();
            }
        });

        // Отправляем результат в MainActivity

    }
}