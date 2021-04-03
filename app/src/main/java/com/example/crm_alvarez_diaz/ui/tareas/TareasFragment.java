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

import com.example.crm_alvarez_diaz.R;

public class TareasFragment extends Fragment {

    private TareasViewModel tareasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        tareasViewModel = new ViewModelProvider(this).get(TareasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tareas, container, false);
        return root;
    }
}