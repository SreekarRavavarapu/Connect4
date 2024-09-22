import java.util.*;
public class connect4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[6][7];

        for(int i = 0; i < 6; i++){
            for(int i2 = 0; i2 < 7; i2++){
                board[i][i2] = " ";
            }
        }
        int x = 1;
        boolean w = false;
        while(x <= 42 && !w) {
            board(board);

            if(x % 2 == 1) {
                System.out.print("player 1 pick a number 1-7");
                int y = sc.nextInt();
                sc.nextLine();
                onetoseven(y, board, "x");
            }
            else {
                System.out.print("player 2 pick a number 1-7");
                int y = sc.nextInt();
                sc.nextLine();
                onetoseven(y, board, "y");
            }

            if(vertically(board) || sideways(board) || upright(board) || upleft(board)){
                board(board);
                if(x % 2 == 1)
                    System.out.println("Player 1 takes dub");
                else if(x % 2 == 0)
                    System.out.println("Player 2 takes dub");
                w = true;
            }
            x++;
        }
    }
    public static void board(String[][] board){
        System.out.println( "  " + 1 + "   " + 2 + "   " + 3 + "   " + 4 + "   " + 5 + "   " + 6 + "   " + 7);
        for(int i = 0 ; i < 6; i++) {
            System.out.print("| ");
            for (int i2 = 0; i2 < 7; i2++)
                System.out.print(board[i][i2] + " | ");
            System.out.println();
            System.out.println("- ー ー ー ー ー ー ー ー ー ー -");
        }
    }

    public static boolean sideways(String[][] board){
        for(int i = 0; i < 6; i++){
            for(int i2 = 0; i2 < 2; i2++){
                if(!board[i][i2].equals(" ") && board[i][i2].equals(board[i][i2+1]) && board[i][i2].equals(board[i][i2+2]) && board[i][i2].equals(board[i][i2+3]))
                    return true;
            }
        }
        return false;
    }
    public static boolean vertically(String[][] board){
        for(int i = 0; i < 7; i++){
            for(int i2 = 0; i2 < 3; i2++){
                if(!board[i2][i].equals(" ") && board[i2][i].equals(board[i2+1][i]) && board[i2][i].equals(board[i2+2][i]) && board[i2][i].equals(board[i2+3][i]))
                    return true;
            }
        }
        return false;
    }
    public static boolean upleft(String[][] board){
        for(int i = 3; i < 6; i++){
            for(int j = 0; j < 4; j++){
                if(!board[i][j].equals(" ") && board[i][j].equals(board[i-1][j+1]) && board[i][j].equals(board[i-2][j+2]) && board[i][j].equals(board[i-3][j+3]))
                    return true;
            }
        }
        return false;
    }

    public static boolean upright(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (!board[i][j].equals(" ") && board[i][j].equals(board[i + 1][j + 1]) && board[i][j].equals(board[i + 2][j + 2]) && board[i][j].equals(board[i + 3][j + 3]))
                    return true;
            }
        }
        return false;
    }
    public static void onetoseven(int place, String[][] board, String marker){
        for(int i = 5; i >= 0; i--){
            if(board[i][place-1].equals(" ")) {
                board[i][place-1] = marker;
                i = -1;
            }
        }
    }

}



