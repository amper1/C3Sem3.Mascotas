package mx.amper.mascotas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        //Crear tablas
        db.execSQL(sqlCreateTable1);
        db.execSQL(sqlCreateTable2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDropTable1 = "DROP TABLE IF EXIST " + TB_MASCOTA;
        String sqlDropTable2 = "DROP TABLE IF EXIST " + TB_LIKES;
        db.execSQL(sqlDropTable1);
        db.execSQL(sqlDropTable2);
        onCreate(db);
    }



}
