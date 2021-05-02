package com.example.crm_alvarez_diaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crm_alvarez_diaz.ui.clientes.ClientesFragment;

public class AddCliente extends AppCompatActivity {
    private Button atras;
    private Button addCliente;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEmail;
    private EditText txtTlf;
    private EditText txtNpedidos;
    private ConectorBD conectorBD;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_cliente);
        getSupportActionBar().hide();

        atras = (Button) findViewById(R.id.btnVolverCliente);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtNombre = findViewById(R.id.ptNameClienteInput);
        txtApellido = findViewById(R.id.ptApellidoClienteInput);
        txtEmail = findViewById(R.id.ptEmailClienteInput);
        txtTlf = findViewById(R.id.ptPhoneClienteInput);
        txtNpedidos = findViewById(R.id.ptNpedidosClienteInput);
        conectorBD = new ConectorBD(this);
        addCliente = findViewById(R.id.btnAddCliente);

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
                    listaProblemas += "\n- El campo 'Primer apellido' no puede quedar vacío.";
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
                if (txtNpedidos.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Número de pedidos' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }

                if (puedeRegistrarse) {
                    conectorBD.abrir();
                    conectorBD.insertarCliente(txtNombre.getText().toString() + " " + txtApellido.getText().toString(), txtTlf.getText().toString(), txtEmail.getText().toString(), Integer.parseInt(txtNpedidos.getText().toString()));
                    conectorBD.cerrar();
                    Toast.makeText(getBaseContext(), "CLIENTE AÑADIDO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtEmail.setText("");
                    txtTlf.setText("");
                    txtNpedidos.setText("");
                    ClientesFragment.rellenarDatos();
                    onBackPressed();
                } else {
                    Toast.makeText(getBaseContext(), listaProblemas, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

