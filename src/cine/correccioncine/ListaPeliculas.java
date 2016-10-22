package cine.correccioncine;

import cine.pelicula;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaPeliculas implements Serializable{

    private ArrayList<pelicula> lista;

    public ListaPeliculas(){
        lista = new ArrayList<>();
    }
}
