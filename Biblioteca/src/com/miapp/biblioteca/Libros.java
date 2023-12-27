package com.miapp.biblioteca;

// Clase para los libros
public class Libros {

    // Atributos de la clase Libros
    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private boolean dispponible;

    // Constructor vacío
    public Libros() {
    }

    // Constructor parametrizado
    public Libros(String titulo, String autor, String ISBN, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.dispponible = true;
    }

    // Getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDispponible() {
        return dispponible;
    }

    public void setDispponible(boolean dispponible) {
        this.dispponible = dispponible;
    }

    // Funcion de informacion
    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                ", disponible=" + (dispponible ? "sí" : "no") +
                '}';
    }
}
