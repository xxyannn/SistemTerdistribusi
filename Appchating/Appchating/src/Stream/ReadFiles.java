/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stream;

/**
 *
 * @author xxyan
 */
import java.io.*;

public class ReadFiles {
     public static void main(String[] args) {
        System.out.println("What is the name of the file to read from? ");
        String fileName;
        FileInputStream fis = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = br.readLine();
            System.out.println("Now reading from " + fileName+"....");
            fis = new FileInputStream(fileName);

        } catch (Exception e) {
            System.out.println("File Not Found!");
        }

            
        try {
            char data;
            int temp;
            do {
                temp = fis.read();
                data = (char) temp;
                if (temp != -1) {
                    System.out.print(data);
                }
            } while(temp != -1);

        } catch (IOException e) {
            System.out.println("Problem Reading file!");
        }
    }
}
