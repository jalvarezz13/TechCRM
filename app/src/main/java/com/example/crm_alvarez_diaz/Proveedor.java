package com.example.crm_alvarez_diaz;

public class Proveedor {
    private String name;
    private String phone;
    private String email;
    private double deuda;
    private int numPedidos;

    public Proveedor() {

    }

    public Proveedor(String name, String phone, String email, double deuda, int numPedidos) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deuda = deuda;
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

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }
}

