package data.nominas;

import builders.Cliente;
import builders.CuentaBancaria;
import builders.CuentaNomina;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class NomController {

    private static final String PATH = "src/data/nominas/";

    public static Boolean addNomina(CuentaNomina cuentaNomina) {
        String FILENAME = PATH+cuentaNomina.getNCuenta()+".txt";
        File file = new File(FILENAME);

        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                // Si no existe, crear el archivo
                file.createNewFile();
            }

            // Agregar la informacion al archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(cuentaNomina.getNCuenta() + " | " + cuentaNomina.getCliente().getNombre() + " | " + cuentaNomina.getCliente().getApellidoP() + " | " + cuentaNomina.getCliente().getApellidoM() + " | " + cuentaNomina.getCliente().getDomicilio() + " | " + cuentaNomina.getCliente().getCiudad() + " | " + cuentaNomina.getCliente().getTelefono() + " | " + cuentaNomina.getSaldo() + " | " + cuentaNomina.getFechAlta() );
                writer.newLine();
            } catch (IOException e) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void refreshSaldo(long nCuenta, double nuevoSaldo) {
        String FILENAME = PATH + nCuenta + ".txt";
        File file = new File(FILENAME);

        try {
            // Verificar si el archivo existe
            if (file.exists()) {
                // Leer las líneas del archivo y actualizar el saldo
                List<String> lines = Files.readAllLines(file.toPath());
                for (int i = 0; i < lines.size(); i++) {
                    String[] parts = lines.get(i).split(" \\| ");
                    if (parts.length > 7 && Long.parseLong(parts[0]) == nCuenta) {
                        parts[7] = Double.toString(nuevoSaldo);
                        lines.set(i, String.join(" | ", parts));
                        break; // Terminar el bucle después de encontrar y actualizar el saldo
                    }
                }

                // Escribir las líneas actualizadas de vuelta al archivo
                Files.write(file.toPath(), lines);
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showNominas() {
        // Crear un objeto File con la ruta del directorio
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        File directorio = new File(PATH);

        // Verificar si el objeto File representa un directorio válido
        if (directorio.isDirectory()) {
            // Obtener la lista de archivos y subdirectorios dentro del directorio
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                System.out.println("----------------------------------------------| NOMINAS |----------------------------------------------");
                System.out.println("NCuenta | Nombre | ApellidoP | ApellidoM | Domicilio | Ciudad | Telefono | Saldo | FechaAlta           ");

                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {

                        // Leer y mostrar el contenido del archivo
                        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            while ((linea = reader.readLine()) != null) {
                                String[] parts = linea.split("\\|");
                                if (parts.length == 9){
                                    int nCuenta = Integer.parseInt(parts[0].trim());
                                    String nombre = parts[1].trim();
                                    String apellidoPaterno = parts[2].trim();
                                    String apellidoMaterno = parts[3].trim();
                                    String domicilio = parts[4].trim();
                                    String ciudad = parts[5].trim();
                                    long telefono = Long.parseLong(parts[6].trim());
                                    double saldo = Double.parseDouble(parts[7].trim());
                                    Date fechAlta = dateFormat.parse(parts[8].trim());
                                    Cliente client = new Cliente(nombre, apellidoPaterno, apellidoMaterno, domicilio, ciudad, telefono, "NOMINA");
                                    CuentaBancaria account = new CuentaNomina(nCuenta, saldo, fechAlta, client);
                                    System.out.println(account.getNCuenta() + " | " + client.getNombre() + " | " + client.getApellidoP() + " | " + client.getApellidoM() + " | " + client.getDomicilio() + " | " + client.getCiudad() + " | " + client.getTelefono() + " | $" + account.getSaldo() + " | " + account.getFechAlta() + " |");
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
