package com.example.crm_alvarez_diaz.ui.proveedores;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.crm_alvarez_diaz.AdaptadorListaProveedor;
import com.example.crm_alvarez_diaz.AddProv;
import com.example.crm_alvarez_diaz.Cliente;
import com.example.crm_alvarez_diaz.ConectorBD;
import com.example.crm_alvarez_diaz.Proveedor;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProveedoresFragment extends Fragment {

    private ProveedoresViewModel proveedoresViewModel;
    public static ConectorBD conectorBD;
    public static ArrayList<Proveedor> proveedores;
    public static RecyclerView lstProveedores;
    private AdaptadorListaProveedor adaptador;
    private ImageButton addProv;
    private ImageButton ordenarProv;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        proveedoresViewModel = new ViewModelProvider(this).get(ProveedoresViewModel.class);
        View root = inflater.inflate(R.layout.fragment_proveedores, container, false);

        addProv = root.findViewById(R.id.btnAddPro);
        ordenarProv = root.findViewById(R.id.btnSortProv);
        lstProveedores = root.findViewById(R.id.lstProveedoresUI);

        conectorBD = new ConectorBD(this.getContext());
        proveedores = new ArrayList<Proveedor>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstProveedores.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaProveedor(proveedores);
        lstProveedores.setAdapter(adaptador);

        rellenarDatos();
        lstProveedores.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        addProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(container.getContext(), AddProv.class));
            }
        });

        ordenarProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordenarProv();
            }
        });
        return root;
    }

    public static void rellenarDatos() {
        proveedores.removeAll(proveedores);
        conectorBD.abrir();
        Cursor c = conectorBD.obtenerProveedores();
        if (c.moveToFirst()) {
            do {
                Proveedor p1 = new Proveedor();
                p1.setName(c.getString(0));
                p1.setPhone(c.getString(1));
                p1.setEmail(c.getString(2));
                p1.setDeuda(c.getInt(3));
                p1.setNumPedidos(c.getInt(4));
                proveedores.add(p1);
            } while (c.moveToNext());
        }
        c.close();
        conectorBD.cerrar();
        lstProveedores.getAdapter().notifyDataSetChanged();

        proveedores.add(new Proveedor("ISP Informática", "954 564 321", "isp-inf@correo.com", 2357.56, 23));
        proveedores.add(new Proveedor("Intel España", "953 532 631", "soporte@intel.es", 0, 1));
        proveedores.add(new Proveedor("Soporte NVIDIA", "932 442 654", "info@nvidia.com", 1210.15, 12));
    }

    public void ordenarProv() {
        Collections.sort(proveedores, new Comparator<Proveedor>() {
            @Override
            public int compare(Proveedor o1, Proveedor o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        lstProveedores.getAdapter().notifyDataSetChanged();
    }
}