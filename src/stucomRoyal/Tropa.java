package stucomRoyal;

/**
 * Created by Alan on 17/11/2016.
 */
public class Tropa extends Carta{

    private int ataque;

    public Tropa(String nombre, int elixir, int vida, int ataque) {
        super(nombre, elixir, vida);
        this.ataque = ataque;
    }

    public Tropa() {}

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int ataque(int ataque){

        ataque /=  2;

        return ataque;
    }

    @Override
    public String toString() {
        return "Tropa{" +
                "nombre='" + nombre + '\'' +
                ", elixir=" + elixir +
                ", vida=" + vida +
                ", ataque=" + ataque +
                '}';
    }
}
