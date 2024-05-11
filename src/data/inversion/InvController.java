package data.inversion;

import builders.CuentaInversion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InvController {

    private static final String PATH = "src/data/inversion/";

    public static boolean addInversion(CuentaInversion cuentaInversion) {
        String FILENAME = PATH+cuentaInversion.getNCuenta()+".txt";
        File file = new File(FILENAME);
        System.out.println(FILENAME);

        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                // Si no existe, crear el archivo
                file.createNewFile();
            }

            // Agregar la informacion al archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(cuentaInversion.getNCuenta() + " | " + cuentaInversion.getCliente().getNombre() + " | " + cuentaInversion.getCliente().getApellidoP() + " | " + cuentaInversion.getCliente().getApellidoM() + " | " + cuentaInversion.getCliente().getCiudad() + " | " + cuentaInversion.getFechAlta() + " | " + cuentaInversion.getSaldo() );
                writer.newLine();
            } catch (IOException e) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
