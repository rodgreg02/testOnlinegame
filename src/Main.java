public class Main {
    public static void main(String[] args) {
        Network nw = null;
        try {
            nw = new Network();
            int receivedData = nw.receiveData();
            System.out.println("Received data: " + receivedData);
            nw.sendData(72);
        } catch (Exception e) {
            e.printStackTrace(); // Better than just printing the message
        } finally {
            if (nw != null && !nw.dS.isClosed()) {
                nw.dS.close();
            }
        }
    }
}