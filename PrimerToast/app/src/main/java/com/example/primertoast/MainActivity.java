package com.example.primertoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        num = (int)(Math.random()*100001);
        String cadena = String.valueOf(num);
        Toast notificacion = Toast.makeText(this,cadena,Toast.LENGTH_LONG);
        notificacion.show();
    }

    public void controlar(View view){
        String valorIngresado = et.getText().toString();
        int numIng = Integer.parseInt(valorIngresado);
        if(numIng==num){
            Toast notificacion2 = Toast.makeText(this, "Muy bien, recordaste el valor ingresado.",Toast.LENGTH_LONG);
            notificacion2.show();
        }
        else{
            Toast notificacion3 = Toast.makeText(this, "Lo siento, ese no es el número.",Toast.LENGTH_LONG);
            notificacion3.show();
        }
    }

}
