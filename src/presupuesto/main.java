package presupuesto;

import cine.tools.Fichero;

import java.util.ArrayList;
import java.util.List;

import static presupuesto.Tools.tools.InputData.pedirCadena;
import static presupuesto.Tools.tools.InputData.pedirDouble;
import static presupuesto.Tools.tools.InputData.pedirEntero;

/**
 * Created by Alan on 13/10/2016.
 */
public class main {

    private static ListaPersonas personas;
    private static Fichero miFichero;

    public void main(String[] args) {

        miFichero = new Fichero("personas.xml");
        personas = (ListaPersonas) miFichero.leer();
        if (personas == null) {
            personas = new ListaPersonas();
        }

        Persona persona = new Persona();
        int opcion = 0;
        List<Persona> lpersonas = new ArrayList<>();
        do {
            switch (opcion) {

                case 1:
                    persona = registrar();
                    personas.altaPersona(persona);
                    break;
                case 2:
                    if(personas.encontrar(pedirEntero("Numero del cliente?"))){
                        presupuesto();
                    }else{
                        persona = registrar();
                        personas.altaPersona(persona);
                        presupuesto();
                    }
                    break;
                case 3:
                    for(Persona cliente : lpersonas){
                        List<Presupuesto> algo = new ArrayList<>();
                        algo = (List<Presupuesto>) cliente.getPresupuestos();
                        for(Presupuesto presupuesto : algo){
                            if(presupuesto.getEstado().equalsIgnoreCase("pendiente")){
                                System.out.println(presupuesto.getNum());
                                System.out.println(cliente.getNombre());
                                System.out.println(cliente.getApellido());
                            }
                        }
                    }
                    break;
                case 4:
                    int num = pedirEntero("Numero de telefono?");
                    for(Persona cliente : lpersonas){
                        if(num == cliente.getNumero()){
                            List<Presupuesto> algo = new ArrayList<>();
                            algo = (List<Presupuesto>) cliente.getPresupuestos();
                            for(Presupuesto presupuesto : algo){
                                System.out.println(presupuesto);
                            }
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        } while (opcion != 8);
    }
    public Persona registrar(){

        Persona persona = new Persona();

        persona.setNombre(pedirCadena("Nombre del cliente?"));
        persona.setApellido(pedirCadena("Apellido del cliente?"));
        boolean repetido = true;
        int numero;
        String vip;
        do {
            numero = pedirEntero("Numero de telefono?");
            if(personas.encontrar(numero)){
                repetido = false;
            }
        }while(repetido);
        persona.setNumero(numero);
        do {
            vip = pedirCadena("La has visto? escribe si o no");
            if (vip.equalsIgnoreCase("si")) {
                persona.setVip(true);
            } else if (vip.equalsIgnoreCase("no")) {
                persona.setVip(true);
            }
        } while (!vip.equalsIgnoreCase("no") && !vip.equalsIgnoreCase("si"));

        return persona;
    }
    public Presupuesto presupuesto(){

        Presupuesto presupuesto = new Presupuesto();

        presupuesto.setNum(pedirEntero("numero de presupuesto?"));
        presupuesto.setConcepto(pedirCadena("Concepto?"));
        presupuesto.setPrecio_neto(pedirDouble("precio total?"));
        System.out.println("Esta aceptado, rechazado, o pendiente?");
        int j = 0;
        do {
            System.out.print("1- Aceptado");
            System.out.print("2- Rechazado");
            System.out.print("3- Pendiente");
            j = pedirEntero("");
        }while(j < 1 || j > 3);
        presupuesto = acerecha(j,presupuesto);

        return presupuesto;
    }
    public Presupuesto acerecha(int j, Presupuesto presupuesto){
        if(j == 1){
            presupuesto.setEstado("Aceptado");
        }
        if(j == 2){
            presupuesto.setEstado("Rechazado");
        }
        if(j == 3){
            presupuesto.setEstado("Pendiente");
        }
        return presupuesto;
    }
}
