package vehiculos_herencia;

/**
 * Created by Alan on 03/11/2016.
 */
public class Vehiculos {
    private String matricula;
    private int plaza;

    public Vehiculos(String matricula, int plaza) {
        this.matricula = matricula;
        this.plaza = plaza;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public Double precio(int dias){


        return 50 + dias + 0.0;
    }
}
