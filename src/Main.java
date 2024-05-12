import builders.CuentaBancaria;
import functions.Functions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner rc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        try {
            while (true) {
                Functions.showMenu();
                try {
                    op = rc.nextInt();
                    switch (op) {
                        case 0:
                            System.out.println("---------------------------------------------------------");
                            System.out.println("¡Programa finalizado con éxito!");
                            break;
                        case 1:
                            Functions.handleCreate();
                            break;
                        case 2:
                            Functions.handleFind();
                            break;
                        case 3:
                            Functions.handleShow();
                            break;
                        default:
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            break;
                    }
                    if (op == 0)
                        break;
                } catch (InputMismatchException e) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Opcion inválida. Por favor, seleccione una numero entero.");
                    rc.nextLine();
                }
            }
        } finally {
            rc.close();
        }
    }
}
