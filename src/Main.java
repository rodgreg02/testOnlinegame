import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        Network nw = null;
        try {
            Field field = new Field();
            while (!gameOver) {
                gameOver = field.checkWin() != 'k';
                field.setField();
                field.printField();
                nw = new Network();
                while (true) {
                    char receivedData = nw.receiveData();
                    field.onlinePlay(receivedData);
                    field.printField();
                    gameOver = field.checkWin() != 'k';
                    Scanner scanner = new Scanner(System.in);
                    char local = scanner.next().charAt(0);
                    field.localPlay(local);
                    System.out.println("Sent data : " + nw.sendCharData(local));
                    field.printField();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (nw != null && !nw.dS.isClosed()) {
                nw.dS.close();
            }
        }
    }
}
