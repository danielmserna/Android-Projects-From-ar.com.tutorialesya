package com.example.chooseoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton r1, r2, r3, r4, r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textViewtotal);
        et1 = findViewById(R.id.editTextv1);
        et2 = findViewById(R.id.editTextv2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
    }

    public void calculate(View view){
        String valor1=et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        if(r1.isChecked()==true){
            int suma=nro1+nro2;
            String resu = String.valueOf(suma);
            tv1.setText(resu);
        }
        if(r2.isChecked()==true){
            int resta=nro1-nro2;
            String resu = String.valueOf(resta);
            tv1.setText(resu);
        }
        if(r3.isChecked()==true){
            int multi=nro1*nro2;
            String resu = String.valueOf(multi);
            tv1.setText(resu);
        }
        if(r4.isChecked()==true){
            int divi=nro1/nro2;
            String resu = String.valueOf(divi);
            tv1.setText(resu);
        }
        if(r5.isChecked()==true){
            int residuo=nro1%nro2;
            String resu = String.valueOf(residuo);
            tv1.setText(resu);
        }


    }


}
