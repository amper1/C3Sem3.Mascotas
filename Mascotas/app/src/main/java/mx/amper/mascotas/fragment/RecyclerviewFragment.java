package mx.amper.mascotas.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;
import mx.amper.mascotas.adaptador.MascotasAdaptador;
import mx.amper.mascotas.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerviewFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        //ArrayList <String> nombreMascotas = new ArrayList<>();
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(getActivity());
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llmMascotas);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
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
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);

    }

}
