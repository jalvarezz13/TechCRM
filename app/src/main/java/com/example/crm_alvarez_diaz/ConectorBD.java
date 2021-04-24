package com.example.crm_alvarez_diaz;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        if (db != null)
            db.close();
    }

    /*inserta un usuario en la BD*/
    public void insertarUsuario(String name, String username, String phone, String email, String pass) {
        String consulta = "INSERT INTO Usuarios (name, username, phone, email, pass) VALUES('" + name + "', '" + username + "', '" + phone + "', '" + email + "', '" + pass + "')";
        Log.d("dbconsulta", consulta);
        db.execSQL(consulta);
    }

    public String autenticarUsuario(String username) {
        Cursor c = db.rawQuery("SELECT pass FROM Usuarios WHERE username='" + username + "'", null);
        c.moveToFirst();
        Log.d("dbconsulta", c.getString(0));
        return c.getString(0);
    }
}