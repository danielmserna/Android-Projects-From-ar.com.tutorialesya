package com.example.distintosedittexts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
    }

    public void verificar(View view){

        String contrasena = et2.getText().toString();

        if(contrasena.length()<=7){
            Toast.makeText(this , "Contraseña debe tener al menos 8 caracteres", Toast.LENGTH_LONG).show();
        }

    }
}
