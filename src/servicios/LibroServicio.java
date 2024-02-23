package servicios;

import entidades.Libro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LibroServicio {

    private final List<Libro> listaLibros;
    private final Scanner scanner;

    public LibroServicio() {
        this.listaLibros = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    //Metodo para precargar una lista de Libros (Lo uso para hacer pruebas!!!):
    public void ingresarLibrosPrecargados() {
        listaLibros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "9788445071410", "Fantasía", 10, new ArrayList<>(Collections.singletonList("Excelente")), new ArrayList<>(Collections.singletonList(10)), true, true));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "9780307350476", "Realismo mágico", 15, new ArrayList<>(Collections.singletonList("Apasionante")), new ArrayList<>(Collections.singletonList(5)), true, true));
        listaLibros.add(new Libro("1984", "George Orwell", "9780451524935", "Ciencia ficción", 20, new ArrayList<>(Collections.singletonList("No me gusto")), new ArrayList<>(Collections.singletonList(1)), true, true));
        listaLibros.add(new Libro("Matar un ruiseñor", "Harper Lee", "9780061120084", "Ficción", 12, new ArrayList<>(Collections.singletonList("Arranco bien pero feo final")), new ArrayList<>(Collections.singletonList(5)), true, true));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "9788424116796", "Novela", 55, new ArrayList<>(Collections.singletonList("Un tanto aburrido pero bien escrito")), new ArrayList<>(Collections.singletonList(8)), true, true));
        System.out.println("Lista de Libros ingresada exitosamente.");
    }


    //Método para mostrar todos los libros
    public void obtenerTodosLosLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
        } else {
            for (Libro libro : listaLibros) {
                System.out.println(libro.toString());
            }
        }
    }

    //Método para crear un libro
    public void ingresarLibro() {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el ISBN del libro:");
        String ISBN = scanner.nextLine();

        System.out.println("Ingrese el género del libro:");
        String genero = scanner.nextLine();

        System.out.println("Ingrese la cantidad existente del libro:");
        int cantExistente = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        // Inicialmente, el libro esta activo y disponible, sin reseñas ni calificacion
        ArrayList<String> resenias = new ArrayList<>();
        ArrayList<Integer> calificaciones = new ArrayList<>();
        boolean disponibilidad = true;
        boolean activo = true;

        Libro libro = new Libro(titulo, autor, ISBN, genero, cantExistente, resenias, calificaciones, disponibilidad, activo);
        listaLibros.add(libro);

        System.out.println("Libro ingresado exitosamente.");
    }


    // Método para actualizar un libro
    public void actualizarLibro(String ISBN) {
        Libro libro = obtenerLibroPorISBN(ISBN);

        if (libro != null) {
            System.out.println("Libro encontrado. Ingrese los nuevos datos:");

            System.out.print("Titulo: ");
            libro.setTitulo(scanner.nextLine());

            System.out.print("Autor: ");
            libro.setAutor(scanner.nextLine());

            System.out.print("ISBN: ");
            libro.setISBN(scanner.nextLine());

            System.out.print("Genero: ");
            libro.setGenero(scanner.nextLine());

            System.out.print("Cantidad: ");
            libro.setCantExistente(scanner.nextInt());

            System.out.println("Libro actualizado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    // Método para dar de baja un libro
    public void darDeBajaLibro(String ISBN) {
        Libro libro = obtenerLibroPorISBN(ISBN);

        if (libro != null) {
            libro.setActivo(false);
            System.out.println("El libro ha sido dado de baja exitosamente.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }

    // Método para dar de baja todos los libros sin borrarlos
    public void darDeBajaTodosLosLibros() {
        for (Libro libro : listaLibros) {
            libro.setActivo(false);
        }
        System.out.println("Se han dado de baja todos los libros.");
    }

    // Método para obtener un libro por ID
    public Libro obtenerLibroPorISBN(String ISBN) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null; // Retorna null si no se encuentra ningún libro con el ISBN proporcionado
    }

    // Método para mostrar un libro
    public void mostrarLibro(Libro libro) {
        if (libro != null) {
            System.out.println(libro.toString());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    // Método para buscar libros por titulo
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(libro);
            }
        }
        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con el titulo '" + titulo + "'.");
        }
        return librosEncontrados;
    }

    // Método para buscar libros por titulo
    public List<Libro> buscarLibrosPorGenero(String genero) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : listaLibros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                librosEncontrados.add(libro);
            }
        }
        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con el genero '" + genero + "'.");
        }
        return librosEncontrados;
    }

    // Método para mostrar una lista de libros
    public void mostrarLibros(List<Libro> libros) {
        if (!libros.isEmpty()) {
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("No se encontraron libros con ese titulo.");
        }
    }

    public void dejarResenia(String ISBN) {
        Libro libro = obtenerLibroPorISBN(ISBN);

        if (libro != null) {
            System.out.println("Libro encontrado. Ingrese la reseña:");

            System.out.print("Reseña: ");
            String resenia = scanner.nextLine();
            libro.getResenias().add(resenia);

            System.out.println("Libro reseñado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public void calificarLibro(String ISBN) {
        Libro libro = obtenerLibroPorISBN(ISBN);

        if (libro != null) {
            System.out.println("Libro encontrado. Ingrese la calificación:");

            System.out.print("Calificación: ");
            int calificacion = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            libro.getCalificaciones().add(calificacion);

            System.out.println("Libro calificado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }


}//Class
