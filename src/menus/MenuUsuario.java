package menus;

import servicios.UsuarioServicio;

import java.util.Scanner;

public class MenuUsuario {

    private final Scanner scanner;
    private UsuarioServicio uServicio;

    public MenuUsuario() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.uServicio = new UsuarioServicio();
    }

    public void presioneTecla() {
        System.out.println("");
        System.out.println("Presione ENTER para continuar...");
        scanner.next();
    }

    public void menuUsuario() {
        int opcion;

        do {
            try {
                System.out.println("************************************************************");
                System.out.println("*             SISTEMA DE GESTIÓN DE BIBLIOTECA             *");
                System.out.println("************************************************************");
                System.out.println("<------------------ MENÚ USUARIOS ------------------------->");
                System.out.println("");
                System.out.println("1) Insertar Lista de Usuarios Precargada.");
                System.out.println("2) Ver Lista de Usuarios Completa.");
                System.out.println("3) Insertar un nuevo Usuario.");
                System.out.println("4) Editar un Usuario.");
                System.out.println("5) Dar de Baja un Usuario.");
                System.out.println("6) Dar de Baja todos los Usuarios.");
                System.out.println("7) Buscar un Usuario por ID.");
                System.out.println("8) Buscar un Usuario por su nombre completo.");
                System.out.println("9) Salir al menú principal.");

                System.out.println("");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        uServicio.ingresarUsuariosPrecargados();
                        presioneTecla();
                        break;
                    case 2:
                        uServicio.obtenerTodosLosUsuarios();
                        presioneTecla();
                        break;
                    case 3:
                        uServicio.ingresarUsuario();
                        presioneTecla();
                        break;
                    case 4:
                        System.out.println("Seleccione el ID del Usuario a modificar de la siguiente lista:");
                        uServicio.obtenerTodosLosUsuarios();
                        uServicio.actualizarUsuario(scanner.next());
                        presioneTecla();
                        break;
                    case 5:
                        System.out.println("Seleccione el ID del Usuario a dar de baja de la siguiente lista:");
                        uServicio.obtenerTodosLosUsuarios();
                        uServicio.darDeBajaUsuario(scanner.next());
                        presioneTecla();
                        break;
                    case 6:
                        uServicio.darDeBajaTodosLosUsuarios();
                        presioneTecla();
                        break;
                    case 7:
                        System.out.println("Ingrese el ID del Usuario:");
                        uServicio.mostrarUsuario(uServicio.obtenerUsuarioPorId(scanner.next()));
                        presioneTecla();
                        break;
                    case 8:
                        System.out.println("Ingrese el nombre del Usuario:");
                        String nombre = scanner.next();
                        System.out.println("Ingrese el apellido del Usuario:");
                        String apellido = scanner.next();
                        uServicio.mostrarUsuarios(uServicio.buscarUsuariosPorNombreYApellido(nombre, apellido));
                        presioneTecla();
                        break;
                    case 9:
                        System.out.println("Saliendo del menú Usuario...");
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

        } while (opcion != 9);
    }
}