package vehiculos_herencia;

/**
 * Created by Alan on 10/11/2016.
 */
public class Carga extends Vehiculos{

    private int PMA;

    public Carga(String matricula, int dias) {
        super(matricula, dias);
    }

    public int getPMA() {
        return PMA;
    }

    public void setPMA(int PMA) {
        this.PMA = PMA;
    }

    @Override
    public Double precio(int dias){

        return dias * 50 + 20 * PMA + 0.0;
    }
}
