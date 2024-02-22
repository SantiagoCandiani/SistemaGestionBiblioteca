package servicios;

import entidades.Libro;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UsuarioServicio {

    private List<Usuario> usuarios;
    private Scanner scanner;

    public UsuarioServicio() {
        this.usuarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    //Metodo para precargar una lista de Usuarios (Gracias chatGPT!!!):
    public void ingresarUsuariosPrecargados() {

        // Usuario 01
        List<Libro> librosPrestadosUsuario01 = Arrays.asList(
                new Libro("Libro1", "Autor1", "ISBN01", "Genero1", 5, true ,true),
                new Libro("Libro2", "Autor2", "ISBN02", "Genero2", 18, true, true)
        );
        Usuario usuario01 = new Usuario("Nombre1", "Apellido1", "ID01", librosPrestadosUsuario01, true, false);
        usuarios.add(usuario01);

        // Usuario 02
        List<Libro> librosPrestadosUsuario02 = Arrays.asList(
                new Libro("Libro3", "Autor3", "ISBN03", "Genero3", 1, true, true),
                new Libro("Libro4", "Autor4", "ISBN04", "Genero4", 3, true, true)
        );
        Usuario usuario02 = new Usuario("Nombre2", "Apellido1", "ID02", librosPrestadosUsuario02, true, false);
        usuarios.add(usuario02);

        // Usuario 03
        List<Libro> librosPrestadosUsuario03 = Arrays.asList(
                new Libro("Libro5", "Autor5", "ISBN05", "Genero5", 10, true, true),
                new Libro("Libro6", "Autor6", "ISBN06", "Genero6", 6, true, true)
        );
        Usuario usuario03 = new Usuario("Nombre3", "Apellido3", "ID03", librosPrestadosUsuario03, true, false);
        usuarios.add(usuario03);

        // Usuario 04
        List<Libro> librosPrestadosUsuario04 = Arrays.asList(
                new Libro("Libro7", "Autor7", "ISBN07", "Genero7", 2, true, true),
                new Libro("Libro8", "Autor8", "ISBN08", "Genero8", 4, true, true)
        );
        Usuario usuario04 = new Usuario("Nombre4", "Apellido4", "ID04", librosPrestadosUsuario04, true, false);
        usuarios.add(usuario04);

        // Usuario 05
        List<Libro> librosPrestadosUsuario05 = Arrays.asList(
                new Libro("Libro9", "Autor9", "ISBN09", "Genero9", 7, true, true),
                new Libro("Libro10", "Autor10", "ISBN10", "Genero10", 2, true, true)
        );
        Usuario usuario05 = new Usuario("Nombre5", "Apellido5", "ID05", librosPrestadosUsuario05, true, false);
        usuarios.add(usuario05);

        // Usuario 06
        List<Libro> librosPrestadosUsuario06 = Arrays.asList(
                new Libro("Libro11", "Autor11", "ISBN11", "Genero11", 3, true, true),
                new Libro("Libro12", "Autor12", "ISBN12", "Genero12", 8, true, true)
        );
        Usuario usuario06 = new Usuario("Nombre6", "Apellido6", "ID06", librosPrestadosUsuario06, true, false);
        usuarios.add(usuario06);

        // Usuario 07
        List<Libro> librosPrestadosUsuario07 = Arrays.asList(
                new Libro("Libro13", "Autor13", "ISBN13", "Genero13", 6, true, true),
                new Libro("Libro14", "Autor14", "ISBN14", "Genero14", 12, true, true)
        );
        Usuario usuario07 = new Usuario("Nombre7", "Apellido7", "ID07", librosPrestadosUsuario07, true, false);
        usuarios.add(usuario07);

        // Usuario 08
        List<Libro> librosPrestadosUsuario08 = Arrays.asList(
                new Libro("Libro15", "Autor15", "ISBN15", "Genero15", 9, true, true),
                new Libro("Libro16", "Autor16", "ISBN16", "Genero16", 5, true, true)
        );
        Usuario usuario08 = new Usuario("Nombre8", "Apellido8", "ID08", librosPrestadosUsuario08, true, false);
        usuarios.add(usuario08);

        // Usuario 09
        List<Libro> librosPrestadosUsuario09 = Arrays.asList(
                new Libro("Libro17", "Autor17", "ISBN17", "Genero17", 4, true, true),
                new Libro("Libro18", "Autor18", "ISBN18", "Genero18", 6, true, true)
        );
        Usuario usuario09 = new Usuario("Nombre9", "Apellido9", "ID09", librosPrestadosUsuario09, true, false);
        usuarios.add(usuario09);

        // Usuario 10
        List<Libro> librosPrestadosUsuario10 = Arrays.asList(
                new Libro("Libro19", "Autor19", "ISBN19", "Genero19", 11, true, true),
                new Libro("Libro20", "Autor20", "ISBN20", "Genero20", 7, true, true)
        );
        Usuario usuario10 = new Usuario("Nombre10", "Apellido10", "ID10", librosPrestadosUsuario10, true, false);
        usuarios.add(usuario10);

        System.out.println("Lista de Usuarios ingresada exitosamente.");
    }

    //Método para mostrar todos los usuarios
    public void obtenerTodosLosUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios para mostrar.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        }
    }

    //Método para crear un usuario
    public void ingresarUsuario() {
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del usuario:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el número de identificación del usuario:");
        String numeroIdentificacion = scanner.nextLine();

        // Inicialmente, el usuario no tiene libros prestados, no adeuda ningún libro y es activo
        List<Libro> librosPrestados = new ArrayList<>();
        boolean activo = true;
        boolean adeudaLibro = false;

        Usuario usuario = new Usuario(nombre, apellido, numeroIdentificacion, librosPrestados, activo, adeudaLibro);
        usuarios.add(usuario);

        System.out.println("Usuario ingresado exitosamente.");
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(String idUsuario) {
        Usuario usuario = obtenerUsuarioPorId(idUsuario);

        if (usuario != null) {
            System.out.println("Usuario encontrado. Ingrese los nuevos datos:");

            System.out.print("Nombre: ");
            usuario.setNombre(scanner.next());

            System.out.print("Apellido: ");
            usuario.setApellido(scanner.next());

            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para dar de baja un usuario
    public void darDeBajaUsuario(String idUsuario) {
        Usuario usuario = obtenerUsuarioPorId(idUsuario);

        if (usuario != null) {
            usuario.setActivo(false);
            System.out.println("El usuario ha sido dado de baja exitosamente.");
        } else {
            System.out.println("No se encontró ningún usuario con el ID proporcionado.");
        }
    }

    // Método para dar de baja todos los usuarios sin borrarlos
    public void darDeBajaTodosLosUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.setActivo(false);
        }
        System.out.println("Se han dado de baja todos los usuarios.");
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(idUsuario)) {
                return usuario;
            }
        }
        return null; // Retorna null si no se encuentra ningún usuario con el ID proporcionado
    }

    // Método para mostrar un usuario
    public void mostrarUsuario(Usuario usuario) {
        if (usuario != null) {
            System.out.println(usuario.toString());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para buscar usuarios por nombre y apellido
    public List<Usuario> buscarUsuariosPorNombreYApellido(String nombre, String apellido) {
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getApellido().equalsIgnoreCase(apellido)) {
                usuariosEncontrados.add(usuario);
            }
        }
        if (usuariosEncontrados.isEmpty()) {
            System.out.println("No se encontraron usuarios con el nombre '" + nombre + "' y apellido '" + apellido + "'.");
        }
        return usuariosEncontrados;
    }

    // Método para mostrar una lista de usuarios
    public void mostrarUsuarios(List<Usuario> usuarios) {
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        } else {
            System.out.println("No se encontraron usuarios con ese nombre y apellido.");
        }
    }

}//Class
