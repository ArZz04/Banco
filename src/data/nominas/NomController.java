package data.nominas;

import builders.CuentaNomina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                writer.write(cuentaNomina.getNCuenta() + " | " + cuentaNomina.getCliente().getNombre() + " | " + cuentaNomina.getCliente().getApellidoP() + " | " + cuentaNomina.getCliente().getApellidoM() + " | " + cuentaNomina.getCliente().getDomicilio() + " | " + cuentaNomina.getCliente().getCiudad() + " | " + cuentaNomina.getFechAlta() + " | " + cuentaNomina.getSaldo() );
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
