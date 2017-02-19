package mx.amper.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas;

import static android.R.attr.version;
import static mx.amper.mascotas.db.ConstantesBD.*;

/**
 * Created by Atian&Amper on 18/02/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable1 = "CREATE TABLE " + TB_MASCOTA + " (" +
                TB_MASCOTA_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                TB_MASCOTA_NOM + " TEXT NOT NULL, " +
                TB_MASCOTA_FOTO + " INTEGER " +
                ")";

        String sqlCreateTable2 = "CREATE TABLE " + TB_LIKES + " (" +
                TB_LIKES_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                TB_LIKES_ID_MASC + " INTEGER NOT NULL, " +
                TB_LIKES_LIKE + " INTEGER NOT NULL, " +
                "FOREIGN KEY(" + TB_LIKES_ID_MASC + ") REFERENCES " + TB_MASCOTA + "(" + TB_MASCOTA_ID + ")" +
                ")";
        String sqlCreateTable3 = "CREATE TABLE " + TB_FOTOS+ " (" +
                TB_FOTOS_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                TB_FOTOS_ID_MASC + " INTEGER NOT NULL, " +
                TB_FOTOS_FOTO + "INTEGER NOT NULL, " +
                "FOREIGN KEY(" + TB_FOTOS_ID_MASC + ") REFERENCES " + TB_MASCOTA + "(" + TB_MASCOTA_ID + ")" +
                ")";

        //Crear tablas
        db.execSQL(sqlCreateTable1);
        db.execSQL(sqlCreateTable2);
        db.execSQL(sqlCreateTable3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDropTable1 = "DROP TABLE IF EXIST " + TB_MASCOTA;
        String sqlDropTable2 = "DROP TABLE IF EXIST " + TB_LIKES;
        String sqlDropTable3 = "DROP TABLE IF EXIST " + TB_FOTOS;

        db.execSQL(sqlDropTable1);
        db.execSQL(sqlDropTable2);
        db.execSQL(sqlDropTable3);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodaMascota(){
        ArrayList<Mascotas> mascota = new ArrayList<>();

        String query = "SELECT * FROM " + TB_MASCOTA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRanking(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLikes = "SELECT COUNT (" + TB_LIKES_LIKE + ") AS likes " +
                    "FROM " + TB_LIKES + " " +
                    "WHERE " + TB_LIKES_ID_MASC + " = " + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRanking(registrosLikes.getInt(0));
            } else {
                mascotaActual.setRanking(0);
            }
            mascota.add(mascotaActual);
        }
        db.close();

        return mascota;
    }
    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TB_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TB_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota (Mascotas mascotas){
        int likes = 0;
        String query = "SELECT count (" + TB_LIKES_LIKE + ") " +
                "FROM " + TB_LIKES + " " +
                "WHERE " +  TB_LIKES_ID_MASC + " = " + mascotas.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if  (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }

}
