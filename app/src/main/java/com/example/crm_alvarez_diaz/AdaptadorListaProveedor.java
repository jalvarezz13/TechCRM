package com.example.crm_alvarez_diaz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaProveedor extends RecyclerView.Adapter<AdaptadorListaProveedor.ProveedorViewHolder> {
    private ArrayList<Proveedor> proveedores;

    public class ProveedorViewHolder extends RecyclerView.ViewHolder {
        private TextView lblNombre;
        private TextView lblTelefono;
        private TextView lblEmail;
        private TextView lblDireccion;
        private ImageView imProveedor;
        private ImageView imFav;

        public ProveedorViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lblNombre);
            lblTelefono = view.findViewById(R.id.lblTelefono);
            lblEmail = view.findViewById(R.id.lblCorreoProveedor);
            lblDireccion = view.findViewById(R.id.lblUltConexion);
            imProveedor = view.findViewById(R.id.imCliente);
            imFav = view.findViewById(R.id.imFav);
        }
    }

    public AdaptadorListaProveedor(ArrayList<Proveedor> proveedores) {this.proveedores = proveedores;}

    @Override
    public ProveedorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_cliente, parent, false);
        return new ProveedorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProveedorViewHolder holder, int position) {
        Proveedor p = proveedores.get(position);
        holder.lblNombre.setText(p.getName());
        holder.lblTelefono.setText(p.getPhone());
        holder.lblEmail.setText(p.getEmail());
        holder.lblDireccion.setText(p.getAddres());

        if (p.getNumPedidos() >= 10)
            holder.imFav.setVisibility(View.VISIBLE);
        else
            holder.imFav.setVisibility(View.INVISIBLE);

        holder.imProveedor.setImageResource(R.drawable.building);
    }

    @Override
    public int getItemCount() {
        return proveedores.size();
    }
}