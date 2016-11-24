package vehiculos_herencia;

/**
 * Created by Alan on 10/11/2016.
 */
public class Coche extends Vehiculos{


    public Coche(String matricula, int plaza) {
        super(matricula, plaza);
    }

    @Override
    public Double precio(int dias){

        return dias * 50 + dias*1.5 + super.getPlaza() * 1.5;
    }
}
