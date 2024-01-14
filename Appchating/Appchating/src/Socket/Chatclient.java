/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

/**
 *
 * @author xxyan
 */
import java.net.*;
import java.io.*;

public class Chatclient {
    public static void main(String args[]) throws Exception {
        MulticastSocket chat = new MulticastSocket(1234);
        InetAddress group = InetAddress.getByName("234.5.6.7");
        
        // Bergabung dengan grup multicast
        chat.joinGroup(group);
        
        System.out.println("Type a message for the server:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        
        // Mengirim pesan ke grup multicast
        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, 1234);
        chat.send(data);
        
        // Menutup socket
        chat.close();
    }
}
