package mx.amper.mascotas;

/**
 * Created by MB17056 on 03/02/2017.
 */

public class Mascotas {
    private int foto;
    private String nombre;
    private String ranking;


    public Mascotas (int foto, String nombre, String ranking){
        this.foto = foto;
        this.nombre = nombre;
        this.ranking = ranking;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
