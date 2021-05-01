package com.example.crm_alvarez_diaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Bienvenido extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPass;
    private ConectorBD conectorBD;
    private Button iniciarSesion;
//    private TextView usernameMenu;
//    private TextView emailMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        conectorBD = new ConectorBD(this);
        txtUsername = findViewById(R.id.usernameInput);
        txtPass = findViewById(R.id.passwordInput);
        iniciarSesion = findViewById(R.id.btnIniciarSesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passDB = "";
                conectorBD.abrir();
                passDB = conectorBD.autenticarUsuario(txtUsername.getText().toString());
                if (txtPass.getEditableText().toString().equals(passDB)) {
//                    usernameMenu = findViewById(R.id.lblNombreMenu);
//                    emailMenu = findViewById(R.id.lblEmailMenu);
//                    usernameMenu.setText(txtUsername.getText().toString());
                    startActivity(new Intent(Bienvenido.this, MainActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "El usuario o la contraseña son incorrectos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void oyente_btnRegistrarAqui(View view) {
        startActivity(new Intent(Bienvenido.this, Registro.class));
    }
}