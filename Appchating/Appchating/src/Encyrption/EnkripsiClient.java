/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encyrption;

/**
 *
 * @author xxyan
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EnkripsiClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Masukkan Nama Anda: ");
            String nama = scanner.nextLine();
            
            System.out.println("Terhubung ke Server. Ketik 'exit' untuk keluar:");

            new PesanServer(socket, in).start();
            String message;
            String encrypted;
            String encryptedName;
            
            while (true) {
                message = scanner.nextLine();
                encrypted = encryptMessage(message);
                encryptedName = encryptMessage(nama+" : ");
                
                out.println(encryptedName+ encrypted);
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Tutup koneksi
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encryptMessage(String message) {
        String temp = "";
            int key = 15;
            for (int i = 0; i < message.length(); i++) {
                int h = (int) (message.charAt(i));
                char t = (char) (h^key);
                temp += t;
            }
            return temp;
    }

    public static class PesanServer extends Thread {
        private Socket socket;
        private BufferedReader in;
        private String message;

        public PesanServer(Socket socket, BufferedReader in) {
            this.socket = socket;
            this.in = in;
        }

        @Override
        public void run() {
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
