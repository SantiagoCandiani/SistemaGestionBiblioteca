package menus;

import entidades.Libro;
import entidades.Usuario;
import servicios.LibroServicio;
import servicios.PrestamoServicio;
import servicios.UsuarioServicio;

import java.util.Scanner;

public class MenuPrestamo {
    private LibroServicio lServicio;
    private UsuarioServicio uServicio;
    private PrestamoServicio presServicio;
    private final Scanner scanner;

    public MenuPrestamo() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.lServicio = new LibroServicio();
        this.uServicio = new UsuarioServicio();
        this.presServicio = new PrestamoServicio();
    }

    public void presioneTecla() {
        System.out.println("");
        System.out.println("Presione ENTER para continuar...");
        scanner.next();
    }

    public void menuPrestamo() {
        int opcion;

        do {
            try {
                System.out.println("************************************************************");
                System.out.println("*             SISTEMA DE GESTIÓN DE BIBLIOTECA             *");
                System.out.println("************************************************************");
                System.out.println("<------------------ MENÚ PRESTAMO ------------------------->");
                System.out.println("");
                System.out.println("1) Realizar un pestamo a un Usuario.");
                System.out.println("2) Registrar la devolucion de un libro.");
                System.out.println("3) Mostrar una lista de libros prestados a un usuario especifico.");
                System.out.println("4) Ver lista de libros prestados.");
                System.out.println("5) Ver historial de prestamos de un libro.");
                System.out.println("6) Salir al menú principal.");

                System.out.println("");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el ID del Usuario a prestar:");
                        String userId = scanner.next();
                        Usuario usuario = uServicio.obtenerUsuarioPorId(userId);

                        System.out.println("Ingrese el ISBN del Libro a prestar:");
                        String isbn = scanner.next();
                        Libro libro = lServicio.obtenerLibroPorISBN(isbn);

                        // Mostrar los detalles del usuario y el libro si están disponibles
                        uServicio.mostrarUsuario(usuario);
                        lServicio.mostrarLibro(libro);

                        // Verificar si tanto el usuario como el libro fueron encontrados
                        if (usuario != null && libro != null) {
                            presServicio.prestarLibro(libro, usuario);
                            System.out.println("El préstamo se ha realizado con éxito.");
                        } else {
                            System.out.println("No se pudo completar el préstamo. Usuario o libro no encontrado.");
                        }
                        presioneTecla();
                        break;

//                    case 2:
//                        presServicio.obtenerTodosLosLibros();
//                        presioneTecla();
//                        break;
//                    case 3:
//                        presServicio.ingresarLibro();
//                        presioneTecla();
//                        break;
//                    case 4:
//                        System.out.println("Seleccione el ISBN del Libro a modificar de la siguiente lista:");
//                        presServicio.obtenerTodosLosLibros();
//                        presServicio.actualizarLibro(scanner.next());
//                        presioneTecla();
//                        break;
//                    case 5:
//                        System.out.println("Seleccione el ISBN del Libro a dar de baja de la siguiente lista:");
//                        presServicio.obtenerTodosLosLibros();
//                        presServicio.darDeBajaLibro(scanner.next());
//                        presioneTecla();
//                        break;
                    case 6:
                        System.out.println("Saliendo del menú Prestamos...");
                        presioneTecla();
                        break;
                    default:
                        System.out.println("Opción incorrecta. Seleccione un número de la lista de opciones del menú");
                        presioneTecla();
                        break;
                }
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("DEBE ingresar un número de la lista, no símbolos ni letras");
                presioneTecla();
                opcion = 0; // Restablecer la opción para evitar un bucle infinito
            }

        } while (opcion != 6);
    }
}
