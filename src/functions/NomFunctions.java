package functions;

import builders.CuentaNomina;
import builders.Movimientos;
import data.accountManager;
import data.movementManager;
import data.nominas.NomController;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public static void showPayrolls() {
        try {
            NomController.showNominas();
        }catch (Exception e) {
            System.out.println("Error al mostrar cuentas de nómina: " + e.getMessage());
        }
    }

    public static void showNoMenu(CuentaNomina account){
        ArrayList<Movimientos> movimientos = movementManager.loadMovimientos();
        account.setMovimientos(movimientos);

        int op;

        System.out.println("-----------------------------------------------------------------");
        System.out.println("-------------------| BIENVENID@ " + account.getCliente().getNombre() +" |--------------------------");
        System.out.println("1.- Depositar");
        System.out.println("2.- Retirar");
        System.out.println("3.- Consultar Saldo");
        System.out.println("4.- Imprimir Movimientos");
        System.out.println("0.- Regresar");
        System.out.print("- Selecciona una opcion ->  ");

        try {
            op = rc.nextInt();
            switch (op) {
                case 0:
                    return;
                case 1:
                    depositar(account);
                    return;
                case 2:
                    retirar(account);
                    return;
                case 3:
                    consultar(account);
                    return;
                case 4:
                    imprimirMovimientos(account);
                    return;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Opcion inválida. Por favor, seleccione una numero entero.");
            rc.nextLine();
        }
    }

    private static void depositar(CuentaNomina account){
        double amount = 0;
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------| DEPOSITAR |-----------------------");
        System.out.print("- Ingrese el monto a depositar -> ");
        try {
            amount = rc.nextDouble();
            account.depositar(amount);
        }catch (Exception e){
            System.out.println("Monto invalido..");
        }
    }

    private static void retirar(CuentaNomina account) {
        double amount = 0;
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------| RETIRAR |-----------------------");
        System.out.print("- Ingrese el monto a retirar -> ");
        while (true) {
            try {
                amount = rc.nextDouble();
                account.retirar(amount);
                break;
            } catch (Exception e) {
                System.out.println("Error: Monto inválido. Por favor, ingrese un valor numérico válido.");
            }
        }
    }
    private static void consultar(CuentaNomina account){
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------| CONSULTAR |-----------------------");
        System.out.print(" Su saldo actual es de: " + account.getSaldo());
        System.out.println("---------------------------------------------------------");
    }

    private static void imprimirMovimientos(CuentaNomina account){
        int i = 1;
        boolean flag = false;
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------| MOVIMIENTOS DEL USUARIO |---------------");
        try {
            for (Movimientos movimiento : account.getMovimientos()) {
                if (movimiento.getnCuenta() == account.getNCuenta()) {
                    System.out.println("--------------------------| Movimiento " + i + " |--------------------------");
                    System.out.println("ID: " + movimiento.getnCuenta());
                    System.out.println("Tipo: " + movimiento.getTipo());
                    System.out.println("Fecha: " + movimiento.getFecha());
                    System.out.println("Monto: " + movimiento.getMonto());
                    System.out.println("Saldo Anterior: " + movimiento.getSaldoAnterior());
                    System.out.println("Saldo Nuevo: " + movimiento.getSaldoNuevo());
                    System.out.println("---------------------------------------------------------");
                    i++;
                }else if (!flag){
                    System.out.println("------------| EL USUARIO NO TIENE MOVIMIENTOS |-----------");
                    flag = true;
                }
            }
        }catch (Exception e){
            System.out.println("Error al obtener movimientos");
        }
    }

}
