package menus;

import java.util.Scanner;

public class MenuPrincipal {

    private MenuUsuario menuUsu;
    //private MenuLibro menuLib;
    //private MenuPrestamo menuPres;
    //private MenuInventario menuInv;
    private final Scanner scanner;

    public MenuPrincipal() {
        this.menuUsu = new MenuUsuario();
        //this.menuLib = new MenuLibro();
        //this.menuPres = new MenuPrestamo();
        //this.menuInv = new MenuIventario();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public void presioneTecla() {
        System.out.println("");
        System.out.println("Presione ENTER para continuar...");
        scanner.next();
    }

    public void menuPrincipal() {
        int opcion;

        do {
            try {
                System.out.println("************************************************************");
                System.out.println("*             SISTEMA DE GESTIÓN DE BIBLIOTECA             *");
                System.out.println("************************************************************");
                System.out.println("<----------------- MENÚ PRINCIPAL ------------------------>");
                System.out.println("1) Gestion de Usuarios.");
                System.out.println("2) Gestion de Libros.");
                System.out.println("3) Gestion de Prestamos.");
                System.out.println("4) Gestion de Inventarios.");
                System.out.println("5) Salir del programa.");

                System.out.println("");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        menuUsu.menuUsuario();
                        presioneTecla();
                        menuPrincipal();
                        break;
                    //case 2:
                    //    menuLib.menuLibro();
                    //    presioneTecla();
                    //    menuPrincipal();
                    //    break;
                    //case 3:
                    //    menuPres.menuPrestamo();
                    //    presioneTecla();
                    //    menuPrincipal();
                    //    break;
                    //case 4:
                    //    menuInv.menuInventario();
                    //    presioneTecla();
                    //    menuPrincipal();
                    //    break;
                    case 5:
                        System.out.println("Usted Salio del programa con Exito.");
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Seleccione un numero de la lista opciones del menu");
                        System.out.println("");
                        break;
                }
            } catch (Exception e) {
                System.out.println("DEBE ingresar un número de la lista, no símbolos ni letras");
                presioneTecla();
                opcion = 0; // Restablecer la opción para evitar un bucle infinito
            }
        } while (opcion != 5);
    }//menuPrincipal

}//class
