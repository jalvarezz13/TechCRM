package com.example.crm_alvarez_diaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crm_alvarez_diaz.ui.proveedores.ProveedoresFragment;

public class AddProv extends AppCompatActivity {
    private Button atras;
    private Button addProv;
    private EditText txtEmpresa;
    private EditText txtTlf;
    private EditText txtEmail;
    private EditText txtDeuda;
    private EditText txtNpedidos;
    private ConectorBD conectorBD;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_proveedor);
        getSupportActionBar().hide();

        atras = (Button) findViewById(R.id.btnVolverProveedor);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtEmpresa = findViewById(R.id.ptEmpresaProvInput);
        txtEmail = findViewById(R.id.ptPhoneProvInput);
        txtTlf = findViewById(R.id.ptEmailProvInput);
        txtDeuda = findViewById(R.id.ptDeudaProvInput);
        txtNpedidos = findViewById(R.id.ptNpedidosProvInput);

        conectorBD = new ConectorBD(this);
        addProv = findViewById(R.id.btnAddProv);
        addProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean puedeRegistrarse = true;
                String listaProblemas = "Por favor, revise los siguientes términos:";
                if (txtEmpresa.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Empresa' no puede quedar vacío.";
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
                if (txtNpedidos.getText().toString().isEmpty()) {
                    listaProblemas += "\n- El campo 'Número de pedidos' no puede quedar vacío.";
                    puedeRegistrarse = false;
                }

                if (puedeRegistrarse) {
                    conectorBD.abrir();
                    conectorBD.insertarProveedor(txtEmpresa.getText().toString(), txtTlf.getText().toString(), txtEmail.getText().toString(), Double.parseDouble(txtDeuda.getText().toString()), Integer.parseInt(txtNpedidos.getText().toString()));
                    conectorBD.cerrar();
                    Toast.makeText(getBaseContext(), "PROVEEDOR AÑADIDO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    txtEmpresa.setText("");
                    txtEmail.setText("");
                    txtTlf.setText("");
                    txtDeuda.setText("");
                    txtNpedidos.setText("");
                    ProveedoresFragment.rellenarDatos();
                    onBackPressed();
                } else {
                    Toast.makeText(getBaseContext(), listaProblemas, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
