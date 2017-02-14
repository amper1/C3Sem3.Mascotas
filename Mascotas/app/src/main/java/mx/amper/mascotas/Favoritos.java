package mx.amper.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import mx.amper.mascotas.adaptador.MascotasAdaptador;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascotas> mascotas;
    Activity activity;

    private RecyclerView listaMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        listaMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llmMascotas2 = new LinearLayoutManager(this);
        llmMascotas2.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(llmMascotas2);
        inicializarListaMascotas2();
        inicializarAdaptador2();

        ImageButton btnBack  = (ImageButton) findViewById(R.id.ibBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Favoritos.this, "Back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Favoritos.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void inicializarListaMascotas2 (){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.masc0, "Mascota 0", "3"));
        mascotas.add(new Mascotas(R.drawable.masc1, "Mascota 1", "2"));
        mascotas.add(new Mascotas(R.drawable.masc2, "Mascota 2", "5"));
        mascotas.add(new Mascotas(R.drawable.masc3, "Mascota 3", "3"));
        mascotas.add(new Mascotas(R.drawable.masc4, "Mascota 4", "5"));
        mascotas.add(new Mascotas(R.drawable.masc5, "Mascota 5", "4"));
        mascotas.add(new Mascotas(R.drawable.masc6, "Mascota 6", "1"));
        mascotas.add(new Mascotas(R.drawable.masc7, "Mascota 7", "5"));
        mascotas.add(new Mascotas(R.drawable.masc8, "Mascota 8", "5"));
        mascotas.add(new Mascotas(R.drawable.masc9, "Mascota 9", "5"));

    }

    public void inicializarAdaptador2(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas,this);
        listaMascotas2.setAdapter(adaptador);

    }
}


