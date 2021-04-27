package com.example.crm_alvarez_diaz;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

        public ClienteViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lblNombreCliente);
            lblTelefono = view.findViewById(R.id.lblTelefonoCliente);
            lblEmail = view.findViewById(R.id.lblCorreoCliente);
            lblUltimaConexion = view.findViewById(R.id.lblUltConexionCliente);
            imContacto = view.findViewById(R.id.imCliente);
            imFav = view.findViewById(R.id.imFavCliente);
            btnLlamar = view.findViewById(R.id.btnLlamarCliente);
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
                String uri = "tel: " + cliente.getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                Log.d("btnControl", uri);
//                startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }
}