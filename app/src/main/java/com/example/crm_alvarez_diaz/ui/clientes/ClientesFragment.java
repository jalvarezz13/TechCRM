package com.example.crm_alvarez_diaz.ui.clientes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.crm_alvarez_diaz.ConectorBD;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClientesFragment extends Fragment {

    private ClientesViewModel clientesViewModel;
    public static ConectorBD conectorBD;
    public static ArrayList<Cliente> clientes;
    public static
    RecyclerView lstContactos;
    private AdaptadorListaCliente adaptador;
    private ImageButton addCliente;
    private ImageButton ordenarClientes;
    private boolean ordenado = false;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel = new ViewModelProvider(this).get(ClientesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clientes, container, false);

        addCliente = root.findViewById(R.id.btnAddCli);
        ordenarClientes = root.findViewById(R.id.btnSortClientes);
        lstContactos = root.findViewById(R.id.lstClientesUI);

        conectorBD = new ConectorBD(this.getContext());
        clientes = new ArrayList<Cliente>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstContactos.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaCliente(clientes);
        lstContactos.setAdapter(adaptador);

        rellenarDatos();
        lstContactos.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        addCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(container.getContext(), AddCliente.class));
            }
        });

        ordenarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordenarClientes();
            }
        });

        return root;
    }

    public static void rellenarDatos() {
        clientes.removeAll(clientes);
        conectorBD.abrir();
        Cursor c = conectorBD.obtenerClientes();
        if (c.moveToFirst()) {
            do {
                Cliente c1 = new Cliente();
                c1.setName(c.getString(0));
                c1.setPhone(c.getString(1));
                c1.setEmail(c.getString(2));
                c1.setUltConexion(c.getString(3));
                c1.setNumPedidos(c.getInt(4));
                clientes.add(c1);
            } while (c.moveToNext());
        }
        c.close();
        conectorBD.cerrar();
        lstContactos.getAdapter().notifyDataSetChanged();

        clientes.add(new Cliente("María Rodríguez", "234 123 411", "mariarodriguez@correo.com", 10, "29/03/2021 9:24:15"));
        clientes.add(new Cliente("José Pérez", "234 234 234", "joseperez@correo.com", 8));
        clientes.add(new Cliente("José Ruíz", "545 342 455", "joseruiz@correo.com", 11, "01/04/2021 12:36:05"));
        clientes.add(new Cliente("Carmen López", "666 433 566", "carmenlopez@correo.com", 12));
        clientes.add(new Cliente("María Pérez", "444 564 331", "mariapezar@correo.com", 11));
        clientes.add(new Cliente("José García", "233 223 411", "josegarcia@correo.com", 4, "15/04/2021 13:34:26"));
        clientes.add(new Cliente("José Ruíz", "211 234 234", "joseruiz@correo.com", 6));
        clientes.add(new Cliente("Carmen Ruíz", "544 442 425", "carmenrodriguez@correo.com", 13));
        clientes.add(new Cliente("Carmen Rodríguez", "623 453 335", "carmenrodriguez@correo.com", 5,"02/05/2021 18:05:01"));
        clientes.add(new Cliente("María García", "432 456 331", "mariagarcia@correo.com", 8,"10/01/2020 08:57:58"));
    }

    public void ordenarClientes() {
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        lstContactos.getAdapter().notifyDataSetChanged();
    }
}