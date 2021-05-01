package com.example.crm_alvarez_diaz.ui.clientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crm_alvarez_diaz.AdaptadorListaCliente;
import com.example.crm_alvarez_diaz.AddCliente;
import com.example.crm_alvarez_diaz.Cliente;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClientesFragment extends Fragment {

    private ClientesViewModel clientesViewModel;

    public static ArrayList<Cliente> clientes;
    public static RecyclerView lstContactos;
    private AdaptadorListaCliente adaptador;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel = new ViewModelProvider(this).get(ClientesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clientes, container, false);


        //Obtener una referencia a la lista gráfica
        lstContactos = root.findViewById(R.id.lstClientesUI);
        //Crear la lista de contactos y añadir algunos datos de prueba
        clientes = new ArrayList<Cliente>();
        //Método que rellena el array con datos de prueba
        rellenarDatosPrueba();
//        ordenarContactos();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstContactos.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaCliente(clientes);
        lstContactos.setAdapter(adaptador);

        lstContactos.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        return root;
    }

    public void rellenarDatosPrueba() {
        clientes.add(new Cliente("María Rodríguez", "234 123 411", "mariarodriguez@correo.com", 10));
        clientes.add(new Cliente("José Pérez", "234 234 234", "joseperez@correo.com", 8));
        clientes.add(new Cliente("José Ruíz", "545 342 455", "joseruiz@correo.com", 11));
        clientes.add(new Cliente("Carmen López", "666 433 566", "carmenlopez@correo.com", 12));
        clientes.add(new Cliente("María Pérez", "444 564 331", "mariapezar@correo.com", 11));
        clientes.add(new Cliente("José García", "233 223 411", "josegarcia@correo.com", 4));
        clientes.add(new Cliente("José Ruíz", "211 234 234", "joseruiz@correo.com", 6));
        clientes.add(new Cliente("Carmen Ruíz", "544 442 425", "carmenrodriguez@correo.com", 13));
        clientes.add(new Cliente("Carmen Rodríguez", "623 453 335", "carmenrodriguez@correo.com", 5));
        clientes.add(new Cliente("María García", "432 456 331", "mariagarcia@correo.com", 8));
    }

    public void ordenarContactos() {
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return new Integer(c2.getNumPedidos()).compareTo(new Integer(c1.getNumPedidos()));
            }
        });
    }

    public void oyente_btnAddCliente(View view){

    }

}