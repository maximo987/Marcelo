package com.miapp.biblioteca;

import com.miapp.biblioteca.Libros;

import java.util.ArrayList;

// Clase para los usuarios
public class Usuarios {

    // Atributos de la clase Usuarios
    private String nombre;
    private String id;
    private ArrayList<Libros> LibrosPrestados;

    // Constructor vacío
    public Usuarios() {
    }

    // Constructor parametrizado
    public Usuarios(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;  // ID del usuario
        this.LibrosPrestados = new ArrayList<>();
    }

    // Getters y setters

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public ArrayList<Libros> getLibrosPrestados() {

        return LibrosPrestados;
    }

    public void setLibrosPrestados(ArrayList<Libros> librosPrestados) {

        LibrosPrestados = librosPrestados;
    }

    // Método para imprimir la información del usuario
    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", LibrosPrestados=" + LibrosPrestados +
                '}';
    }
}
