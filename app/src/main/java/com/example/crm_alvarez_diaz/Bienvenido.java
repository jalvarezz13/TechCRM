package com.example.crm_alvarez_diaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
    }
    public void oyente_btnRegistrarAqui(View view) {
        setContentView(R.layout.activity_registro);
    }
}