package com.example.visitarsitioweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class SitioWeb extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitio_web);
        wv = findViewById(R.id.webView);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("direccion");
        wv.loadUrl("http://" + dato);
    }

    public void salir(View view){
        finish();
    }
}
