/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stream;

/**
 *
 * @author xxyan
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFile {
     public static void main(String[] args) throws IOException {
        System.out.println("File Name ? ");
        String fileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName = br.readLine();
        System.out.println("Data Yang akan dimasukkan ke "+fileName+"...");

        System.out.println("Type q$ to End");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be opened for writing");
        }

        try {
            boolean done = false;
            int data;
            do {
                data = br.read();
                if ((char) data == 'q') {
                    data = br.read();
                    if ((char) data == '$') {
                        done = true;
                    }else {
                        fos.write('q');
                        fos.write(data);
                    }
                }else{
                    fos.write(data);
                }
            } while (!done);
        } catch (Exception e) {
            System.out.println("File Tidak Bisa di tulis");
        }

    }
}
