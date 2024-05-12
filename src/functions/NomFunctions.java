package functions;

import builders.CuentaNomina;
import data.accountManager;
import data.nominas.NomController;

public class NomFunctions {

    public static boolean newPayroll(CuentaNomina newCuentaNomina) {
        try {
            NomController.addNomina(newCuentaNomina);
            accountManager.addCuenta(newCuentaNomina);

            return true;
        }catch (Exception e) {
            System.out.println("Error al crear cuenta de nómina: " + e.getMessage());
            return false;
        }
    }

    public static boolean findPayroll() {
        // Lógica para buscar cuentas de nómina
        System.out.println("Buscando cuentas de nómina...");
        // Aquí puedes incluir la lógica específica para buscar cuentas de nómina en tu sistema
        return false;
    }

    public static void showPayrolls() {
        // Lógica para listar cuentas de nómina
        try {
            NomController.showNominas();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de nómina: " + e.getMessage());
        }
    }

}
