package menus;

import servicios.LibroServicio;

import java.util.Scanner;

public class MenuLibro {
    private final Scanner scanner;
    private LibroServicio lServicio;

    public MenuLibro() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.lServicio = new LibroServicio();
    }

    public void presioneTecla() {
        System.out.println("");
        System.out.println("Presione ENTER para continuar...");
        scanner.next();
    }

    public void menuLibro() {
        int opcion;

        do {
            try {
                System.out.println("************************************************************");
                System.out.println("*             SISTEMA DE GESTIÓN DE BIBLIOTECA             *");
                System.out.println("************************************************************");
                System.out.println("<------------------ MENÚ LIBROS ------------------------->");
                System.out.println("");
                System.out.println("1) Insertar Lista de Libros Precargada.");
                System.out.println("2) Ver Lista de Libros Completa.");
                System.out.println("3) Insertar un nuevo Libro.");
                System.out.println("4) Editar un Libro.");
                System.out.println("5) Dar de Baja un Libro.");
                System.out.println("6) Dar de Baja todos los Libros.");
                System.out.println("7) Buscar un Libro por ISBN.");
                System.out.println("8) Filtrar libros por titulo.");
                System.out.println("9) Filtrar libros por genero.");
                System.out.println("10) Filtrar libros por Autor.");
                System.out.println("11) Dejar la reseña a un libro.");
                System.out.println("12) Calificar un libro.");
                System.out.println("13) Salir al menú principal.");

                System.out.println("");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        lServicio.ingresarLibrosPrecargados();
                        presioneTecla();
                        break;
                    case 2:
                        lServicio.obtenerTodosLosLibros();
                        presioneTecla();
                        break;
                    case 3:
                        lServicio.ingresarLibro();
                        presioneTecla();
                        break;
                    case 4:
                        System.out.println("Seleccione el ISBN del Libro a modificar de la siguiente lista:");
                        lServicio.obtenerTodosLosLibros();
                        lServicio.actualizarLibro(scanner.next());
                        presioneTecla();
                        break;
                    case 5:
                        System.out.println("Seleccione el ISBN del Libro a dar de baja de la siguiente lista:");
                        lServicio.obtenerTodosLosLibros();
                        lServicio.darDeBajaLibro(scanner.next());
                        presioneTecla();
                        break;
                    case 6:
                        lServicio.darDeBajaTodosLosLibros();
                        presioneTecla();
                        break;
                    case 7:
                        System.out.println("Ingrese el ISBN del Libro:");
                        lServicio.mostrarLibro(lServicio.obtenerLibroPorISBN(scanner.next()));
                        presioneTecla();
                        break;
                    case 8:
                        System.out.println("Ingrese el titulo del Libro:");
                        String titulo = scanner.next();
                        lServicio.mostrarLibros(lServicio.buscarLibrosPorTitulo(titulo));
                        presioneTecla();
                        break;
                    case 9:
                        System.out.println("Ingrese el genero de Libros que desea mostrar:");
                        String genero = scanner.next();
                        lServicio.mostrarLibros(lServicio.buscarLibrosPorGenero(genero));
                        presioneTecla();
                        break;
                    case 10:
                        System.out.println("Ingrese el nombre completo del autor:");
                        String autor = scanner.next();
                        lServicio.mostrarLibros(lServicio.buscarLibrosPorAutor(autor));
                        presioneTecla();
                        break;
                    case 11:
                        System.out.println("Seleccione el ISBN del Libro a reseñar de la siguiente lista:");
                        lServicio.obtenerTodosLosLibros();
                        lServicio.dejarResenia(scanner.next());
                        presioneTecla();
                        break;
                    case 12:
                        System.out.println("Seleccione el ISBN del Libro a calificar de la siguiente lista:");
                        lServicio.obtenerTodosLosLibros();
                        lServicio.calificarLibro(scanner.next());
                        presioneTecla();
                        break;
                    case 13:
                        System.out.println("Saliendo del menú Libro...");
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

        } while (opcion != 13);
    }
}
