package com.example.a1erasegundaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irASegundaActivity(View view){
        Intent i = new Intent(this,SegundaActivity.class);
        startActivity(i);
    }
    public void salir1(View view){
        finish();
    }

}
