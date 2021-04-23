package com.example.crm_alvarez_diaz;

public class Contacto {
    private String nombre;
    private int npedidos;
    private String telefono;
    private int tipo; //0:familia; 1:amigo;2:trabajo
    private String email;
    private String direccion;

    public Contacto(String nom, int npedidos, String tel, int tip, String em, String dir) {
        nombre = nom;
        this.npedidos= npedidos;
        telefono = tel;
        tipo = tip;
        email = em;
        direccion = dir;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNpedidos(){return npedidos;}

    public String getTelefono() {
        return telefono;
    }

    public int getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }
}