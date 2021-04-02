package com.example.crm_alvarez_diaz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaContactos extends
        RecyclerView.Adapter<AdaptadorListaContactos.ContactoViewHolder> {
    private ArrayList<Contacto> contactos;

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        private TextView lblNombre;
        private TextView lblTelefono;
        private ImageView imContacto;

        public ContactoViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lblNombre);
            lblTelefono = view.findViewById(R.id.lblTelefono);
            imContacto = view.findViewById(R.id.imContacto);
        }
    }

    public AdaptadorListaContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_lista, parent, false);
        return new ContactoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.lblNombre.setText(contactos.get(position).getNombre());
        holder.lblTelefono.setText(contactos.get(position).getTelefono());
        switch (contactos.get(position).getTipo()) {
            case 1: //Cargar imagen de contactos tipo "familia"
                holder.imContacto.setImageResource(R.drawable.avatar);
                break;
            case 2: //Cargar imagen de los contactos tipo "amigos"
                holder.imContacto.setImageResource(R.drawable.building);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
}