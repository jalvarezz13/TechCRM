package com.example.crm_alvarez_diaz;

import java.util.Calendar;

public class Tarea {
    private String dia;
    private String mes;
    private String ano;
    private String titulo;
    private String descripcion;
    private String hora;
    private int tipo;


    public Tarea(String dia, String mes, String ano, String titulo, String descripcion, String hora, int tipo) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.hora = hora;
        this.tipo = tipo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
