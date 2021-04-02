package com.example.crm_alvarez_diaz;

public class Contacto {
    private String nombre;
    private String telefono;
    public Contacto(String maría_rodríguez, String s, int i, String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
