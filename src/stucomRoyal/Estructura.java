package stucomRoyal;

/**
 * Created by Alan on 17/11/2016.
 */
public class Estructura extends Carta {

    private int defensa;

    public Estructura(String nombre, int elixir, int vida, int defensa) {
        super(nombre, elixir, vida);
        this.defensa = defensa;
    }

    public Estructura() {}

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int subir (int defensa,int vida){

        defensa += 8 + vida;

        return defensa;
    }

    @Override
    public String toString() {
        return "Estructura{" +
                "nombre='" + nombre + '\'' +
                ", elixir=" + elixir +
                ", vida=" + vida +
                ", defensa=" + defensa +
                '}';
    }
}
