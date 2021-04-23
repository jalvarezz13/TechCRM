package com.example.crm_alvarez_diaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private Button atras;
    private Button registrar;
    private EditText txtName;
    private EditText txtUsername;
    private EditText txtPhone;
    private EditText txtEmail;
    private EditText txtPass;
    private EditText txtPassR;
    private ConectorBD conectorBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        atras = (Button) findViewById(R.id.btnVolverRegistro);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro.this, Bienvenido.class));
            }
        });

        txtName = findViewById(R.id.ptName);
        txtUsername = findViewById(R.id.ptUsername);
        txtEmail = findViewById(R.id.ptCorreo);
        txtPhone = findViewById(R.id.ptTlf);
        txtPass = findViewById(R.id.ptPasswd);
        txtPassR = findViewById(R.id.ptRPasswd);

        conectorBD = new ConectorBD(this);

        registrar = findViewById(R.id.btnRegistry);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conectorBD.abrir();
                conectorBD.insertarUsuario(txtName.getText().toString(), txtUsername.getText().toString(), txtPhone.getText().toString(), txtEmail.getText().toString(), txtPass.getText().toString());
                conectorBD.cerrar();
                Toast.makeText(getBaseContext(), "USUARIO REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

            }
        });

//        if (txtPass != txtPassR) {
//            Toast.makeText(getBaseContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
//        }
    }
}