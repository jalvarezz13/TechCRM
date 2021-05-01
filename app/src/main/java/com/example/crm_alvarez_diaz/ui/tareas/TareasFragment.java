package com.example.crm_alvarez_diaz.ui.tareas;

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

import com.example.crm_alvarez_diaz.AdaptadorListaProveedor;
import com.example.crm_alvarez_diaz.AdaptadorListaTarea;
import com.example.crm_alvarez_diaz.ConectorBD;
import com.example.crm_alvarez_diaz.Proveedor;
import com.example.crm_alvarez_diaz.R;
import com.example.crm_alvarez_diaz.Tarea;

import java.util.ArrayList;

import static com.example.crm_alvarez_diaz.ui.proveedores.ProveedoresFragment.lstProveedores;

public class TareasFragment extends Fragment {

    private TareasViewModel tareasViewModel;
    public static ArrayList<Tarea> tareas;
    public static RecyclerView lstTareas;
    private AdaptadorListaTarea adaptador;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tareasViewModel = new ViewModelProvider(this).get(TareasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tareas, container, false);

        lstTareas = root.findViewById(R.id.rvTareas);

        tareas = new ArrayList<Tarea>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        lstTareas.setLayoutManager(mLayoutManager);
        adaptador = new AdaptadorListaTarea(tareas);
        lstTareas.setAdapter(adaptador);

        rellenarDatos();
        lstTareas.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));
        return root;
    }

    private void rellenarDatos() {
        tareas.add(new Tarea("09", "MAYO", "2021", "Reunión con el equipo de NVIDA", "Evaluar viabilidad de venta de las RTX 3000 y fijar un stock fijo mensual.", "16:00", 1));
        tareas.add(new Tarea("22", "JUNIO", "2021", "Lanzamiento Ryzen 6000", "Hacer directo presentando los AMD Ryzen 6000.", "18:00", 2));
        tareas.add(new Tarea("31", "JUNIO", "2021", "Mudanza tienda a nave", "Comenzar a recoger cosas y preparar el transporte para la mudanza.", "16:00", 3));
        tareas.add(new Tarea("10", "JULIO", "2021", "Reunión con el equipo de Asus", "Cerrar contrato para la compra de los 100 nuevos portátiles Asus Rog.", "09:00", 1));
        tareas.add(new Tarea("01", "SEPTIEMBRE", "2021", "Fin del trimestre", "Calculo de ganancias y perdidas para enviar al gestor.", "09:00", 4));
        tareas.add(new Tarea("22", "SEPTIEMBRE", "2021", "Bajada del impuesto en informática", "Finaliza el impuesto del 25% en productos de informática.", "Todo el día.", 4));
        tareas.add(new Tarea("16", "OCTUBRE", "2021", "Lanzamiento de la nueva web", "Enviar al nuevo Community Manager toda la información sobre el nuevo hosting.", "00:00", 3));

    }
}