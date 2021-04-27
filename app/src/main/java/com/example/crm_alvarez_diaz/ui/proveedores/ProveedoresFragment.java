package com.example.crm_alvarez_diaz.ui.proveedores;

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
import com.example.crm_alvarez_diaz.AdaptadorListaProveedor;
import com.example.crm_alvarez_diaz.Cliente;
import com.example.crm_alvarez_diaz.Proveedor;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;

public class ProveedoresFragment extends Fragment {

    private ProveedoresViewModel proveedoresViewModel;
    public static ArrayList<Proveedor> proveedores;
    public static RecyclerView lstProveedores;
    private AdaptadorListaProveedor adaptador;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        proveedoresViewModel = new ViewModelProvider(this).get(ProveedoresViewModel.class);
        View root = inflater.inflate(R.layout.fragment_proveedores, container, false);

        //Obtener una referencia a la lista gráfica
        lstProveedores = root.findViewById(R.id.lstProveedoresUI);
        //Crear la lista de contactos y añadir algunos datos de prueba
        proveedores = new ArrayList<Proveedor>();
        //Método que rellena el array con datos de prueba
        rellenarDatosPrueba();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstProveedores.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaProveedor(proveedores);
        lstProveedores.setAdapter(adaptador);

        lstProveedores.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        return root;
    }

    public void rellenarDatosPrueba() {
        proveedores.add(new Proveedor("ISP Informática", "954 564 321", "isp-inf@correo.com", 2357.56, 23));
        proveedores.add(new Proveedor("Intel España", "953 532 631", "soporte@intel.es", 0, 1));
        proveedores.add(new Proveedor("Soporte NVIDIA", "932 442 654", "info@nvidia.com", 1210.95, 12));
    }

}