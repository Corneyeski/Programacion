package vehiculos_herencia;

/**
 * Created by Alan on 10/11/2016.
 */
public class Microbuses extends Vehiculos {

    public Microbuses(String matricula, int dias) {
        super(matricula, dias);
    }

    @Override
    public Double precio(int dias){

        return super.getPlaza() * 2 + 0.0;
    }
}
