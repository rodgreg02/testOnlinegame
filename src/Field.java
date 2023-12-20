public class Field {
    char[] field = new char[9];

    public void setField(){
        char[] currentChar = {'a','b','c','d','e','f','g','h','i'};
        System.arraycopy(currentChar, 0, field, 0, field.length);
    }
    public void localPlay(char where){
        switch (where) {
            case 'a':
                field[0] = 'X';
                break;
            case 'b':
                field[1] = 'X';
                break;
            case 'c':
                field[2] = 'X';
                break;
            case 'd':
                field[3] = 'X';
                break;
            case 'e':
                field[4] = 'X';
                break;
            case 'f':
                field[5] = 'X';
                break;
            case 'g':
                field[6] = 'X';
                break;
            case 'h':
                field[7] = 'X';
                break;
            case 'i':
                field[8] = 'X';
                break;
            default:
                System.out.println("Character not between 'a' and 'i'");
                break;
        }
}

public void onlinePlay(char where){
    switch (where) {
        case 'a':
            field[0] = 'O';
            break;
        case 'b':
            field[1] = 'O';
            break;
        case 'c':
            field[2] = 'O';
            break;
        case 'd':
            field[3] = 'O';
            break;
        case 'e':
            field[4] = 'O';
            break;
        case 'f':
            field[5] = 'O';
            break;
        case 'g':
            field[6] = 'O';
            break;
        case 'h':
            field[7] = 'O';
            break;
        case 'i':
            field[8] = 'O';
            break;
        default:
            System.out.println("Character not between 'a' and 'i'");
            break;
    }

}
    public void printField() {
        System.out.println(" " + field[0] + " | " + field[1] + " | " + field[2] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + field[3] + " | " + field[4] + " | " + field[5] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + field[6] + " | " + field[7] + " | " + field[8] + " ");
    }
    public char checkWin() {
        // Horizontal wins
        for (int i = 0; i < 9; i += 3) {
            if (field[i] == 'X' && field[i + 1] == 'X' && field[i + 2] == 'X') {
                return 'X';
            } else if (field[i] == 'O' && field[i + 1] == 'O' && field[i + 2] == 'O') {
                return 'O';
            }
        }

        // Vertical wins
        for (int i = 0; i < 3; i++) {
            if (field[i] == 'X' && field[i + 3] == 'X' && field[i + 6] == 'X') {
                return 'X';
            } else if (field[i] == 'O' && field[i + 3] == 'O' && field[i + 6] == 'O') {
                return 'O';
            }
        }

        // Diagonal wins
        if ((field[0] == 'X' && field[4] == 'X' && field[8] == 'X') ||
                (field[2] == 'X' && field[4] == 'X' && field[6] == 'X')) {
            return 'X';
        } else if ((field[0] == 'O' && field[4] == 'O' && field[8] == 'O') ||
                (field[2] == 'O' && field[4] == 'O' && field[6] == 'O')) {
            return 'O';
        }

        // If no winner yet
        return 'k';
    }


}
