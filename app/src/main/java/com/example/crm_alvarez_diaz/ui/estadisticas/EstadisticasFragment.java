package com.example.crm_alvarez_diaz.ui.estadisticas;

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

import com.example.crm_alvarez_diaz.R;

public class EstadisticasFragment extends Fragment {

    private EstadisticasViewModel estadisticasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        estadisticasViewModel = new ViewModelProvider(this).get(EstadisticasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        return root;
    }
}