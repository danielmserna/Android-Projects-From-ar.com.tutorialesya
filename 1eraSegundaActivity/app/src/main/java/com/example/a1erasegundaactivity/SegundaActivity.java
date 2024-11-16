package com.example.a1erasegundaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }

    public void salir2(View view){
        finish();
    }
    public void irATerceraActivity(View view){
        Intent i2 = new Intent(this,TerceraActivityReal.class);
        startActivity(i2);
    }
}
