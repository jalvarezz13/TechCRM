package com.example.crm_alvarez_diaz;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crm_alvarez_diaz.ui.clientes.ClientesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_clientes, R.id.nav_proveedores, R.id.nav_tareas, R.id.nav_estadisticas).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        ConectorBD conectorBD = new ConectorBD(this);
//        conectorBD.abrir();
//        conectorBD.insertarProveedor("ISP Informática", "954 564 321", "isp-inf@correo.com", 2357.56, 23);
//        conectorBD.insertarProveedor("Intel España", "953 532 631", "soporte@intel.es", 0, 1);
//        conectorBD.insertarProveedor("Soporte NVIDIA", "932 442 654", "info@nvidia.com", 1210.95, 12);
//        conectorBD.insertarCliente("María Rodríguez", "234 123 411", "mariarodriguez@correo.com", 10);
//        conectorBD.insertarCliente("José Pérez", "234 234 234", "joseperez@correo.com", 8);
//        conectorBD.insertarCliente("José Ruíz", "545 342 455", "joseruiz@correo.com", 11);
//        conectorBD.insertarCliente("Carmen López", "666 433 566", "carmenlopez@correo.com", 12);
//        conectorBD.insertarCliente("María Pérez", "444 564 331", "mariapezar@correo.com", 11);
//        conectorBD.insertarCliente("José García", "233 223 411", "josegarcia@correo.com", 4);
//        conectorBD.insertarCliente("José Ruíz", "211 234 234", "joseruiz@correo.com", 6);
//        conectorBD.insertarCliente("Carmen Ruíz", "544 442 425", "carmenrodriguez@correo.com", 13);
//        conectorBD.insertarCliente("Carmen Rodríguez", "623 453 335", "carmenrodriguez@correo.com", 5);
//        conectorBD.insertarCliente("María García", "432 456 331", "mariagarcia@correo.com", 8);
//        conectorBD.cerrar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            Log.d("LogCat", "Pulsó la opción de menú Acerca de...");
            //Se muestra una ventana de diálogo
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acerca de...");
            builder.setMessage("Aplicación creada por Javier Álvarez y Alberto Díaz para el trabajo sobre CRM de Gestión de Sistemas de Información");
            builder.setPositiveButton("OK", null);
            builder.create();
            builder.show();
        }
        return false;
    }

    public static void llamar(String number, Context contexto) {
        String uri = "tel: " + number;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        contexto.startActivity(intent);
    }

    public static void whatsapp(String number, Context contexto) {
        contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=34" + number)));
    }

    public static void correo(String receptor, Context contexto) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", receptor, null));
        contexto.startActivity(intent);
    }

}