package mx.amper.mascotas.db;

/**
 * Created by Atian&Amper on 18/02/2017.
 */

public class ConstantesBD {
    //Nombre de base de datos
    public static final String DATABASE_NAME = "db_mascotas";
    public static final int DATABASE_VERSION = 1;

    //Tablas
    //mascota
    public static final String TB_MASCOTA = "mascota";
    //mascota -- campos
    public static final String TB_MASCOTA_ID = "id_masc";
    public static final String TB_MASCOTA_NOM = "nombre";
    public static final String TB_MASCOTA_FOTO = "foto";

    //like_mascota
    public static final String TB_LIKES = "like_mascota";
    //like_mascota -- campos
    public static final String TB_LIKES_ID = "id_like";
    public static final String TB_LIKES_ID_MASC = "id_masc";
    public static final String TB_LIKES_LIKE = "like";

}
