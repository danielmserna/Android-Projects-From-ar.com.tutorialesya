package com.example.mailsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private ListView lvw1;
    private ArrayAdapter vectorAdapter;
    private Vector<String> vector_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        vector_list = new Vector<String>();
        Set<String> set = new HashSet<String>();
        set.addAll(vector_list);
        lvw1 = findViewById(R.id.lv);
        SharedPreferences prefe = getSharedPreferences("mails",Context.MODE_PRIVATE);
    }
    public void salir (View view){
        finish();
    }
    public void guardar(View view){
        if(!et1.getText().toString().isEmpty()){
            vector_list.add(et1.getText().toString());
            SharedPreferences prefe = getSharedPreferences("mails",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefe.edit();
            editor.putString("mails",et1.getText().toString());
            editor.commit();

            Toast.makeText(this,"Ingresado !",Toast.LENGTH_LONG).show();
        }
        else{
            et1.setError("Ingrese e-mail !");
        }
    }
    public void consultar(View view){

        SharedPreferences prefe = getSharedPreferences("mails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefe.edit();
        Set<String> set = new HashSet<String>();
        editor.putStringSet("mails",set);
        editor.commit();
        vectorAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,vector_list);
        lvw1.setAdapter(vectorAdapter);

    }
}
