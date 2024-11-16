package com.example.visitarsitioweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
    }

    public void visitar(View view){

        Intent i = new Intent(this,SitioWeb.class);
        i.putExtra("direccion",et1.getText().toString());
        startActivity(i);
    }
}
