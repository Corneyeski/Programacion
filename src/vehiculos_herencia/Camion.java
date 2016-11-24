package vehiculos_herencia;

/**
 * Created by Alan on 10/11/2016.
 */
public class Camion extends Vehiculos {

    public Camion(String matricula, int dias) {
        super(matricula, dias);
    }

    @Override
    public Double precio(int dias){

        return dias * 50 + 40 + 0.0;
    }
}
