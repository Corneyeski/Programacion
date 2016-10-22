package cine.correccioncine;

import cine.tools.Fichero;
import cine.tools.InputData;

/**
 * Created by Alan on 06/10/2016.
 */
public class Main {

    private static ListaPeliculas misPeliculas;

    private static Fichero miFichero;

    public static void main(String []args){
        // inicializamos el nombre del fichero
        miFichero = new Fichero("peliculas.xml");
        //cargamos los datos del fichero
        misPeliculas = (ListaPeliculas) miFichero.leer();

        //si no habia fichero

        if(misPeliculas == null) {
            misPeliculas = new ListaPeliculas();
        }
        int opcion;
        do{
            mostrarMenu();
            opcion = InputData.pedirEntero("algo");
            switch (opcion){
                case 1:
                    altaPelicula();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }while(opcion!= 0);
    }
    private static void mostrarMenu(){

        System.out.print("1 Alta");
        System.out.print("2 Listado de Peliculas");
        System.out.print("3 Modificacion");
        System.out.print("4 Borrado");
        System.out.print("0 Salir");
    }
    private static void altaPelicula(){
        String titulo;
       /* do {
            titulo = InputData.pedirCadena("");
            if(titulo.equals("")){

            }
        }while(); */
    }
}
