package com.example.a2lessom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView) findViewById(R.id.textViewHistory);
        Button buttonCalculator = findViewById(R.id.buttonCalculator);
        Button buttonTriangle = findViewById(R.id.buttonTriangle);
        Button buttonDeposit = findViewById(R.id.buttonDeposit);




        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivityForResult(intent, CALCULATOR_REQUEST_CODE);
            }
        });


        buttonTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TriangleActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        buttonDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DepositActivity.class);
                startActivityForResult(intent, 1);


            }
        });

        }
    public static final int CALCULATOR_REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CALCULATOR_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("result");
            String currentValue = textViewResult.getText().toString();
            String newValue = result + "\n" + currentValue;
            textViewResult.setText(newValue);
        }
    }





    }