package functions;

import builders.Cliente;
import builders.CuentaInversion;
import builders.CuentaNomina;

import java.util.Date;
import java.util.Scanner;

import static data.accountManager.verifyNCuenta;
import static functions.ExtraFunctions.generarNumeroCuenta;

public class Functions {

    static Scanner rc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("----------------------| BANCO |----------------------");
        System.out.println("1.- Altas");
        System.out.println("2.- Buscar");
        System.out.println("3.- Listar");
        System.out.println("0.- Salir");
        System.out.print("- Selecciona una opcion ->  ");
    }

    public static void handleCreate() {

        String nombre, apellidoP, apellidoM, domicilio, ciudad;
        String tipoCuenta;
        long telefono = 0;

        int op;
        do {
            System.out.println("----------------------| ALTA |----------------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("-----------------------| NOMINA |------------------------");

                    tipoCuenta = "NOMINA";

                    // Solicitar información al usuario y almacenarla en las variables
                    try{
                        System.out.print("Nombre(s): ");
                        nombre = rc.next();
                        System.out.print("Apellido Paterno: ");
                        apellidoP = rc.next();
                        System.out.print("Apellido Materno: ");
                        apellidoM = rc.next();
                        System.out.print("Domicilio: ");
                        domicilio = rc.next();
                        System.out.print("Ciudad: ");
                        ciudad = rc.next();
                        System.out.print("Telefono: ");
                    }catch (Exception e){
                        System.out.println("--------------------------------------------------");
                        System.out.println("Por favor, ingrese un String válido.");
                        return;
                    }finally {
                        try {
                            telefono = rc.nextLong();
                        } catch (Exception e) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Por favor, ingrese un número de teléfono válido.");
                        }
                    }

                    try {
                        int nCuenta = generarNumeroCuenta(nombre, apellidoP, apellidoM, domicilio, ciudad, telefono);

                        if (!verifyNCuenta(nCuenta)) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Ya existe un usuario con sus datos.");
                            return;
                        }

                        double saldo = 0.0;
                        Date fechAlta = new Date();
                        Cliente cliente;

                        cliente = new Cliente(nombre, apellidoP, apellidoM, domicilio, ciudad, telefono, tipoCuenta);
                        CuentaNomina newCuentaNomina = new CuentaNomina( nCuenta, saldo, fechAlta, cliente);

                        NomFunctions.newPayroll(newCuentaNomina);

                    }catch (Exception e) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Hubo un error al generar el número de cuenta.");
                        return;
                    }
                    break;
                case 2:


                    System.out.println("---------------------------------------------------------");
                    System.out.println("---------------------| INVERSION |-----------------------");

                    tipoCuenta = "INVERSION";


                    // Solicitar información al usuario y almacenarla en las variables
                    try{
                        System.out.print("Nombre(s): ");
                        nombre = rc.next();
                        System.out.print("Apellido Paterno: ");
                        apellidoP = rc.next();
                        System.out.print("Apellido Materno: ");
                        apellidoM = rc.next();
                        System.out.print("Domicilio: ");
                        domicilio = rc.next();
                        System.out.print("Ciudad: ");
                        ciudad = rc.next();
                        System.out.print("Telefono: ");
                    }catch (Exception e){
                        System.out.println("--------------------------------------------------");
                        System.out.println("Por favor, ingrese un String válido.");
                        return;
                    }finally {
                        try {
                            telefono = rc.nextLong();
                        } catch (Exception e) {
                                System.out.println("--------------------------------------------------");
                                System.out.println("Por favor, ingrese un número de teléfono válido.");
                        }
                    }

                    try {
                        int nCuenta = generarNumeroCuenta(nombre, apellidoP, apellidoM, domicilio, ciudad, telefono);
                        Double mountInvest;

                        if (!verifyNCuenta(nCuenta)) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Ya existe un usuario con sus datos.");
                            return;
                        }

                        try {
                            System.out.print("Cantidad a invertir: ");
                            mountInvest = rc.nextDouble();
                        } catch (Exception e) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Por favor, ingrese una cifra válida.");
                            return;
                        }

                        double saldo = mountInvest;
                        Date fechAlta = new Date();
                        Cliente cliente;

                        cliente = new Cliente(nombre, apellidoP, apellidoM, domicilio, ciudad, telefono, tipoCuenta);
                        CuentaInversion newCuentaInversion = new CuentaInversion(nCuenta, saldo, fechAlta, cliente);

                        InvFunctions.newInvestment(newCuentaInversion);

                    }catch (Exception e) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Hubo un error al generar el número de cuenta.");
                        return;
                    }
                    break;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }

    public static void handleFind() {
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

    public static void handleShow() {
        int op;
        do {
            System.out.println("----------------------| LISTAR |----------------------");
            System.out.println("1.- Nominas");
            System.out.println("2.- Inversion");
            System.out.println("0.- Regresar");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op){
                case 0:
                    break;
                case 1:
                    NomFunctions.showPayrolls();
                    break;
                case 2:
                    InvFunctions.showInvestments();
                    break;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (op != 0);
    }

}
