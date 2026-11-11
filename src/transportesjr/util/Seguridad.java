/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.util;

import java.nio.charset.StandardCharsets;     // Para convertir el texto en bytes.
import java.security.MessageDigest;           // La clase de Java que calcula el hash.
import java.security.NoSuchAlgorithmException; // El error que ocurre si el algoritmo no existe.

/**
 * Herramienta para el hash de las contraseñas.
 * Se usa sin necesidad de entender su interior, igual que Scanner.
 * Este código fue realizado gracias al docente Mauricio Alberto Ledesma
 * @author Mauricio
 */
public class Seguridad {

        public static String hashSHA256(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");          // Pide el algoritmo SHA-256.
            byte[] bytes = md.digest(texto.getBytes(StandardCharsets.UTF_8)); // Calcula la huella (en bytes).
            StringBuilder hex = new StringBuilder();                          // Arma el texto del resultado.
            for (byte b : bytes) {
                hex.append(String.format("%02x", b));                         // Cada byte en hexadecimal (2 caracteres).
            }
            return hex.toString();                                          // 32 bytes x 2 = 64 caracteres.
        } catch (NoSuchAlgorithmException e) {
            // try/catch: "intenta esto; si ocurre este error, haz esto otro".
            // Java obliga a prever que el algoritmo no exista, aunque SHA-256
            // viene incluido en todas las versiones de Java.
            throw new RuntimeException("SHA-256 no está disponible", e);
        }
    }
}