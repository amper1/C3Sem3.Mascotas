package mx.amper.mascotas.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.amper.mascotas.Mascotas2;
import mx.amper.mascotas.R;
import mx.amper.mascotas.adaptador.MascotasAdaptador2;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {

    ArrayList<Mascotas2> mascotas2;
    Activity activity2;

    private RecyclerView listaMascotas2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        //ArrayList <String> nombreMascotas = new ArrayList<>();
        listaMascotas2 = (RecyclerView) v.findViewById(R.id.rvMascotas2);

        GridLayoutManager glmMascotas = new GridLayoutManager(getContext(),3);
        glmMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(glmMascotas);
        inicializarListaMascotas2();
        inicializarAdaptador2();

        return v;
    }
    public void inicializarListaMascotas2 (){
        mascotas2 = new ArrayList<Mascotas2>();

        mascotas2.add(new Mascotas2(R.drawable.masc0, "3"));
        mascotas2.add(new Mascotas2(R.drawable.masc1, "2"));
        mascotas2.add(new Mascotas2(R.drawable.masc2, "5"));
        mascotas2.add(new Mascotas2(R.drawable.masc3, "3"));
        mascotas2.add(new Mascotas2(R.drawable.masc4, "5"));
        mascotas2.add(new Mascotas2(R.drawable.masc5, "4"));
        mascotas2.add(new Mascotas2(R.drawable.masc6, "1"));
        mascotas2.add(new Mascotas2(R.drawable.masc7, "5"));
        mascotas2.add(new Mascotas2(R.drawable.masc8, "5"));
        mascotas2.add(new Mascotas2(R.drawable.masc9, "5"));

    }

    public void inicializarAdaptador2(){
        MascotasAdaptador2 adaptador = new MascotasAdaptador2(mascotas2, getActivity());
        listaMascotas2.setAdapter(adaptador);

    }

}
