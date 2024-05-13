package functions;

import builders.CuentaInversion;
import data.accountManager;
import data.inversion.InvController;

import java.util.Scanner;

public class InvFunctions {
    static Scanner rc = new Scanner(System.in);

    public static void newInvestment(CuentaInversion newCuentaInversion) {
        try {
            InvController.addInversion(newCuentaInversion);
            accountManager.addCuenta(newCuentaInversion);
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de inversion: " + e.getMessage());
        }
    }

    public static void findInvestment() {
        int op;
        do {
            System.out.println("----------------------| BUSCAR |----------------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    NomFunctions.findPayroll();
                    break;
                case 2:
                    InvFunctions.findInvestment();
                    break;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }

    public static void showInvestments() {
        try {
            InvController.showInversiones();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de Inversion: " + e.getMessage());
        }
    }

}
