package mx.amper.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;
import mx.amper.mascotas.R;

import static mx.amper.mascotas.db.ConstantesBD.TB_LIKES_ID_MASC;
import static mx.amper.mascotas.db.ConstantesBD.TB_LIKES_LIKE;

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

    public void insertarTresMascotas (BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TB_MASCOTA_NOM, "Schnauzer");
        contentValues.put(ConstantesBD.TB_MASCOTA_FOTO, R.drawable.sch_1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TB_MASCOTA_NOM, "Pastor Aleman");
        contentValues.put(ConstantesBD.TB_MASCOTA_FOTO, R.drawable.pastor_1);

        db.insertarMascota(contentValues);
        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TB_MASCOTA_NOM, "Sabueso");
        contentValues.put(ConstantesBD.TB_MASCOTA_FOTO, R.drawable.sabueso_1);

        db.insertarMascota(contentValues);
    }


    public void darLikeMascota (Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_LIKES_ID_MASC, mascotas.getId());
        contentValues.put(TB_LIKES_LIKE, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascotas);

    }

}
