package com.example.agendasharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
    }

    public void grabar(View view){
        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(nombre,datos);
        editor.apply();
        Toast.makeText(this, "Datos grabados",Toast.LENGTH_LONG).show();
    }

    public void recuperar(View view){
        String nombre = et1.getText().toString();
        SharedPreferences prefe = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String d = prefe.getString(nombre,"");
        if(d.length()==0){
            Toast.makeText(this,"No existe dicho nombre en la agenda",Toast.LENGTH_LONG).show();
        }
        else{
            et2.setText(d);
        }
    }

}
