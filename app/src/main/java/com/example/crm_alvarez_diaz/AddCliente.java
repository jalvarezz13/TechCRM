package com.example.crm_alvarez_diaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddCliente extends AppCompatActivity {
    private Button atras;
    private Button addCliente;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEmail;
    private EditText txtTlf;
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

        txtNombre = findViewById(R.id.ptName);
        txtApellido = findViewById(R.id.ptApellido);
        txtEmail = findViewById(R.id.ptCorreo);
        txtTlf = findViewById(R.id.ptTlf);
        txtNpedidos = findViewById(R.id.ptNpedidos);

        conectorBD = new ConectorBD(this);
        addCliente = findViewById(R.id.btnRegistry);
        addCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean puedeRegistrarse = true;
                String listaProblemas = "Por favor, revise los siguientes términos:";
                if (txtNombre.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Nombre' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }
                if (txtApellido.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo '1er Apellido' no puede quedar vacío.";
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

                if (puedeRegistrarse) {
                    conectorBD.abrir();
                    conectorBD.insertarUsuario(txtNombre.getText().toString(), txtApellido.getText().toString(),txtEmail.getText().toString(), txtTlf.getText().toString(), txtNpedidos.getText().toString());
                    conectorBD.cerrar();
                    Toast.makeText(getBaseContext(), "CLIENTE AÑADIDO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtEmail.setText("");
                    txtTlf.setText("");
                    txtNpedidos.setText("");
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), listaProblemas, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

