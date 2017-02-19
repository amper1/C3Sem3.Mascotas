package mx.amper.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;

/**
 * Created by Atian&Amper on 18/02/2017.
 */

public class ConstructorMascotas {
    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList <Mascotas> obtenerMascotas () {
        BaseDatos db = new BaseDatos(context);
        //insertarTresMascotas(db);
        return null;
        //return db.obtenerTodosLosContactos();
    }

/*    public void insertarTresMascotas (BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TB_MASCOTA_ID, "1");
        contentValues.put(ConstantesBD.TB_MASCOTA_NOM, "Schnauzer");
        //contentValues.put(ConstantesBD.TB_MASCOTA_FOTO, );
        return;*/
}
