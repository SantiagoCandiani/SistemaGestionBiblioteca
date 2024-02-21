import menus.MenuPrincipal;

public class SistemaGestionBibliotecaApp {
    public static void main(String[] args) {

        try {
            MenuPrincipal menuP = new MenuPrincipal();
            menuP.menuPrincipal();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//main
}//Class