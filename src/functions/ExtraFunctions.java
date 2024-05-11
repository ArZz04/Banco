package functions;

import java.security.MessageDigest;
import java.math.BigInteger;

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

}
