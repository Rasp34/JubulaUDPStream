import java.io.FileWriter;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;


/**
 * Created by a.krivosheev on 19.01.2016.
 */
public class ServerData {

    public static void main(String[] args) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(75);
        DatagramChannel datagramChannel;
        FileWriter fileWriter = new FileWriter("source.txt");

        byte[] receiveData = new byte[514] ;

        String sentence = " ";
//        byte[] sendData = new byte[1024];

        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            sentence = new String(Arrays.toString(receivePacket.getData()));
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("SOURCE: " + IPAddress + " Port(" + port + "); ");
            System.out.println("RECEIVED: " + sentence + "\n");
            fileWriter.write("Source: " + IPAddress + " Port(" + port + ");");
            fileWriter.write("RECEIVED: " + sentence + "\n");



        }
//        - See more at: https://systembash.com/a-simple-java-udp-server-and-udp-client/#sthash.Ewh37gPf.dpuf

    }

}
