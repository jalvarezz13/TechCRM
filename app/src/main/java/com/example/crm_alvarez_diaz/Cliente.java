package com.example.crm_alvarez_diaz;

public class Cliente {
    private String name;
    private String phone;
    private String email;
    private String ultConexion;
    private int numPedidos;

    public Cliente() {

    }

    public Cliente(String name, String phone, String email, int numPedidos) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ultConexion = "Nunca";
        this.numPedidos = numPedidos;
    }

    public Cliente(String name, String phone, String email, int numPedidos, String ultConexion) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ultConexion = ultConexion;
        this.numPedidos = numPedidos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltConexion() {
        return ultConexion;
    }

    public void setUltConexion(String ultConexion) {
        this.ultConexion = ultConexion;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }
}