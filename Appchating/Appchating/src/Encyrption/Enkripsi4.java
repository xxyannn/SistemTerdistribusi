/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encyrption;

/**
 *
 * @author xxyan
 */
public class Enkripsi4 {
    public static void main(String[] args) {
    String textToEncrypt = "HELLO"; // Replace with your text
    String secretKey = "KEY";      // Replace with your secret key
    System.out.println("Original Text: " + textToEncrypt);

    String encryptedText = encrypt(textToEncrypt, secretKey);
    System.out.println("Encrypted Text: " + encryptedText);

    String decryptedText = decrypt(encryptedText, secretKey);
    System.out.println("Decrypted Text: " + decryptedText);
}

    private static String encrypt(String plainText, String secretKey){
         int textLength = plainText.length();
        int keyLength = secretKey.length();

        // Make sure the key and text have the same length
        if (keyLength < textLength) {
            // Pad the key with 'A' to match the text length
            while (keyLength < textLength) {
                secretKey += 'A';
                keyLength++;
            }
        } else if (keyLength > textLength) {
            // Truncate the key to match the text length
            secretKey = secretKey.substring(0, textLength);
        }
        
        StringBuilder encryptedString = new StringBuilder();
        int encryptedInt;
        for (int i = 0; i < textLength; i++) {
            int plainTextInt = (int) (plainText.charAt(i) - 'A');
            int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
            encryptedInt = (plainTextInt + secretKeyInt) % 26;
            encryptedString.append((char) ((encryptedInt) + (int) 'A'));
        }
        return encryptedString.toString();
        
    }
    
     private static String decrypt(String decryptedText, String secretKey){
          int textLength = decryptedText.length();
            int keyLength = secretKey.length();

            // Make sure the key and text have the same length
            if (keyLength < textLength) {
                // Pad the key with 'A' to match the text length
                while (keyLength < textLength) {
                    secretKey += 'A';
                    keyLength++;
                }
            } else if (keyLength > textLength) {
                // Truncate the key to match the text length
                secretKey = secretKey.substring(0, textLength);
            }
    
        StringBuilder decryptedString = new StringBuilder();
        int decryptedInt;
         for (int i = 0; i < textLength; i++) {
             int decryptedTextInt = (int) (decryptedText.charAt(i) - 'A');
             int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
             decryptedInt = decryptedTextInt - secretKeyInt;
             if (decryptedInt < 0){
                 decryptedInt += 26;
             }
             decryptedString.append((char) ((decryptedInt) + (int) 'A'));
         }
          return decryptedString.toString();
    }
}
