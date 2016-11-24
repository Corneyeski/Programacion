package stucomRoyal;

/**
 * Created by Alan on 17/11/2016.
 */
public class Carta {

    private String nombre;
    private int elixir;
    private  int vida;

    public Carta(String nombre, int elixir, int vida) {
        this.nombre = nombre;
        this.elixir = elixir;
        this.vida = vida;
    }

    public Carta() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", elixir=" + elixir +
                ", vida=" + vida +
                '}';
    }
}
