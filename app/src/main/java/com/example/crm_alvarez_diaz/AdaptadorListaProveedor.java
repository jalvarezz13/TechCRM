package com.example.crm_alvarez_diaz;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
        private TextView lblDeuda;
        private ImageView imProveedor;
        private ImageView imFav;

        public ProveedorViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lblNombreProveedor);
            lblTelefono = view.findViewById(R.id.lblTelefonoProveedor);
            lblEmail = view.findViewById(R.id.lblCorreoProveedor);
            lblDeuda = view.findViewById(R.id.lblDeudaProveedor);
            imProveedor = view.findViewById(R.id.imProveedor);
            imFav = view.findViewById(R.id.imFavProveedor);
        }
    }

    public AdaptadorListaProveedor(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public ProveedorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_proveedores, parent, false);
        return new ProveedorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProveedorViewHolder holder, int position) {
        Proveedor proveedor = proveedores.get(position);
        holder.lblNombre.setText(proveedor.getName());
        holder.lblTelefono.setText(proveedor.getPhone());
        holder.lblEmail.setText(proveedor.getEmail());
        holder.lblDeuda.setText("Deuda: " + Double.toString(proveedor.getDeuda()) + "€ ");

        if (proveedor.getDeuda() > 0) {
            holder.lblDeuda.setTextColor(Color.parseColor("#ffff0000"));
            holder.lblDeuda.setText("Deuda: -" + Double.toString(proveedor.getDeuda()) + "€ ");
        }

        if (proveedor.getNumPedidos() >= 10)
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