package mx.amper.mascotas.Pojo;

/**
 * Created by MB17056 on 03/02/2017.
 */

public class Mascotas {

    private int id;
    private String nombre;
    private int foto;
    private int ranking;


    public Mascotas (int foto, String nombre, int ranking){
        this.foto = foto;
        this.nombre = nombre;
        this.ranking = ranking;
    }

    public Mascotas (){

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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
