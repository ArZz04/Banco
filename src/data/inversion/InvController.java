package data.inversion;

import builders.Cliente;
import builders.CuentaBancaria;
import builders.CuentaInversion;
import builders.CuentaNomina;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InvController {

    private static final String PATH = "src/data/inversion/";

    public static boolean addInversion(CuentaInversion cuentaInversion) {
        String FILENAME = PATH+cuentaInversion.getNCuenta()+".txt";
        File file = new File(FILENAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(cuentaInversion.getNCuenta() + "   | " + cuentaInversion.getCliente().getNombre() + " | " + cuentaInversion.getCliente().getApellidoP() + " | " + cuentaInversion.getCliente().getApellidoM() + " | " + cuentaInversion.getCliente().getDomicilio() + " | " + cuentaInversion.getCliente().getCiudad() + " | " + cuentaInversion.getCliente().getTelefono() + " | " + cuentaInversion.getSaldo() + " | " + cuentaInversion.getInteres() + " | " + cuentaInversion.getPlazo() + " | " + cuentaInversion.getFechAlta() );
                writer.newLine();
            } catch (IOException e) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void showInversiones() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        File directorio = new File(PATH);

        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                System.out.println("-------------------------------------------------------| INVERSIONES |-------------------------------------------------------");
                System.out.println("NCuenta | Nombre | ApellidoP | ApellidoM | Domicilio | Ciudad | Telefono | Inversion | Interes | Plazo | FechaAlta           ");

                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {

                        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            while ((linea = reader.readLine()) != null) {
                                String[] parts = linea.split("\\|");
                                if (parts.length == 11){
                                    int nCuenta = Integer.parseInt(parts[0].trim());
                                    String nombre = parts[1].trim();
                                    String apellidoPaterno = parts[2].trim();
                                    String apellidoMaterno = parts[3].trim();
                                    String domicilio = parts[4].trim();
                                    String ciudad = parts[5].trim();
                                    long telefono = Long.parseLong(parts[6].trim());
                                    double saldo = Double.parseDouble(parts[7].trim());
                                    double interes = Double.parseDouble(parts[8].trim());
                                    int plazo = Integer.parseInt(parts[9].trim());
                                    Date fechAlta = dateFormat.parse(parts[10].trim());

                                    Cliente client = new Cliente(nombre, apellidoPaterno, apellidoMaterno, domicilio, ciudad, telefono, "INVERSION");
                                    CuentaInversion account = new CuentaInversion(nCuenta, saldo, fechAlta, plazo, interes, client);
                                    System.out.println(account.getNCuenta() + " | " + client.getNombre() + " | " + client.getApellidoP() + " | " + client.getApellidoM() + " | " + client.getDomicilio() + " | " + client.getCiudad() + " | " + client.getTelefono() + " | $" + account.getSaldo() + " | " + account.getInteres() + "% | " + account.getPlazo() + " meses | " + account.getFechAlta() + " |");
                                }
                            }
                        } catch (IOException | ParseException e) {
                            System.err.println("Error al leer el archivo: " + archivo.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("La ruta especificada no es un directorio válido.");
        }
    }

}
