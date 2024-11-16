package com.example.firstdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
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

    public void alta(View v){

        if((et1.getText().toString().trim().equalsIgnoreCase(""))||(et2.getText().toString().trim().equalsIgnoreCase(""))||(et3.getText().toString().trim().equalsIgnoreCase(""))){
            if(et1.getText().toString().trim().equalsIgnoreCase("")){
                et1.setError("Ingrese un código válido");
            }
            if(et2.getText().toString().trim().equalsIgnoreCase("")){
                et2.setError("Ingrese una descripción válida");
            }
            if(et3.getText().toString().trim().equalsIgnoreCase("")){
                et3.setError("Ingrese un precio válido");
            }
        }
        else {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                String cod = et1.getText().toString();
                String descript = et2.getText().toString().toUpperCase();
                String price = et3.getText().toString();
            if(CheckIsDataAlreadyInDBorNot("Articulos","Codigo",cod)){
                et1.setError("Ya existe un artículo con este código, se sugiere usar el "+ (getProfileCount()+1));
            }else {
                ContentValues registro = new ContentValues();
                registro.put("Codigo", cod);
                registro.put("Descripcion", descript);
                registro.put("Precio", price);
                bd.insert("Articulos", null, registro);
                bd.close();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void consultaporcodigo(View view){

        if(et1.getText().toString().trim().equalsIgnoreCase("")){
            et1.setError("Ingrese un código válido");
        }else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cod = et1.getText().toString();
            Cursor fila = bd.rawQuery("select Descripcion,Precio from Articulos where Codigo=" + cod, null);
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_LONG).show();
            }
            bd.close();
        }
    }

    public void consultapordescripcion(View view){

        if(et2.getText().toString().trim().equalsIgnoreCase("")){
            et2.setError("Ingrese una descripción válida");
        }else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String descript = et2.getText().toString().toUpperCase();
            Cursor fila = bd.rawQuery("select Codigo,Precio from Articulos where Descripcion='" + descript + "'", null);
            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0));
                et3.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_LONG).show();
            }
            bd.close();
        }
    }

    public void bajaporcodigo(View view){

        if(et1.getText().toString().trim().equalsIgnoreCase("")){
            et1.setError("Ingrese un código válido");
        }else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cod = et1.getText().toString();
            int cant = bd.delete("Articulos", "Codigo=" + cod, null);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            if (cant == 1) {
                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void modificar(View view){

        if((et1.getText().toString().trim().equalsIgnoreCase(""))||(et2.getText().toString().trim().equalsIgnoreCase(""))||(et3.getText().toString().trim().equalsIgnoreCase(""))){
            if(et1.getText().toString().trim().equalsIgnoreCase("")){
                et1.setError("Ingrese un código válido");
            }
            if(et2.getText().toString().trim().equalsIgnoreCase("")){
                et2.setError("Ingrese una descripción válida");
            }
            if(et3.getText().toString().trim().equalsIgnoreCase("")){
                et3.setError("Ingrese un precio válido");
            }
        }else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cod = et1.getText().toString();
            String descript = et2.getText().toString().toUpperCase();
            String price = et3.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("Codigo", cod);
            registro.put("Descripcion", descript);
            registro.put("Precio", price);
            int cant = bd.update("Articulos", registro, "Codigo=" + cod, null);
            bd.close();
            if (cant == 1) {
                Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No existe un artículo con el código ingresado", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void salir(View view){
        finish();
    }

    public void x1(View view){
        et1.setText("");
    }

    public void x2(View view){
        et2.setText("");
    }

    public void x3(View view){
        et3.setText("");
    }

    public boolean CheckIsDataAlreadyInDBorNot(String tablename, String dbfield, String fieldValue){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Query = " select * from " + tablename + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = bd.rawQuery(Query,null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public long getProfileCount(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(bd,"Articulos");
        bd.close();
        return count;
    }

}
