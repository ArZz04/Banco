package functions;

import builders.CuentaNomina;
import data.accountManager;
import data.nominas.NomController;

public class NomFunctions {

    public static void newPayroll(CuentaNomina newCuentaNomina) {
        try {
            NomController.addNomina(newCuentaNomina);
            accountManager.addCuenta(newCuentaNomina);
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de nómina: " + e.getMessage());
        }
    }

    public static boolean findPayroll() {
        System.out.println("Buscando cuentas de nómina...");
        return false;
    }

    public static void showPayrolls() {
        try {
            NomController.showNominas();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de nómina: " + e.getMessage());
        }
    }

}
