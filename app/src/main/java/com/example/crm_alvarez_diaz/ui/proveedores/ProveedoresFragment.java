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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crm_alvarez_diaz.AdaptadorListaContactos;
import com.example.crm_alvarez_diaz.Contacto;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;

public class ProveedoresFragment extends Fragment {

    private ProveedoresViewModel proveedoresViewModel;
    public static ArrayList<Contacto> proveedores;
    public static RecyclerView lstProveedores;
    private AdaptadorListaContactos adaptador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proveedoresViewModel =
                new ViewModelProvider(this).get(ProveedoresViewModel.class);
        View root = inflater.inflate(R.layout.fragment_proveedores, container, false);
        final TextView textView = root.findViewById(R.id.text_sld);
        proveedoresViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //Obtener una referencia a la lista gráfica
        lstProveedores = root.findViewById(R.id.lstProveedoresUI);
        //Crear la lista de contactos y añadir algunos datos de prueba
        proveedores = new ArrayList<Contacto>();
        //Método que rellena el array con datos de prueba
        rellenarDatosPrueba();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstProveedores.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaContactos(proveedores);
        lstProveedores.setAdapter(adaptador);

        return root;
    }

    public void rellenarDatosPrueba() {
        proveedores.add(new Contacto("ISP Informática", "954 564 321", 2, "isp-inf@correo.com", "C/Arenas, 10"));
        proveedores.add(new Contacto("Intel España", "953 532 631", 2, "soporte@intel.es", "C/Rey Felipe VI, 1"));
        proveedores.add(new Contacto("Soporte NVIDIA", "932 442 654", 2, "soporte@intel.com", "C/Ancha, 7"));
    }

}