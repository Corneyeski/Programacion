package cine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        int op = 0;
        pelicula pelicula = new pelicula();
        List<pelicula> peliculas = new ArrayList<>();
        do {

            mostrarMenu();
            op = (pedirEntero("Elige una opcion", 1));

            switch (op) {

                case 1:
                    String visto = "";
                    pelicula.setTitulo(pedirCadena("Nombre de la pelicula?"));
                    pelicula.setGenero(pedirCadena("Genero?"));
                    pelicula.setCodigo(pedirCadena("Codigo?"));
                    pelicula.setDirector(pedirCadena("Director?"));
                    pelicula.setDuracion(pedirEntero("Duracion de la pelicula?", 2));
                    pelicula.setValoracion(pedirDouble("Valoracion de la pelicula?"));
                    do {
                        visto = pedirCadena("La has visto? escribe si o no");
                        if (visto.equalsIgnoreCase("si")) {
                            pelicula.setVisto(true);
                        } else if (visto.equalsIgnoreCase("no")) {
                            pelicula.setVisto(true);
                        }
                    } while (!visto.equalsIgnoreCase("no") && !visto.equalsIgnoreCase("si"));
                    peliculas.add(pelicula);
                    break;
                case 2:
                    boolean check = true;
                    for (pelicula actPeli : peliculas) {
                        if (pelicula.getCodigo().equals(actPeli.getCodigo())) {
                            System.out.println(actPeli);
                            check = false;
                            break;
                        }
                    }
                    if (check == true) {
                        System.out.println("Sin coincidencias");
                    }
                    break;
                case 3:
                    boolean check2 = true;
                    String genero = pedirCadena("que genero buscas?");
                    for (pelicula actPeli : peliculas) {
                        if (genero.equals(actPeli.getGenero())) {
                            System.out.println(actPeli.getTitulo());
                            check2 = false;
                        }
                    }
                    if (check2 == true) {
                        System.out.println("Sin coincidencias.");
                    }
                    break;
                case 4:
                    String titulo = "";
                    double valor = 0;
                    for (pelicula actPeli : peliculas) {
                        if (actPeli.getValoracion() > valor) {
                            valor = actPeli.getValoracion();
                            titulo = actPeli.getTitulo();
                        }
                    }
                    if (titulo == "") {
                        System.out.println("Sin peliculas registradas");
                    } else {
                        System.out.println("La pelicula favorita es: " + titulo + " " + valor);
                    }
                    break;
                case 5:
                    int largo = peliculas.size();
                    int i = 0;
                    int j = 0;
                    for (pelicula actPeli : peliculas) {
                        if (actPeli.getVisto() == false) {
                            i++;
                        }
                        j = j + actPeli.getDuracion();
                    }
                    System.out.println("Te faltan " + i + " por ver de " + largo + " duracion total de " + j + " minutos.");
                    break;
            }

        } while (op != 6);

        System.out.println("Adios, hasta la proxima!");
    }

    private static int pedirEntero(String mensaje, int valor) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error;
        do {
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
            if (valor == 1) {
                if (numero < 1 || numero > 6) {
                    System.out.print("Numero entre 1 y 6");

                    mostrarMenu();
                }
                if (valor == 2) {

                    if (numero < 1) {
                        System.out.print("Numero mayor que 0");
                    }
                }
            }
        } while (error);    // es lo mismo que error == true
        return numero;
    }

    private static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                cadena = br.readLine();
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            }
            if (cadena == "") {
                error = true;
            }
        } while (error);
        return cadena;
    }

    private static double pedirDouble(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numero = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                numero = Double.parseDouble(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un número.");
                error = true;
            }
            if (numero < 0 || numero > 10) {
                System.out.print("Numero entre 0 y 10");
            }
        } while (error);
        return numero;
    }

    private static void mostrarMenu() {

        System.out.println("1. Nueva película.");
        System.out.println("2. Consultar datos de una película.");
        System.out.println("3. Listado de películas de un género");
        System.out.println("4. Película favorita (la que tenga la puntuación más alta).");
        System.out.println("5. Totales.");
        System.out.println("6. Salir.");
    }
}
