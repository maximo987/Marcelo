package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.service.LibrosService;
import com.miapp.biblioteca.service.PrestamosService;
import com.miapp.biblioteca.service.UsuariosService;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Crear servicios

        UsuariosService usuariosService = new UsuariosService(new ArrayList<>());
        LibrosService librosService = new LibrosService(new ArrayList<>());
        PrestamosService prestamosService = new PrestamosService();

        // Crear interfaz de usuario y pasarle los servicios

        InterfazUsuario interfazUsuario = new InterfazUsuario(usuariosService, librosService, prestamosService);

        // Iniciar la interfaz de usuario

        interfazUsuario.iniciar();
    }
}
