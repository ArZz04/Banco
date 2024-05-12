package data.inversion;

import builders.CuentaInversion;

import java.io.*;

public class InvController {

    private static final String PATH = "src/data/inversion/";

    public static boolean addInversion(CuentaInversion cuentaInversion) {
        String FILENAME = PATH+cuentaInversion.getNCuenta()+".txt";
        File file = new File(FILENAME);

        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                // Si no existe, crear el archivo
                file.createNewFile();
            }

            // Agregar la informacion al archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(cuentaInversion.getNCuenta() + " | " + cuentaInversion.getCliente().getNombre() + " | " + cuentaInversion.getCliente().getApellidoP() + " | " + cuentaInversion.getCliente().getApellidoM() + " | " + cuentaInversion.getCliente().getDomicilio() + " | " + cuentaInversion.getCliente().getCiudad() + " | " + cuentaInversion.getCliente().getSaldo() + " | " + cuentaInversion.getFechAlta() );
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
        // Crear un objeto File con la ruta del directorio
        File directorio = new File(PATH);

        // Verificar si el objeto File representa un directorio válido
        if (directorio.isDirectory()) {
            // Obtener la lista de archivos y subdirectorios dentro del directorio
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println("NCuenta | Nombre | ApellidoP | ApellidoM | Domicilio | Ciudad | FechaAlta           | Inversion");

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
