package stucomRoyal;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static presupuesto.Tools.tools.InputData.pedirCadena;
import static presupuesto.Tools.tools.InputData.pedirEntero;

/**
 * Created by Alan on 17/11/2016.
 */
public class main {

    static protected HashMap<String, Jugador> jugadores = new HashMap<>();
    static protected HashMap<String, Carta> cartas = new HashMap<>();
    static protected Carta[][] pelea = new Carta[2][3];

    public static void main(String[] args) {

        //HashSet<Jugador> jugadores = new HashSet<>();
        //HashMap<String, Carta> cartasj = new HashMap<>();

        Jugador j1 = new Jugador("Alan", "stucom", 0);
        jugadores.put(j1.getNombre(), j1);
        Jugador j2 = new Jugador("Alex", "stucom", 0);
        jugadores.put(j2.getNombre(), j2);
        Jugador j3 = new Jugador("Ricard", "stucom", 0);
        jugadores.put(j3.getNombre(), j3);
        Jugador j4 = new Jugador("Javi", "stucom", 0);
        jugadores.put(j4.getNombre(), j4);

        Tropa tropa = new Tropa("barbaro", 4, 200, 50);
        cartas.put(tropa.getNombre(), tropa);
        Tropa tropa2 = new Tropa("esqueleto", 1, 50, 15);
        cartas.put(tropa2.getNombre(), tropa2);
        Tropa tropa3 = new Tropa("dragon", 6, 500, 120);
        cartas.put(tropa3.getNombre(), tropa3);

        Estructura est = new Estructura("torre", 3, 500, 100);
        cartas.put(est.getNombre(), est);
        Estructura est2 = new Estructura("muro", 5, 500, 300);
        cartas.put(est2.getNombre(), est2);
        Estructura est3 = new Estructura("palo", 1, 50, 50);
        cartas.put(est3.getNombre(), est3);

        Echizo echi = new Echizo("fuego", 3, 50, 10, true);
        cartas.put(echi.getNombre(), echi);
        Echizo echi2 = new Echizo("hielo", 1, 50, 10, false);
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
                    }
                    break;
                case 2:
                    Jugador jugador1 = login();
                    System.out.println("Segundo jugador");
                    Jugador jugador2 = login();

                    if (jugador1 != null && jugador2 != null) {
                        if (jugador1.getCartas().size() < 3 || jugador2.getCartas().size() < 3) {
                            System.out.println("Ambos jugadores necesitais minimo 3 cartas");
                        } else {
//                            ArrayList<Carta> battle = new ArrayList<>();
//                            ArrayList<Carta> battle2 = new ArrayList<>();

                            pelea = choice(jugador1,0);
                            pelea = choice(jugador2,1);

                            int random = (int) (Math.random() *2+0);

                            batalla(random);
                            batalla(firstatack(random));
                            ganador(jugador1.getNombre(),jugador2.getNombre());
                        }
                    }

                    break;
                case 3:
                    List<Jugador> orden = new ArrayList<>();
                    //List<Jugador> orden = (List<Jugador>) jugadores.values();
                    jugadores.forEach((key,value) -> orden.add(value));


                    Collections.sort(orden, new Comparator<Jugador>() {
                        @Override
                        public int compare(Jugador o1, Jugador o2) {
                            return new Integer(o2.getTrofeos()).compareTo(new Integer(o1.getTrofeos()));
                        }
                    });
                    System.out.println(orden);
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
                System.out.println("Uusuario o contraseña no validos");
            }
        }else{
            System.out.println("Uusuario o contraseña no validos");
        }
        return j;
    }

    public static void jugadorCartas(Jugador j, String n) {

        String seguir = "";
        while (!seguir.equalsIgnoreCase("salir") && j.getCartas().size() < 7) {
            if (j.getCartas().size() == 6) {
                System.out.println("Ya tienes el numero maximo de cartas");
            } else {
                Carta c;
                if (!j.getCartas().containsKey(n)) {

                    c = cartas.get(n);
                    j.getCartas().put(c.getNombre(), c);

                    jugadores.put(j.getNombre(), j);

                    System.out.println("Carta añadida, puedes añadir " + (6 - j.getCartas().size()) + " mas");
                } else {
                    System.out.println("Ya tienes esta carta");
                }
            }
            System.out.println(j.getCartas());
            seguir = pedirCadena("Pulsa enter o escribe salir para salir");
        }
    }

    public static Carta[][] choice(Jugador j, int who) {

        System.out.println(j.getNombre() + " escoge tres cartas");

        int vueltas = 0;
        String pedir = "";
        int max = 0;
        do {
            do {
                System.out.println(j.getCartas());
                pedir = pedirCadena(" escribe el nombre de la que quieras");
                    pedir = repetido(pedir,who,j);
                    Carta c = cartas.get(pedir);
                    max += c.getElixir();
                    if ((max >= 10 && vueltas != 3) || (max > 10 && vueltas == 3)) {

                        //battle.clear();

                        pelea[who][0] = null;
                        pelea[who][1] = null;
                        pelea[who][2] = null;
                        vueltas = 0;
                        pedir = "";
                        max = 0;
                        System.out.println("Te has pasado de elixir, empieza de nuevo (maximo 10)");
                    }
            } while (!j.getCartas().containsKey(pedir));

            //battle.add(j.getCartas().get(pedir));

            pelea[who][vueltas] = j.getCartas().get(pedir);
            vueltas++;

        } while (vueltas != 3);
        return pelea;
    }

    public static void batalla(int start){

        for(Carta c : pelea[start]){
            if(c instanceof Tropa){
//                pelea[firstatack(start)][0].setVida(pelea[firstatack(start)][0].getVida()  - ((Tropa) c).getAtaque());
//                pelea[firstatack(start)][1].setVida(pelea[firstatack(start)][1].getVida()  - ((Tropa) c).getAtaque());
//                pelea[firstatack(start)][2].setVida(pelea[firstatack(start)][2].getVida()  - ((Tropa) c).getAtaque());

//                for(int i = 0; i < pelea[start].length;i++){
//                    pelea[firstatack(start)][i].setVida(pelea[firstatack(start)][i].getVida()  - ((Tropa) c).getAtaque());
//                }

                for(Carta cd : pelea[firstatack(start)]){
                    cd.setVida(cd.getVida()  - ((Tropa) c).ataque(((Tropa) c).getAtaque()));
                }
            }
            if(c instanceof Estructura){
                for(Carta cd : pelea[start]){
                    cd.setVida(((Estructura) c).subir(((Estructura) c).getDefensa(),cd.getVida()));
                }
            }
            if(c instanceof Echizo){
                if(((Echizo) c).isModo()){
                    for(Carta cd : pelea[start]){
                        cd.setVida(cd.getVida()+((Echizo) c).efecto(((Echizo) c).isModo(),((Echizo) c).getAlcance()));
                    }
                }else{
                    for(Carta cd : pelea[firstatack(start)]){
                        cd.setVida(cd.getVida()+((Echizo) c).efecto(((Echizo) c).isModo(),((Echizo) c).getAlcance()));
                    }
                }
            }
        }
    }
    public static int firstatack(int random){

        if(random == 1){
            random--;
        }else{
            random++;
        }
        return random;
    }
    public static void ganador(String n1,String n2){

        int j1 = 0;
        int j2 = 0;

        for(Carta c : pelea[0]){
            j1 += c.getVida();
        }
        for(Carta c : pelea[1]){
            j2 += c.getVida();
        }
        if(j1 > j2){
            System.out.println("Gana el jugador1!");
            Jugador jugador = jugadores.get(n1);
            jugador.setTrofeos(jugador.getTrofeos() + 5);
            jugadores.put(jugador.getNombre(),jugador);
        }else{
            System.out.println("Gana el jugador2!");
            Jugador jugador = jugadores.get(n2);
            jugador.setTrofeos(jugador.getTrofeos() + 5);
            jugadores.put(jugador.getNombre(),jugador);
        }
    }
    public static String repetido( String sele,int who,Jugador j){

        for(Carta c : pelea[who]){
            if(c != null) {
                while (c.getNombre().equals(sele)) {
                    System.out.println(j.getCartas());
                    sele = pedirCadena("Carta repetida, escoge otra");
                }
            }
        }
        return sele;
    }
}