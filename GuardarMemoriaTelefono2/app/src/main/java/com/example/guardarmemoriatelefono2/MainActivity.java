package com.example.guardarmemoriatelefono2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
    }

    public void establecer(View view){
        String nombrearchivo = et1.getText().toString();
        nombrearchivo = nombrearchivo.replace('/','-');
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombrearchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();
        } catch(IOException e){}
        Toast.makeText(this,"Fecha Ingresada Éxitosamente",Toast.LENGTH_LONG).show();
        et1.setText("");
        et2.setText("");
    }

    public void recuperar(View view){
        String nombrearchivo = et1.getText().toString();
        nombrearchivo = nombrearchivo.replace('/','-');
        boolean encontrado = false;
        String[] archivos = fileList();
        for (int f = 0; f<archivos.length; f++ ){
            if(nombrearchivo.equals(archivos[f])){
                encontrado = true;
            }
        }
        if(encontrado==true){
            try{
                InputStreamReader archivo = new InputStreamReader(openFileInput(nombrearchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while(linea != null){
                    todo = todo+ linea+ "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);

            }catch (IOException e){}
        }
        else{
            Toast.makeText(this,"No hay datos grabados para dicha fecha",Toast.LENGTH_LONG).show();
            et2.setText("");
        }

    }

}
