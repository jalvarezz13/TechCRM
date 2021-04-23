package com.example.crm_alvarez_diaz;

public class Usuario {
    private String nombre;
    private String usuario;
    private String tlf;
    private String email;
    private String password;
    public Usuario (String name, String username, String phone, String email, String pass){
        nombre = name;
        usuario = username;
        tlf = phone;
        this.email= email;
        password = pass;
    }

    public String getNombre(){return nombre;}

    public String getUsuario() {return usuario;}

    public String getTlf() {return tlf;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}
}
