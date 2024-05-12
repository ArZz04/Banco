package functions;

import builders.CuentaInversion;
import data.accountManager;
import data.inversion.InvController;

public class InvFunctions {

    public static void newInvestment(CuentaInversion newCuentaInversion) {
        try {
            InvController.addInversion(newCuentaInversion);
            accountManager.addCuenta(newCuentaInversion);
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de inversion: " + e.getMessage());
        }
    }

    public static void findInvestment() {
        System.out.println("Buscando cuentas de inversión...");
    }

    public static void showInvestments() {
        try {
            InvController.showInversiones();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de Inversion: " + e.getMessage());
        }
    }

}
