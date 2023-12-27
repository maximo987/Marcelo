package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Usuarios;

import java.util.ArrayList;

// Clase para el sevicio de usiarios

public class UsuariosService {

    // Atributo para almacenar los usuarios en una lista
    private ArrayList<Usuarios> usuarios;

    // Constructor de la clase

    public UsuariosService(ArrayList<Usuarios> usuarios) {

        this.usuarios = usuarios;
    }

    // Método para crear un nuevo usuario y añadirlo a la lista

    public void create(String nombre, String id){
        Usuarios nuevoUsuario = new Usuarios(nombre, id);
        usuarios.add(nuevoUsuario);
    }

    // Metodo para leer todos los usuarios de la lista

    public ArrayList<Usuarios> readAll() {

        return usuarios;
    }

    // Metodo para leer un usuario de la lista por su ID

    public Usuarios readById(String id){
        for(Usuarios usuario : usuarios){
            if(usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    // Metodo para actualizar el nombre de un usuario

    public void update(String id, String nuevoNombre){
        for(Usuarios usuario : usuarios){
            if (usuario.getId().equals(id)){
                usuario.setNombre(nuevoNombre);
            }
        }
    }

    // Metodo para eliminar un usuario de la lista por su ID

    public void delete(String id){

        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }

    // Metodo para prestar un libro a un usuario

    public void prestarLibro(String idUsuario, Libros libro){
        for(Usuarios usuario : usuarios){
            if(usuario.getId().equals(idUsuario)){
                usuario.getLibrosPrestados().add(libro);
                libro.setDispponible(false);
            }
        }
    }

    // Metodo para que un usuaro devuerlva un libro

    public void devolverLibro(String idUsuario, Libros libro){
        for(Usuarios usuario : usuarios){
            if(usuario.getId().equals(idUsuario)){
                usuario.getLibrosPrestados().remove(libro);
                libro.setDispponible(true);
            }
        }
    }
}

