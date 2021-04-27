package com.example.crm_alvarez_diaz;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
    /**
     * Sentencia SQL para crear la tabla de Contactos
     */

    String sqlCrearUsuario = "CREATE TABLE Usuario(name TEXT, username TEXT, phone TEXT, email TEXT, pass TEXT)";
    String sqlCrearCliente = "CREATE TABLE Cliente(name TEXT, phone TEXT, email TEXT, ultConexion TEXT, numPedidos INTEGER)";
    String sqlCrearProveedor = "CREATE TABLE Proveedor(name TEXT, phone TEXT, email TEXT, deuda REAL, numPedidos INTEGER)";

    public SQLiteHelper(Context contexto, String nombreBD, SQLiteDatabase.CursorFactory factory, int versionBD) {
        super(contexto, nombreBD, factory, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(sqlCrearUsuario);
            db.execSQL(sqlCrearCliente);
            db.execSQL(sqlCrearProveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        try {
            // DELETE THE LAST VERSION
            db.execSQL("DROP TABLE IF EXISTS Usuario");
            db.execSQL("DROP TABLE IF EXISTS Cliente");
            db.execSQL("DROP TABLE IF EXISTS Proveedor");

            // CREATE NEW VERSION
            db.execSQL(sqlCrearUsuario);
            db.execSQL(sqlCrearCliente);
            db.execSQL(sqlCrearProveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
