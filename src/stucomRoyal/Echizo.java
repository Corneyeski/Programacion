package stucomRoyal;

/**
 * Created by Alan on 17/11/2016.
 */
public class Echizo extends Carta{

    private int alcance;
    private boolean modo;

    public Echizo(String nombre, int elixir, int vida, int alcance, boolean modo) {
        super(nombre, elixir, vida);
        this.alcance = alcance;
        this.modo = modo;
    }

    public Echizo() {}

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public boolean isModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }
    @Override
    public String toString() {
        return "Echizo{" +
                "alcance=" + alcance +
                ", modo=" + modo +
                '}';
    }
}
