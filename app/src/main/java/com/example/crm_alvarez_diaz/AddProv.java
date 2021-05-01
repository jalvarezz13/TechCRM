package com.example.crm_alvarez_diaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddProv extends AppCompatActivity {
    private Button atras;
    private Button addProv;
    private EditText txtEmpresa;
    private EditText txtTlf;
    private EditText txtEmail;
    private EditText txtDeuda;
    private EditText txtNpedidos;
    private ConectorBD conectorBD;

    public void addCliente(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_cliente);
        getSupportActionBar().hide();

        atras = (Button) findViewById(R.id.btnVolverCliente);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtEmpresa= findViewById(R.id.ptName);
        txtEmail = findViewById(R.id.ptCorreo);
        txtTlf = findViewById(R.id.ptTlf);
        txtDeuda = findViewById(R.id.ptDeuda);
        txtNpedidos = findViewById(R.id.ptNpedidos);

        conectorBD = new ConectorBD(this);
        addProv= findViewById(R.id.btnRegistry);
        addProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean puedeRegistrarse = true;
                String listaProblemas = "Por favor, revise los siguientes términos:";
                if (txtEmpresa.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Nombre' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtEmail.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Correo' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtTlf.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Teléfono' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtDeuda.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Deuda' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }

                if (puedeRegistrarse) {
                    conectorBD.abrir();
                    conectorBD.insertarUsuario(txtEmpresa.getText().toString(), txtTlf.getText().toString(),txtEmail.getText().toString(), txtDeuda.getText().toString(), txtNpedidos.getText().toString());
                    conectorBD.cerrar();
                    Toast.makeText(getBaseContext(), "CLIENTE AÑADIDO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    txtEmpresa.setText("");
                    txtEmail.setText("");
                    txtTlf.setText("");
                    txtDeuda.setText("");
                    txtNpedidos.setText("");
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), listaProblemas, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
