import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * Created by a.krivosheev on 21.01.2016.
 */
public class UDPclient {
    public static void main(String[] args) throws Exception {

    DatagramSocket clientSocket = new DatagramSocket(9000);

    byte[] receiveData = new byte[512];

        while (true) {

//    sendData = sentence.getBytes();
//    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
//    clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(Arrays.toString(receivePacket.getData()));
            System.out.println("FROM SERVER:" + modifiedSentence);

        }

    }


}
