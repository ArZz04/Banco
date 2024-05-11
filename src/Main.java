import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner rc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        try {
            while (true) {
                mostrarMenuPrincipal();
                try {
                    op = rc.nextInt();
                    switch (op) {
                        case 0:
                            System.out.println("---------------------------------------");
                            System.out.println("¡Programa finalizado con éxito!");
                            break;
                        case 1:
                            handleCreate();
                            break;
                        case 2:
                            handleFind();
                            break;
                        case 3:
                            handleShow();
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            break;
                    }
                    if (op == 0)
                        break;
                } catch (InputMismatchException e) {
                    System.out.println("Opcion inválida. Por favor, seleccione una numero entero.");
                    rc.nextLine();
                }
            }
        } finally {
            rc.close();
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("--------------| BANCO |--------------");
        System.out.println("1.- Altas");
        System.out.println("2.- Buscar");
        System.out.println("3.- Listar");
        System.out.println("0.- Salir");
        System.out.print("- Selecciona una opcion ->  ");
    }

    private static void handleCreate() {
        int op;
        do {
            System.out.println("--------------| ALTA |--------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    // dar de alta una cuenta de nómina
                    break;
                case 2:
                    // dar de alta una cuenta de inversión
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }

    private static void handleFind() {
        int op;
        do {
            System.out.println("--------------| BUSCAR |--------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    // listar cuentas de nómina
                    break;
                case 2:
                    // listar cuentas de inversión
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, Seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }

    private static void handleShow() {
        int op;
        do {
            System.out.println("--------------| LISTAR |--------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    // listar cuentas de nómina
                    break;
                case 2:
                    // listar cuentas de inversión
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }
}
