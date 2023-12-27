package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libros;
import java.util.ArrayList;

// Clase para el servicio de libros
public class LibrosService {

    // Lista para almacenar los libros
    private ArrayList<Libros> biblioteca;

    // Constructor de la clase
    public LibrosService(ArrayList<Libros> biblioteca) {
        this.biblioteca = biblioteca;
    }

    // Método para crear un nuevo libro y añadirlo a la lista
    public void create(String titulo, String autor, String ISBN, String genero){
        Libros nuevoLibro = new Libros(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    // Metodo para leer todos los libros de la lista
    public ArrayList<Libros> readAll() {
        return biblioteca;
    }

    // Metodo para leer un libro de la lista por su ISBN
    public Libros readByISBN(String ISBN){
        for(Libros libro : biblioteca){
            if(libro.getISBN().equals(ISBN)){
                return libro;
            }
        }
        return null;
    }

    // Metodo para buscar un libro por su nombre
    public Libros readByNombre(String nombre){
        for(Libros libro : biblioteca){
            if(libro.getTitulo().equalsIgnoreCase(nombre)){
                return libro;
            }
        }
        return null;
    }

    // Metodo para actualizar los datos de un libro
    public void update(String ISBN, String nuevoAutor, String nuevoTitulo, String nuevoGenero){
        for(Libros libro : biblioteca){
            if (libro.getISBN().equals(ISBN)){
                libro.setAutor(nuevoAutor);
                libro.setTitulo(nuevoTitulo);
                libro.setGenero(nuevoGenero);
            }
        }
    }

    // Metodo para eliminar un libro de la lista por su ISBN
    public void delete(String ISBN){
        biblioteca.removeIf(libros -> libros.getISBN().equals(ISBN));
    }
}
