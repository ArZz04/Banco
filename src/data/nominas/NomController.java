package data.nominas;

import builders.CuentaNomina;

import java.io.*;

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

    public static void showNominas() {
        // Crear un objeto File con la ruta del directorio
        File directorio = new File(PATH);

        // Verificar si el objeto File representa un directorio válido
        if (directorio.isDirectory()) {
            // Obtener la lista de archivos y subdirectorios dentro del directorio
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println("NCuenta | Nombre | ApellidoP | ApellidoM | Domicilio | Ciudad | FechaAlta           | Saldo");

                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {

                        // Leer y mostrar el contenido del archivo
                        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            while ((linea = reader.readLine()) != null) {
                                System.out.println(linea);
                            }
                        } catch (IOException e) {
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
