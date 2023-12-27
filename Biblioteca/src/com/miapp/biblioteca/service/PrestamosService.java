package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PrestamosService {


    private Map<Usuarios, ArrayList<Libros>> prestamos;

    // Constructor
    public PrestamosService() {
        this.prestamos = new HashMap<>();
    }

    // Metodo para prestar un libro a un usuario
    public void prestarLibro(Usuarios usuario, Libros libro){
        ArrayList<Libros> librosPrestados = prestamos.getOrDefault(usuario, new ArrayList<>());
        librosPrestados.add(libro);
        prestamos.put(usuario, librosPrestados);
        usuario.getLibrosPrestados().add(libro);
        libro.setDispponible(false);
    }

    // Metodo para que un usuario devuelva un libro
    public void devolverLibro(Usuarios usuario, Libros libro){
        ArrayList<Libros> librosPrestados = prestamos.get(usuario);
        if (librosPrestados != null) {
            librosPrestados.remove(libro);
            libro.setDispponible(true);
        }
    }

    // Metodo para obtener los libros prestados a un usario
    public ArrayList<Libros> obtenerLibrosPrestados(Usuarios usuario){
        return prestamos.get(usuario);
    }
}

