package mx.amper.mascotas.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;
import mx.amper.mascotas.db.ConstructorMascotas;
import mx.amper.mascotas.fragment.IReciclerViewFragmentView;


/**
 * Created by Atian&Amper on 17/02/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IReciclerViewFragmentView iReciclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList <Mascotas> mascotas;


    public RecyclerViewFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {
        this.iReciclerViewFragmentView = iReciclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(mascotas));
        iReciclerViewFragmentView.generarLinearLayoutVertical();
    }
}

