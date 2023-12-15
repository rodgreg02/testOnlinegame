import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class Network {
    final String ADDRESS = "localhost";
    static final int PORT = 4444;
    static DatagramSocket dS;

    static {
        try {
            dS = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    static byte[] receiveDataArray = new byte[1024];
    static DatagramPacket rP = new DatagramPacket(receiveDataArray,receiveDataArray.length);

    public Network() throws SocketException {
    }

    static public int receiveData() {
        try {
            dS.receive(rP);
            int receivedValue = ByteBuffer.wrap(rP.getData()).getInt();
            System.out.println("Received data: " + receivedValue);
            return receivedValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    static public boolean sendData(int toSend) {
        try {
            byte[] byteArray = ByteBuffer.allocate(Integer.BYTES).putInt(toSend).array();
            System.out.println("Sending data: " + toSend);
            DatagramPacket dP = new DatagramPacket(byteArray, byteArray.length, rP.getAddress(), rP.getPort());
            dS.send(dP);
            return true; // Sending successful
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false; // Sending failed
    }

}
