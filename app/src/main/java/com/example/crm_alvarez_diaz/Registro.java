package com.example.crm_alvarez_diaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private CheckBox cbTerminos;
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

        txtName = findViewById(R.id.ptNameClienteInput);
        txtUsername = findViewById(R.id.ptApellidoClienteInput);
        txtEmail = findViewById(R.id.ptCorreo);
        txtPhone = findViewById(R.id.ptTlf);
        txtPass = findViewById(R.id.ptPasswd);
        txtPassR = findViewById(R.id.ptRPasswd);
        cbTerminos = findViewById(R.id.cbTerms);

        conectorBD = new ConectorBD(this);
        registrar = findViewById(R.id.btnRegistry);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean puedeRegistrarse = true;
                String listaProblemas = "Por favor, revise los siguientes términos:";
                if (txtName.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Nombre y Apellidos' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtUsername.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Nombre de usuario' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtEmail.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Email' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtPhone.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Teléfono' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtPass.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Contraseña' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtPassR.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Repetir contraseña' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (!cbTerminos.isChecked()) {
                    listaProblemas += "\n- Debe aceptar nuestros terminos y condiciones para registrarse.";
                    puedeRegistrarse = false;
                }
                if (!txtPass.getEditableText().toString().equals(txtPassR.getEditableText().toString())) {
                    listaProblemas += "\n- Las contraseñas introducidas no coinciden.";
                    puedeRegistrarse = false;
                }


                if (puedeRegistrarse) {
                    conectorBD.abrir();
                    conectorBD.insertarUsuario(txtName.getText().toString(), txtUsername.getText().toString(), txtPhone.getText().toString(), txtEmail.getText().toString(), txtPass.getText().toString());
                    conectorBD.cerrar();
                    Toast.makeText(getBaseContext(), "USUARIO REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    txtName.setText("");
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPhone.setText("");
                    txtPass.setText("");
                    txtPassR.setText("");
                    cbTerminos.setChecked(false);
                    startActivity(new Intent(Registro.this, Bienvenido.class));
                } else {
                    Toast.makeText(getBaseContext(), listaProblemas, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}