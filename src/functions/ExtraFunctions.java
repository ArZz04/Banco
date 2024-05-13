package functions;

import builders.Cliente;
import builders.CuentaBancaria;
import builders.CuentaInversion;
import builders.CuentaNomina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExtraFunctions {

    public static int generarNumeroCuenta(String nombre, String apellidoP, String apellidoM, String domicilio, String ciudad, long telefono) {
        // Convertir datos a formato adecuado
        String nombreMin = nombre.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        String apellidoPMin = apellidoP.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        String apellidoMMin = apellidoM.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        String domicilioMin = domicilio.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        String ciudadMin = ciudad.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        String telefonoStr = String.valueOf(telefono).replace(" ", "").replace("-", "");

        String datosCombinados = nombreMin + "|" + apellidoPMin + "|" + apellidoMMin + "|" + domicilioMin + "|" + ciudadMin + "|" + telefonoStr;

        String hashHex  = generarHash(datosCombinados);

        String numberReduction = hashHex.substring(hashHex.length() - 4);

        int nCuenta = Integer.parseInt(numberReduction, 16);

        return nCuenta;
    }

    private static String generarHash(String datosCombinados) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(datosCombinados.getBytes());
            BigInteger hashBigInteger = new BigInteger(1, hashBytes);
            String hashHex = hashBigInteger.toString(16);
            return hashHex;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CuentaBancaria returnFile(int usr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        String[] filePaths = {"/Users/juanarvizu/ArZzDev/java/tecmm/poo/Banco/src/data/inversion", "/Users/juanarvizu/ArZzDev/java/tecmm/poo/Banco/src/data/nominas"};

        try {
            for (String filePath : filePaths) {
                File directory = new File(filePath);
                if (directory.isDirectory()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                                if (file.getName().equalsIgnoreCase(usr + ".txt")) {
                                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                                        String line;
                                        while ((line = reader.readLine()) != null) {
                                            String[] parts = line.split("\\|");

                                            int nCuenta = Integer.parseInt(parts[0].trim());
                                            String nombre = parts[1].trim();
                                            String apellidoPaterno = parts[2].trim();
                                            String apellidoMaterno = parts[3].trim();
                                            String domicilio = parts[4].trim();
                                            String ciudad = parts[5].trim();
                                            long telefono = Long.parseLong(parts[6].trim());
                                            double saldo = Double.parseDouble(parts[7].trim());

                                            Date fechAlta = null;
                                            int plazo = 0;
                                            double interes = 0.0;
                                            String tipoCuenta = filePath.contains("nominas") ? "NOMINA" : "INVERSION";

                                            if (parts.length == 9) {
                                                fechAlta = dateFormat.parse(parts[8].trim());
                                                Cliente newCliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, domicilio, ciudad, telefono, tipoCuenta);
                                                return new CuentaNomina(nCuenta, saldo, fechAlta, newCliente);
                                            } else if (parts.length == 11) {
                                                try {
                                                    interes = Double.parseDouble(parts[8].trim());
                                                    plazo = Integer.parseInt(parts[9].trim());
                                                    fechAlta = dateFormat.parse(parts[10].trim());
                                                    Cliente newCliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, domicilio, ciudad, telefono, tipoCuenta);
                                                    return new CuentaInversion(nCuenta, saldo, fechAlta, plazo, interes, newCliente);
                                                } catch (NumberFormatException e){
                                                    System.out.println("Plazo o Interes invalido..");
                                                    // Aquí puedes agregar algún manejo específico de la excepción si es necesario
                                                }
                                            }
                                        }
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (ParseException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("La ruta especificada no es un directorio válido.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
