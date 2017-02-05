package mx.amper.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import static mx.amper.mascotas.R.layout.actionbar;
import static mx.amper.mascotas.R.layout.activity_main;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        ArrayList <String> nombreMascotas = new ArrayList<>();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llmMascotas);
        inicializarListaMascotas();
        inicializarAdaptador();

        ImageButton btnRanking  = (ImageButton) findViewById(R.id.ibStar);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clic", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
            }
        });
    }

    public void inicializarListaMascotas (){
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

    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }

}
