package com.example.crm_alvarez_diaz.ui.clientes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crm_alvarez_diaz.AdaptadorListaContactos;
import com.example.crm_alvarez_diaz.Contacto;
import com.example.crm_alvarez_diaz.MainActivity;
import com.example.crm_alvarez_diaz.R;

import java.util.ArrayList;

public class ClientesFragment extends Fragment {

    private ClientesViewModel clientesViewModel;

    public static ArrayList<Contacto> contactos;
    public static RecyclerView lstContactos;
    private AdaptadorListaContactos adaptador;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel = new ViewModelProvider(this).get(ClientesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clientes, container, false);
        final TextView textView = root.findViewById(R.id.text_sld);
        clientesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //Obtener una referencia a la lista gráfica
        lstContactos = root.findViewById(R.id.lstProveedoresUI);
        //Crear la lista de contactos y añadir algunos datos de prueba
        contactos = new ArrayList<Contacto>();
        //Método que rellena el array con datos de prueba
        rellenarDatosPrueba();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstContactos.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaContactos(contactos);
        lstContactos.setAdapter(adaptador);

        return root;
    }



    public void rellenarDatosPrueba() {
        contactos.add(new Contacto("María Rodríguez", "234 123 411", 1, "mariarodriguez@correo.com", "C/Ronda, 10"));
        contactos.add(new Contacto("José Pérez", "234 234 234", 1, "joseperez@correo.com", "C/Huertas, 1"));
        contactos.add(new Contacto("José Ruíz", "545 342 455", 1, "joseruiz@correo.com", "C/Ancha, 7"));
        contactos.add(new Contacto("Carmen López", "666 433 566", 1, "carmenlopez@correo.com", "C/Luz, 12"));
        contactos.add(new Contacto("María Pérez", "444 564 331", 1, "mariapezar@correo.com", "C/Ciudad, 11"));
        contactos.add(new Contacto("José García", "233 223 411", 1, "josegarcia@correo.com", "C/Darro, 4"));
        contactos.add(new Contacto("José Ruíz", "211 234 234", 1, "joseruiz@correo.com", "C/Ronda, 6"));
        contactos.add(new Contacto("Carmen Ruíz", "544 442 425", 1, "carmenrodriguez@correo.com", "C/Principal, 13"));
        contactos.add(new Contacto("Carmen Rodríguez", "623 453 335", 1, "carmenrodriguez@correo.com", "C/Rodero, 5"));
        contactos.add(new Contacto("María García", "432 456 331", 1, "mariagarcia@correo.com", "C/Paseo, 8"));
    }
}