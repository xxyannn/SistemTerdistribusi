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

public class Chatserver {
     public static void main(String args[]) throws Exception {
        MulticastSocket server = new MulticastSocket(1234);
        InetAddress group = InetAddress.getByName("234.5.6.7");

        // Bergabung dengan grup multicast
        server.joinGroup(group);

        boolean infinite = true;

        // Server terus-menerus menerima data dan mencetak mereka
        while (infinite) {
            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);

            // Menerima paket dari grup multicast
            server.receive(data);

            // Mengonversi data byte menjadi string dan menghapus spasi ekstra
            String msg = new String(data.getData()).trim();

            System.out.println(msg);
        }

        // Menutup socket
        server.close();
    }
}
