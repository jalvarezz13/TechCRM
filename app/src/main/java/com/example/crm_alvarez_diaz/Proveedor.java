package com.example.crm_alvarez_diaz;

public class Proveedor {
    private String name;
    private String phone;
    private String email;
    private String address;
    private int numPedidos;

    public Proveedor(String name, String phone, String email, String addres, int numPedidos) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = addres;
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

    public String getAddres() {
        return address;
    }

    public void setAddress(String ultConexion) {
        this.address = address;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }
}

