package com.example.crm_alvarez_diaz;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorListaTarea extends RecyclerView.Adapter<AdaptadorListaTarea.TareaViewHolder> {
    private ArrayList<Tarea> tareas;

    public class TareaViewHolder extends RecyclerView.ViewHolder {
        private TextView dia;
        private TextView mes;
        private TextView ano;
        private TextView titulo;
        private TextView descripcion;
        private TextView hora;
        private LinearLayout layout;

        public TareaViewHolder(View view) {
            super(view);
            dia = view.findViewById(R.id.txtDia);
            mes = view.findViewById(R.id.txtMes);
            ano = view.findViewById(R.id.txtAño);
            titulo = view.findViewById(R.id.txtTitulo);
            descripcion = view.findViewById(R.id.txtDescripcion);
            hora = view.findViewById(R.id.txtHora);
            layout = view.findViewById(R.id.layoutFecha);
        }
    }

    public AdaptadorListaTarea(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_tarea, parent, false);
        return new TareaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        holder.dia.setText(tarea.getDia());
        holder.mes.setText(tarea.getMes());
        holder.ano.setText(tarea.getAno());
        holder.titulo.setText(tarea.getTitulo());
        holder.descripcion.setText(tarea.getDescripcion());
        holder.hora.setText("Hora: " + tarea.getHora() + " horas.");

        switch (tarea.getTipo()) {
            case 1:
                holder.dia.setBackgroundColor(Color.argb(255, 3, 155, 229));
                holder.mes.setBackgroundColor(Color.argb(255, 3, 155, 229));
                holder.ano.setBackgroundColor(Color.argb(255, 3, 155, 229));
                holder.layout.setBackgroundColor(Color.argb(255, 3, 155, 229));
                break;
            case 2:
                holder.dia.setBackgroundColor(Color.argb(255, 51, 182, 121));
                holder.mes.setBackgroundColor(Color.argb(255, 51, 182, 121));
                holder.ano.setBackgroundColor(Color.argb(255, 51, 182, 121));
                holder.layout.setBackgroundColor(Color.argb(255, 51, 182, 121));
                break;
            case 3:
                holder.dia.setBackgroundColor(Color.argb(255, 142, 36, 170));
                holder.mes.setBackgroundColor(Color.argb(255, 142, 36, 170));
                holder.ano.setBackgroundColor(Color.argb(255, 142, 36, 170));
                holder.layout.setBackgroundColor(Color.argb(255, 142, 36, 170));
                break;
            case 4:
                holder.dia.setBackgroundColor(Color.argb(255, 246, 192, 38));
                holder.mes.setBackgroundColor(Color.argb(255, 246, 192, 38));
                holder.ano.setBackgroundColor(Color.argb(255, 246, 192, 38));
                holder.layout.setBackgroundColor(Color.argb(255, 246, 192, 38));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }
}