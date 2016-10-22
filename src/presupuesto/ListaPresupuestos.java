package presupuesto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 13/10/2016.
 */
public class ListaPresupuestos {
    private ArrayList<Presupuesto> lista;

    public ListaPresupuestos(){lista = new ArrayList<>();}
    public void altaPresupuesto(Presupuesto p){
        lista.add(p);
    }
}
