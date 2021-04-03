package com.example.crm_alvarez_diaz;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ConectorBD {
    static final String NOMBRE_BD = "AgendaLocal";
    private UsuarioSQLiteHelper dbHelper;
    private SQLiteDatabase db;

    /*Constructor*/
    public ConectorBD(Context ctx) {
        dbHelper = new UsuarioSQLiteHelper(ctx, NOMBRE_BD, null, 1);
    }

    /*Abre la conexión con la base de datos*/
    public ConectorBD abrir() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    /*Cierra la conexión con la base de datos*/
    public void cerrar() {
        if (db != null) db.close();
    }

    /*inserta un contacto en la BD*/
    public void insertarContacto(String username, String pass) {
        String consultaSQL = "INSERT INTO contactos VALUES('" + username + "', '" + pass.hashCode() + "') ";
        db.execSQL(consultaSQL);
    }

    /*devuelve todos los contactos*/
    public Cursor listarUsuarios() {
        return db.rawQuery("SELECT * FROM Contactos", null);
    }
}