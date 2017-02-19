package mx.amper.mascotas.fragment;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;
import mx.amper.mascotas.adaptador.MascotasAdaptador;

/**
 * Created by Atian&Amper on 17/02/2017.
 */

public interface IReciclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);

}
