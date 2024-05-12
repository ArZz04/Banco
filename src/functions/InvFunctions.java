package functions;

import builders.CuentaInversion;
import data.accountManager;
import data.inversion.InvController;
import data.nominas.NomController;

public class InvFunctions {

    public static boolean newInvestment(CuentaInversion newCuentaInversion) {
        try {
            InvController.addInversion(newCuentaInversion);
            accountManager.addCuenta(newCuentaInversion);
            return true;
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de inversion: " + e.getMessage());
            return false;
        }
    }

    public static void findInvestment() {
        // Lógica para buscar cuentas de inversión
        System.out.println("Buscando cuentas de inversión...");
        // Aquí puedes incluir la lógica específica para buscar cuentas de inversión en tu sistema
    }

    public static void showInvestments() {
        // Lógica para listar cuentas de inversión
        try {
            InvController.showInversiones();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de Inversion: " + e.getMessage());
        }
    }

}
