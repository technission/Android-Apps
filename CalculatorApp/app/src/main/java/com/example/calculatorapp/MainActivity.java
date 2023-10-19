package com.example.calculatorapp;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView symDivide, symMultiply, symAdd, symSubtract, setSym, equals, answer;
    private EditText num1, num2;
    boolean divides = false, multiplies = false, subtracts = false, adds = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        symDivide = findViewById(R.id.symDivide);
        symMultiply = findViewById(R.id.symMultiply);
        symAdd = findViewById(R.id.symAdd);
        symSubtract = findViewById(R.id.symSubtract);
        setSym = findViewById(R.id.setSym);
        equals = findViewById(R.id.equals);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        answer = findViewById(R.id.answer);

        //The code!
        symDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setSym.setText("%");
                divides = true;
                multiplies = false;
                adds = false;
                subtracts = false;
            }
        });

        symMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setSym.setText("x");
                multiplies = true;
                divides = false;
                adds = false;
                subtracts = false;
            }
        });

        symAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setSym.setText("+");
                adds = true;
                divides = false;
                multiplies = false;
                subtracts = false;
            }
        });

        symSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setSym.setText("-");
                subtracts = true;
                divides = false;
                multiplies = false;
                adds = false;

            }
        });

        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double number1 = Integer.parseInt(num1.getText().toString());
                double number2 = Integer.parseInt(num2.getText().toString());

                if (divides){
                    double divAns = number1/number2;
                    answer.setText(String.valueOf(divAns));
                }else if (multiplies){
                    double mulAns = number1*number2;
                    answer.setText(String.valueOf(mulAns));
                }else if (adds){
                    double addAns = number1+number2;
                    answer.setText(String.valueOf(addAns));
                }else if (subtracts) {
                    double subAns = number1-number2;
                    answer.setText(String.valueOf(subAns));
                }
            }
        });
    }
}