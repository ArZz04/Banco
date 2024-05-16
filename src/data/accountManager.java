package data;

import builders.CuentaBancaria;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class accountManager {
    private static final String FILENAME = "src/data/accounts.txt";

    public static String addCuenta(CuentaBancaria cuenta) {
        File file = new File(FILENAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            // Agregar la cuenta al archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(cuenta.getNCuenta() + "," + cuenta.getCliente().getNombre() + "," + cuenta.getFechAlta());
                writer.newLine();
            } catch (IOException e) {
                return ("Error al agregar la cuenta a accounts.txt ");
            }
        } catch (IOException e) {
            return ("Error al crear accounts.txt ");
        }
        return null;
    }

    public static boolean verifyNCuenta(long nCuenta) {
        ArrayList<CuentaBancaria> cuentas = leerCuentas();
        for (CuentaBancaria cuenta : cuentas) {
            if (Long.valueOf(cuenta.getNCuenta()).equals(nCuenta)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<CuentaBancaria> leerCuentas() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int nCuenta = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                Date date = dateFormat.parse(parts[2]);

                CuentaBancaria cuenta = new CuentaBancaria(nCuenta, nombre, date );
                cuentas.add(cuenta);
            }
        } catch (Exception e) {
            System.out.println("Error al leer cuentas: " + e.getMessage());
        }
        return cuentas;
    }

}
