import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by a.krivosheev on 21.01.2016.
 */
public class UDPServer {
    public static void main(String args[]) throws Exception       {
        DatagramSocket serverSocket = new DatagramSocket();
        byte[] receiveData = new byte[512];

        while(true)                {
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            serverSocket.receive(receivePacket);
//            String sentence = new String( receivePacket.getData());
//            System.out.println("RECEIVED: " + sentence);
            byte[] sendData = new byte[512];
            for (int i = 0; i < sendData.length; i++) {
                sendData[i] = 16;
            }
            InetAddress IPAddress = InetAddress.getByName("localhost");
//            int port = receivePacket.getPort();
//            String capitalizedSentence = sentence.toUpperCase();
//            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =  new DatagramPacket(sendData, sendData.length, IPAddress, 9000);
            serverSocket.send(sendPacket);
            System.out.println("packet send " + sendData[1]);
            Thread.sleep(1000);
        }
    }
}

