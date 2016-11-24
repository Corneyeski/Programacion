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


    static HashMap<String, Jugador> jugadores = new HashMap<>();
    static HashMap<String, Carta> cartas = new HashMap<>();

    public static void main(String[] args) {

        //HashSet<Jugador> jugadores = new HashSet<>();
        Jugador jugador = new Jugador();

        Jugador j1 = new Jugador("Alan", "stucom", 0, cartas);
        jugadores.put(j1.getNombre(), j1);
        Jugador j2 = new Jugador("Alex", "stucom", 0, cartas);
        jugadores.put(j2.getNombre(), j2);
        Jugador j3 = new Jugador("Ricard", "stucom", 0, cartas);
        jugadores.put(j3.getNombre(), j3);
        Jugador j4 = new Jugador("Javi", "stucom", 0, cartas);
        jugadores.put(j4.getNombre(), j4);

        Tropa tropa = new Tropa("barbaro", 4, 200, 50);
        cartas.put(tropa.getNombre(), tropa);
        Tropa tropa2 = new Tropa("esqueleto", 1, 50, 15);
        cartas.put(tropa2.getNombre(), tropa2);
        Tropa tropa3 = new Tropa("dragon", 8, 500, 120);
        cartas.put(tropa2.getNombre(), tropa3);

        Estructura est = new Estructura("torre", 3, 500, 100);
        cartas.put(est.getNombre(), est);
        Estructura est2 = new Estructura("muro", 5, 500, 300);
        cartas.put(est2.getNombre(), est2);
        Estructura est3 = new Estructura("palo", 1, 50, 50);
        cartas.put(est3.getNombre(), est3);

        Echizo echi = new Echizo("fuego", 5, 50, 10, true);
        cartas.put(echi.getNombre(), echi);
        Echizo echi2 = new Echizo("hielo", 5, 50, 10, false);
        cartas.put(echi2.getNombre(), echi2);
        Echizo echi3 = new Echizo("arcano", 2, 60, 4, true);
        cartas.put(echi3.getNombre(), echi3);

        int opcion = 0;
        do {
            do {
                opcion = menu();
            } while (opcion < 1 || opcion > 4);

            switch (opcion) {
                case 1:
                    Jugador j = login();
                    if (j != null) {
                        cartas.forEach((key, value) -> System.out.println(value));
                        String pedir = pedirCadena("Escoge una por nombre");

                        if (cartas.containsKey(pedir)) {
                            jugadorCartas(j, pedir);
                        } else {
                            System.out.println("La carta no existe!");
                        }
                    } else {
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

    public static int menu() {

        System.out.println("1. Conseguir cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");


        return pedirEntero("");
    }

    public static Jugador login() {

        String nom = pedirCadena("Nombre de usuario?");
        String psw = pedirCadena("Contraseña?");
        Jugador j = (Jugador) jugadores.get(nom);
        if (j != null) {
            if (!j.getPassword().equals(psw)) {
                j = null;
            }
        }
        return j;
    }

    public static void jugadorCartas(Jugador j, String n) {

        Carta c;
        if (!j.getCartas().containsKey(n)) {

            c = cartas.get(n);
            j.getCartas().put(c.getNombre(), c);

            jugadores.put(j.getNombre(), j);

            System.out.println("Carta añadida, puedes añadir " + (j.getCartas().size() - 1) + " mas");
        }
        System.out.println("Ya tienes esta carta");
    }
}