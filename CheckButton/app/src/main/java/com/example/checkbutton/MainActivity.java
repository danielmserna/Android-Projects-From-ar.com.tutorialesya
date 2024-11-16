package com.example.checkbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private EditText et1, et2;
    private CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textViewanswer);
        et1 = findViewById(R.id.value1);
        et2 = findViewById(R.id.value2);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
    }

    public void calcular(View view){
        String firstvalue = et1.getText().toString();
        String secondvalue = et2.getText().toString();
        int numberone = Integer.parseInt(firstvalue);
        int numbertwo = Integer.parseInt(secondvalue);

        if(cb1.isChecked()==true){
            int op = numberone + numbertwo;
            String resu = String.valueOf(op);
            tv1.setText(resu);
        }
        if(cb2.isChecked()==true){
            int op = numberone - numbertwo;
            String resu = String.valueOf(op);
            tv1.setText(resu);
        }
    }



}
