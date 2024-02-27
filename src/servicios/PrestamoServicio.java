package servicios;

import entidades.Libro;
import entidades.Prestamo;
import entidades.Usuario;

import java.util.*;

public class PrestamoServicio {

    private LibroServicio lServicio;
    private UsuarioServicio uServicio;
    private final Scanner scanner;

    public PrestamoServicio() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.lServicio = new LibroServicio();
        this.uServicio = new UsuarioServicio();
    }



    // Método para realizar el préstamo de un libro
    public void prestarLibro(Libro libro, Usuario usuario) {
        // Verificar disponibilidad del libro
        if (libro.getCantExistente() > 0) {
            Prestamo prestamo = new Prestamo();
            prestamo.setLibro(libro);
            prestamo.setUsuario(usuario);
            prestamo.setFechaPrestamo(new Date());
            usuario.setAdeudaLibro(true);

            // Establecer la fecha de devolución (por ejemplo, 15 días después del préstamo)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, 15);
            prestamo.setFechaDevolucion(calendar.getTime());

            // Actualizar disponibilidad del libro y cantidad disponible
            if (libro.getCantExistente() == 1) {
                libro.setDisponibilidad(false);
            }
            libro.setCantExistente(libro.getCantExistente() - 1);

            usuario.getLibrosPrestados().add(libro);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }




}//Class
