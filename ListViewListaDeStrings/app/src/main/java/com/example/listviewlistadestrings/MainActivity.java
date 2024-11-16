package com.example.listviewlistadestrings;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tv;
    private ListView lv;
    private String[] pais = { "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay"};
    private String[] habitantes = { "40000000", "17000000", "6500000", "10000000", "30000000", "14000000", "183000000", "47000000", "29000000", "3500000" };
    private String[] capital={"Buenos Aires","Santiago","Asunción","Sucre/La Paz","Lima","Quito","Brasilia","Bogotá DC","Caracas","Montevideo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        lv = findViewById(R.id.listview);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pais);
        lv.setAdapter(adapter1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tv.setText("Población de "+ lv.getItemAtPosition(position) + " es " + habitantes[position] + ". Capital es " + capital[position]);
            }

        });
    }



}
