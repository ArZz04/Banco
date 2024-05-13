package functions;

import builders.CuentaNomina;
import data.accountManager;
import data.nominas.NomController;

import java.util.Scanner;

public class NomFunctions {

    static Scanner rc = new Scanner(System.in);

    public static void newPayroll(CuentaNomina newCuentaNomina) {
        try {
            NomController.addNomina(newCuentaNomina);
            accountManager.addCuenta(newCuentaNomina);
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de nómina: " + e.getMessage());
        }
    }

    public static void findPayroll() {

    }

    public static void showPayrolls() {
        try {
            NomController.showNominas();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de nómina: " + e.getMessage());
        }
    }

}
