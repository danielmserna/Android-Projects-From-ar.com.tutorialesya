package com.example.controlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        tv1 = findViewById(R.id.textView3);
        sp = findViewById(R.id.spinner);

        String[]opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        sp.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void button(View view){

        String numb1 = et1.getText().toString();
        String numb2 = et2.getText().toString();
        int num1 = Integer.parseInt(numb1);
        int num2 = Integer.parseInt(numb2);
        String selec= sp.getSelectedItem().toString();
        if(selec.equals("Sumar")){
            int suma = num1+num2;
            String resu = String.valueOf(suma);
            tv1.setText(resu);
        }
        else if (selec.equals("Restar")){
            int resta = num1-num2;
            String resu = String.valueOf(resta);
            tv1.setText(resu);
        }
        else if (selec.equals("Multiplicar")){
            int multiplic = num1*num2;
            String resu = String.valueOf(multiplic);
            tv1.setText(resu);
        }
        else if (selec.equals("Dividir")){
            int divis = num1/num2;
            String resu = String.valueOf(divis);
            tv1.setText(resu);
        }
    }

}
