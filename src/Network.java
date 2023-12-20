import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class Network {
    final String ADDRESS = "localhost";
    final int PORT = 4444;
   DatagramSocket dS;

     {
        try {
            dS = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

   byte[] receiveDataArray = new byte[2];
    DatagramPacket rP = new DatagramPacket(receiveDataArray,receiveDataArray.length);

    public Network() throws SocketException {
    }

    public char receiveData() {
        try {
            dS.receive(rP);
            byte[] receivedData = rP.getData();

            String receivedString = new String(receivedData, "UTF-8"); // Decode using the same charset used for encoding
            char receivedChar = receivedString.charAt(0);
            System.out.println("\nReceived char value: " + receivedChar);

            return receivedChar;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public boolean sendCharData(char toSend) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
            buffer.putChar(toSend);
            byte[] byteArray = buffer.array();
            System.out.println("Sending data: " + toSend);
            DatagramPacket dP = new DatagramPacket(byteArray, byteArray.length, rP.getAddress(), rP.getPort());
            dS.send(dP);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
