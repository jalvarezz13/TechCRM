package com.example.crm_alvarez_diaz;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdaptadorListaCliente extends RecyclerView.Adapter<AdaptadorListaCliente.ClienteViewHolder> {
    private ArrayList<Cliente> clientes;

    public class ClienteViewHolder extends RecyclerView.ViewHolder {
        private TextView lblNombre;
        private TextView lblTelefono;
        private TextView lblEmail;
        private TextView lblUltimaConexion;
        private ImageView imContacto;
        private ImageView imFav;
        private ImageButton btnLlamar;
        private ImageButton btnWhatsApp;
        private ImageButton btnCorreo;

        public ClienteViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lblNombreCliente);
            lblTelefono = view.findViewById(R.id.lblTelefonoCliente);
            lblEmail = view.findViewById(R.id.lblCorreoCliente);
            lblUltimaConexion = view.findViewById(R.id.lblUltConexionCliente);
            imContacto = view.findViewById(R.id.imCliente);
            imFav = view.findViewById(R.id.imFavCliente);
            btnLlamar = view.findViewById(R.id.btnLlamarCliente);
            btnWhatsApp = view.findViewById(R.id.btnWhatsAppCliente);
            btnCorreo = view.findViewById(R.id.btnCorreoCliente);
        }
    }

    public AdaptadorListaCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_cliente, parent, false);
        return new ClienteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        Cliente cliente = clientes.get(position);
        holder.lblNombre.setText(cliente.getName());
        holder.lblTelefono.setText(cliente.getPhone());
        holder.lblEmail.setText(cliente.getEmail());
        holder.lblUltimaConexion.setText("Ult. conexión: " + cliente.getUltConexion());

        if (cliente.getNumPedidos() >= 10)
            holder.imFav.setVisibility(View.VISIBLE);
        else
            holder.imFav.setVisibility(View.INVISIBLE);

        holder.imContacto.setImageResource(R.drawable.avatar);

        holder.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.llamar(cliente.getPhone(), holder.btnLlamar.getContext());
                holder.lblUltimaConexion.setText("Ult. conexión: " +  android.text.format.DateFormat.format("dd/MM/yyyy hh:mm:ss", new java.util.Date()));
            }
        });

        holder.btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.whatsapp(cliente.getPhone(), holder.btnWhatsApp.getContext());
                holder.lblUltimaConexion.setText("Ult. conexión: " +  android.text.format.DateFormat.format("dd/MM/yyyy hh:mm:ss", new java.util.Date()));
            }
        });

        holder.btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.correo(cliente.getEmail(), holder.btnCorreo.getContext());
                holder.lblUltimaConexion.setText("Ult. conexión: " +  android.text.format.DateFormat.format("dd/MM/yyyy hh:mm:ss", new java.util.Date()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }
}