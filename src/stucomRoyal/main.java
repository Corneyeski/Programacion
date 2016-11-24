package stucomRoyal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static presupuesto.Tools.tools.InputData.pedirCadena;
import static presupuesto.Tools.tools.InputData.pedirEntero;

/**
 * Created by Alan on 17/11/2016.
 */
public class main {

    public static void main(String[] args) {

        //HashSet<Jugador> jugadores = new HashSet<>();
        HashMap<String,Jugador> jugadores = new HashMap<>();
        ArrayList<Carta> cartas = new ArrayList<>();

        Jugador j1 = new Jugador("Alan","stucom",0,cartas);
        jugadores.put(j1.getNombre(),j1);
        Jugador j2 = new Jugador("Alex","stucom",0,cartas);
        jugadores.put(j2.getNombre(),j2);
        Jugador j3 = new Jugador("Ricard","stucom",0,cartas);
        jugadores.put(j3.getNombre(),j3);
        Jugador j4 = new Jugador("Javi","stucom",0,cartas);
        jugadores.put(j4.getNombre(),j4);


        int opcion = 0;
        do {
            do {
                opcion = menu();
            } while (opcion < 1 || opcion > 8);

            switch (opcion){
                case 1:
                    Jugador j = login(jugadores);
                    if(j != null){

                    }else{
                        System.out.println("Usuario o contraseña no validos");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (opcion != 4);


    }
    public static int menu(){

        System.out.println("1. Conseguir cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");


        return pedirEntero("");
    }
    public static Jugador login(HashMap jugadores){
        
        String nom = pedirCadena("Nombre de usuario?");
        String psw =pedirCadena("Contraseña?");
        Jugador j = (Jugador) jugadores.get(nom);
        if(j != null){
            if(j.getPassword().equals(psw)){

            }
        }
        return j;
    }
}