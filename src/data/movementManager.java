package data;

import builders.CuentaBancaria;
import builders.Movimientos;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class movementManager {
    private static final String FILENAME = "src/data/movimientos.txt";

    public static String addMovement(Movimientos movimiento){
        File file = new File(FILENAME);

        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                // Si no existe, crear el archivo
                file.createNewFile();
            }
            // Agregar la cuenta al archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(movimiento.getnCuenta() + " | " + movimiento.getTipo() + " | " + movimiento.getMonto() + " | " + movimiento.getSaldoAnterior() + " | " + movimiento.getSaldoNuevo() + " | " + movimiento.getFecha()) ;
                writer.newLine();
            } catch (IOException e) {
                return ("Error al agregar el movimiento a movimiento.txt ");
            }
        } catch (IOException e) {
            return ("Error al crear movimientos.txt ");
        }
        return null;
    }

    public static ArrayList<Movimientos> loadMovimientos() {
        ArrayList<Movimientos> movimientos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 6) {
                    int nCuenta = Integer.parseInt(parts[0]);
                    String tipo = parts[1];
                    double monto = Double.parseDouble(parts[2]);
                    double saldoAnterior = Double.parseDouble(parts[3]);
                    double saldoNuevo = Double.parseDouble(parts[4]);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                    Date fecha = dateFormat.parse(parts[5]);

                    Movimientos movimiento = new Movimientos(nCuenta, tipo, fecha, monto, saldoAnterior, saldoNuevo);
                    movimientos.add(movimiento);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return movimientos;
    }
}
