package com.example.crm_alvarez_diaz.ui.estadisticas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.crm_alvarez_diaz.R;

public class EstadisticasFragment extends Fragment {

    private EstadisticasViewModel estadisticasViewModel;
    private Spinner spinner1;
    private Spinner spinner2;
    private TextView titulo;
    private ImageView imgGrafica;
    private TextView descripcion;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        estadisticasViewModel = new ViewModelProvider(this).get(EstadisticasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_estadisticas, container, false);

        titulo = root.findViewById(R.id.txtSeleccion);
        imgGrafica = root.findViewById(R.id.imgSeleccion);
        descripcion = root.findViewById(R.id.txtFeedback);

        spinner1 = root.findViewById(R.id.spinner1);
        spinner2 = root.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.spinner1, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getContext(), R.array.spinner2, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view1, int position1, long id1) {
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {
                        String seleccion = parent1.getItemAtPosition(position1).toString() + " - " + parent2.getItemAtPosition(position2).toString();
                        titulo.setText(seleccion);
                        switch (parent1.getItemAtPosition(position1).toString() + " - " + parent2.getItemAtPosition(position2).toString()) {
                            case "Ventas - Tarjeta Gráfica":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.ventas_grafica);
                                descripcion.setText("Las gráficas más demandadas por el mercado son las de la Serie 3300 y la serie Radeon de AMD. Por otro lado en el histórico de ventas se ve un descenso en las ventas de la serie 1000 y 2000.");
                                break;
                            case "Ventas - RAM":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.ventas_ram);
                                descripcion.setText("Las RAM más queridas por el público corresponde a las que tienen una capacidad de 16 GB vendiéndose en este caso más del tipo 'Sin RGB'. Sin embargo, para el caso de las memorias RAM de 64 GB de capacidad son más vendidas las del tipo 'RGB' debido a que son más buscadas en el mundo gaming.");
                                break;
                            case "Ventas - Procesadores":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.ventas_procesadores);
                                descripcion.setText("En los procesadores de gama de entrada y en general, en la mayoría AMD gana con diferencia a Intel, debido a que ofrece precios más ajustados.  Aunque en la gama media (i5 / Ryzen 5) las ventas están muy igualadas.");
                                break;
                            case "Ventas - Almacenamiento":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.ventas_almacenamiento);
                                descripcion.setText("En el mercado se ve una tendencia clara al abandono de los HDD en capacidades pequeñas, sustituyendolo por discos duros más rápidos como los SSD o los NvME. Sin embargo en estos último en capacidades mayores a las 2TB las ventas disminuyen radicalmente debido a su coste.");
                                break;
                            case "Compras - Tarjeta Gráfica":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.compras_grafica);
                                descripcion.setText("La compra de gráficas a proveedores de las Serie 3000 se ha visto estancada debido a la falta de stock. Sin embargo la gama Radeo de AMD ofrece más stock y la demanda de estas es mayor que en la Serie 1000 y Serie 2000 de Nvidia.");
                                break;
                            case "Compras - RAM":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.compras_ram);
                                descripcion.setText("La compra de memorias RAM de 16 GB y 64 GB ha sido mucho mayor en el histórico de compras comparado con las de 8 y 32 GB. Esto puede ser debido a la acumulación de stock. Las memorias RAM son más solicitadas con RGB en general.");
                                break;
                            case "Compras - Procesadores":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.compras_procesadores);
                                descripcion.setText("Esta demandando a los proveedores más procesadores de gama de entrada y gama media en vez de gama alta. Esto es debido a los altos precios que tienes este hardware en las gamas altas.");
                                break;
                            case "Compras - Almacenamiento":
                                imgGrafica.setVisibility(View.VISIBLE);
                                titulo.setVisibility(View.VISIBLE);
                                descripcion.setVisibility(View.VISIBLE);
                                imgGrafica.setImageResource(R.drawable.compras_almacenamiento);
                                descripcion.setText("Las compras que realizas a los proveedores han disminuido en los HDD debido al stock que tenía anteriormente de estos modelos. Sin embargo, al aumentar la demanda en los discos duros de última generación, se ha visto reflejado en el aumento exponencia de estos dispositivos a los proveedores.");
                                break;
                            default:
                                imgGrafica.setVisibility(View.INVISIBLE);
                                titulo.setVisibility(View.INVISIBLE);
                                descripcion.setVisibility(View.INVISIBLE);


                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent2) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent1) {

            }
        });

        return root;
    }
}