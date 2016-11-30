package stucomRoyal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 17/11/2016.
 */
public class Jugador {
    private String nombre;
    private String password;
    private int trofeos;
    private HashMap<String,Carta> cartas;

    public Jugador(String nombre, String password, int trofeos) {
        this.nombre = nombre;
        this.password = password;
        this.trofeos = trofeos;
        cartas = new HashMap<>();
    }

    public Jugador() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public HashMap<String,Carta> getCartas() {
        return cartas;
    }

    public void setCartas(HashMap<String,Carta> cartas) {
        this.cartas = cartas;
    }


    public int compareTo(Jugador o) {
        if (trofeos < o.trofeos) {
            return -1;
        }
        if (trofeos > o.trofeos) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", trofeos=" + trofeos +
                ", cartas=" + cartas +
                '}';
    }
}
