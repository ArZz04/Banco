package functions;

import builders.Cliente;
import builders.CuentaBancaria;
import builders.CuentaInversion;
import builders.CuentaNomina;

import java.util.Date;
import java.util.InputMismatchException;
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
                        int nCuenta = generarNumeroCuenta(nombre.toUpperCase(), apellidoP.toUpperCase(), apellidoM.toUpperCase(), domicilio.toUpperCase(), ciudad.toUpperCase(), telefono);

                        if (!verifyNCuenta(nCuenta)) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Ya existe un usuario con sus datos.");
                            return;
                        }

                        double saldo = 0.0;
                        Date fechAlta = new Date();
                        Cliente cliente;

                        cliente = new Cliente(nombre.toUpperCase(), apellidoP.toUpperCase(), apellidoM.toUpperCase(), domicilio.toUpperCase(), ciudad.toUpperCase(), telefono, tipoCuenta);
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
                        Double mountInvest, interes;
                        int plazo;

                        if (!verifyNCuenta(nCuenta)) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Ya existe un usuario con sus datos.");
                            return;
                        }

                        try {
                            System.out.print("Cantidad a invertir: ");
                            mountInvest = rc.nextDouble();
                            try{
                                System.out.print("Ingrese el plazo (meses): ");
                                plazo = rc.nextInt();
                            }catch (Exception e){
                                System.out.println("--------------------------------------------------");
                                System.out.println("Por favor, ingrese un plazo válido.");
                                return;
                            }
                            try{
                                System.out.print("Ingrese el interes: ");
                                interes = rc.nextDouble();
                            }catch (Exception e){
                                System.out.println("--------------------------------------------------");
                                System.out.println("Por favor, ingrese un interes valido.");
                                return;
                            }
                        } catch (Exception e) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Por favor, ingrese una cifra válida.");
                            return;
                        }

                        double inversion = mountInvest;
                        Date fechAlta = new Date();
                        Cliente cliente;

                        cliente = new Cliente(nombre.toUpperCase(), apellidoP.toUpperCase(), apellidoM.toUpperCase(), domicilio.toUpperCase(), ciudad.toUpperCase(), telefono, tipoCuenta);
                        CuentaInversion newCuentaInversion = new CuentaInversion(nCuenta, inversion, fechAlta, plazo, interes, cliente);

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
        int usr;

        do {
            System.out.println("----------------| INGRESA EL USUARIO |----------------");
            System.out.print("->  ");

            try {
                usr = rc.nextInt();

                if (!verifyNCuenta(usr)) {
                    CuentaBancaria account = ExtraFunctions.returnFile(usr);
                    try {
                        String tipoCuenta = account.getCliente().getTipoCuenta();

                        if ("NOMINA".equals(tipoCuenta)) {
                            NomFunctions.showNoMenu((CuentaNomina) account);
                            System.out.println("-----------------| SESION CERRADA |-----------------");
                            return;
                        } else if ("INVERSION".equals(tipoCuenta)) {
                            if (account instanceof CuentaInversion) {
                                ((CuentaInversion) account).proyectarInversion();
                                return;
                            } else {
                                System.out.println("La cuenta de inversión no es válida.");
                            }
                        } else {
                            System.out.println("Tipo de cuenta desconocido");
                        }

                    } catch (NullPointerException e) {
                        System.out.println("La cuenta no existe o es inválida.");
                    }

                } else {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("El usuario ingresado no existe");
                    return;
                }
            } catch (InputMismatchException e) {
                // Consume the invalid input
                rc.nextLine();
                System.out.println("Usuario invalido. Ingrese un usuario valido.");
                usr = -1; // Set usr to an invalid value to avoid infinite loop
            }

        } while (usr != 0);

        rc.close(); // Close the scanner after the loop
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
