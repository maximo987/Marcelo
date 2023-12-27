package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Usuarios;
import com.miapp.biblioteca.service.LibrosService;
import com.miapp.biblioteca.service.PrestamosService;
import com.miapp.biblioteca.service.UsuariosService;

import java.util.ArrayList;
import java.util.Scanner;

// Esta es la clase InterfazUsuario que se encarga de la interacción con el usuario.

public class InterfazUsuario {

    // Estos son los servicios para usuarios, libros y préstamos

    private UsuariosService usuariosService;
    private LibrosService librosService;
    private PrestamosService prestamosService;
    private Scanner scanner;  // Este es el scanner para leer la entrada del usuario.

    // Este es el constructor de la clase InterfazUsuario.
    public InterfazUsuario(UsuariosService usuariosService, LibrosService librosService, PrestamosService prestamosService) {
        this.usuariosService = usuariosService;
        this.librosService = librosService;
        this.prestamosService = prestamosService;
        this.scanner = new Scanner(System.in);  // Inicializamos el scanner aquí.
    }

    // Metodo para iniciar la interfaz de usuario.
    public void iniciar() {
        while (true) {
            System.out.println("\n===Biblioteca Virtual===");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Mostrar libros prestados a un usuario");
            System.out.println("4. Crear libro");
            System.out.println("5. Listar Libros");
            System.out.println("6. Buscar un libro por ISBN");
            System.out.println("7. Buscar un libro por Titulo");
            System.out.println("8. Actualizar libro");
            System.out.println("9. Eliminar un libro");
            System.out.println("10. Prestamos");
            System.out.println("11. Devoluciones");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción:");
            String opcion = scanner.nextLine();

            // Leemos la opción del usuario aquí.
            switch (opcion) {
                case "1":
                    System.out.print("Ingresa el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa el ID del usuario: ");
                    String id = scanner.nextLine();
                    usuariosService.create(nombre, id);
                    System.out.println("Usuario creado exitosamente.");
                    break;
                case "2":
                    // Obtenemos todos los usuarios

                    ArrayList<Usuarios> todosLosUsuarios = usuariosService.readAll();
                    for (Usuarios usuario : todosLosUsuarios) {
                        System.out.println(usuario);  // Imprimimos cada usuario
                    }
                    break;

                case "3":
                    // Solicita el ID del usuario

                    System.out.print("Ingresa el ID del usuario: ");
                    String idUsuario = scanner.nextLine();
                    // Busca al usuario por ID

                    Usuarios usuario = usuariosService.readById(idUsuario);
                    if (usuario != null) {
                        // Obtiene los libros prestados por el usuario

                        ArrayList<Libros> librosPrestados = usuario.getLibrosPrestados();
                        if (librosPrestados.isEmpty()) {
                            // Si el usuario no tiene libros prestados, imprime un mensaje

                            System.out.println("El usuario no tiene libros prestados.");
                        } else {
                            // Si el usuario tiene libros prestados, imprime los libros

                            System.out.println("El usuario ya tiene libros prestados:");
                            for (Libros libro : librosPrestados) {
                                System.out.println(libro);
                            }
                        }
                    } else {
                        // Si no se encuentra al usuario, imprime un mensaje

                        System.out.println("No se encontró un usuario con el ID proporcionado.");
                    }
                    break;
                case "4":
                    // Solicita los detalles del libro

                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingresa el ISBN del libro: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Ingresa el género del libro: ");
                    String genero = scanner.nextLine();

                    // Crea un nuevo libro

                    librosService.create(titulo, autor, ISBN, genero);
                    System.out.println("Libro creado exitosamente.");
                    break;
                case "5":

                    // Obtiene todos los libros

                    ArrayList<Libros> todosLosLibros = librosService.readAll();

                    // Imprime todos los libros

                    for (Libros libro : todosLosLibros) {
                        System.out.println(libro);
                    }
                    break;
                case "6":
                    // Solicita el ISBN del libro

                    System.out.println("Introduce el ISBN del libro:");
                    String isbnBusqueda = scanner.nextLine();

                    // Busca el libro por ISBN

                    Libros libroBuscado = librosService.readByISBN(isbnBusqueda);

                    // Imprime el libro

                    System.out.println(libroBuscado);
                    break;
                case "7":
                    // Solicita el nombre del libro

                    System.out.println("Introduce el nombre del libro:");
                    String nombreBusqueda = scanner.nextLine();
                    // Busca el libro por nombre
                    libroBuscado = librosService.readByNombre(nombreBusqueda);
                    // Imprime el libro
                    System.out.println(libroBuscado);
                    break;
                case "8":
                    // Solicita los nuevos datos del libro

                    System.out.println("Introduce el ISBN del libro a actualizar y los nuevos datos (autor, título, género):");
                    String isbnActualizacion = scanner.nextLine();
                    String nuevoAutor = scanner.nextLine();
                    String nuevoTitulo = scanner.nextLine();
                    String nuevoGenero = scanner.nextLine();
                    // Actualiza el libro

                    librosService.update(isbnActualizacion, nuevoAutor, nuevoTitulo, nuevoGenero);
                    System.out.println("Libro actualizado exitosamente.");
                    break;
                case "9":
                    // Solicita el ISBN del libro a eliminar

                    System.out.println("Introduce el ISBN del libro a eliminar:");
                    String isbnEliminacion = scanner.nextLine();
                    // Elimina el libro

                    librosService.delete(isbnEliminacion);
                    System.out.println("Libro eliminado exitosamente.");
                    break;
                case "10":
                    // Solicita el ID del usuario y el ISBN del libro

                    System.out.print("Ingresa el ID del usuario: ");
                    idUsuario = scanner.nextLine();
                    System.out.print("Ingresa el ISBN del libro: ");
                    String isbnLibro = scanner.nextLine();
                    // Aquí deberías continuar con el código para el préstamo del libro


                    // Buscar el usuario y el libro

                    usuario = usuariosService.readById(idUsuario);
                    Libros libro = librosService.readByISBN(isbnLibro);

                    // Verificar si el usuario y el libro existen

                    if (usuario == null) {
                        System.out.println("No se encontró un usuario con el ID proporcionado.");
                        break;
                    }
                    if (libro == null) {
                        System.out.println("No se encontró un libro con el ISBN proporcionado.");
                        break;
                    }

                    // Verificar si el libro está disponible

                    if (!libro.isDispponible()) {
                        System.out.println("Lo siento, este libro no está disponible en este momento.");
                        break;
                    }

                    // Prestar el libro

                    prestamosService.prestarLibro(usuario, libro);
                    System.out.println("Libro prestado exitosamente.");
                    break;
                case "11":
                    System.out.print("Ingresa el ID del usuario: ");
                    idUsuario = scanner.nextLine();
                    System.out.print("Ingresa el ISBN del libro: ");
                    isbnLibro = scanner.nextLine();

                    // Buscar el usuario y el libro

                    usuario = usuariosService.readById(idUsuario);
                    libro = librosService.readByISBN(isbnLibro);

                    // Verificar si el usuario y el libro existen

                    if (usuario == null) {
                        System.out.println("No se encontró un usuario con el ID proporcionado.");
                        break;
                    }
                    if (libro == null) {
                        System.out.println("No se encontró un libro con el ISBN proporcionado.");
                        break;
                    }

                    // Verificar si el usuario tiene el libro prestado

                    if (!prestamosService.obtenerLibrosPrestados(usuario).contains(libro)) {
                        System.out.println("El usuario no tiene este libro prestado.");
                        break;
                    }

                    // Devolver el libro

                    prestamosService.devolverLibro(usuario, libro);
                    System.out.println("Libro devuelto exitosamente.");
                    break;
                case "12":
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }
    }
}