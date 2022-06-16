import java.util.Scanner;

enum Player {
    X,
    O
}

public class App {
    static void print_board(String[] board){
        for (int i=0; i<7; i+=3){
            for (int y=0; y<3; y++){
                System.out.print(board[i+y]);
                if (y == 0 || y == 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i==0 || i== 3){
            System.out.println("-----");
            }
        }
    }
    
    static int user_input(String[] board, Player player, Scanner scan){
        int input_int;
        while (true){
            switch(player){
                case X:
                    System.out.print("Spieler X ist dran.\nWelche Position: ");
                    break;
                case O:
                    System.out.print("Spieler O ist dran.\nWelche Position: ");
                    break;
            }
            String input = scan.nextLine();
            try{
                input_int = Integer.parseInt(input);
                input_int -= 1; //damit es der Indes in der Liste ist
            }
            catch(Exception e){
                System.out.println("Nur Zahlen");
                continue;
            }
            if (input_int > 8 || input_int < 0){
                System.out.println("Nur Zahlen zwischen 1 und 9");
                continue;
            }
            if (board[input_int]== "X" || board[input_int]=="O"){
                System.out.println("Das Feld ist schon belegt");
                continue;
            }
            break;
        }
       return input_int; 
    }
    
    static String[] change_board(String[] board, int pos,Player player) {
        switch(player){
            case X:
                board[pos] = "X";
                break;
            case O:
                board[pos] = "O";
                break;
            default:
        }
        return board;
    }
    static Player change_player(Player player){
        switch(player){
            case X:
                return Player.O;
            case O:
                return Player.X;
        }
        return Player.X;
    }


    public static void main(String[] args) throws Exception {
        Player player = Player.X;
        Scanner scan = new Scanner(System.in);
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        while(true){
            print_board(board);
            board = change_board(board, user_input(board, player, scan), player);
            player = change_player(player);
            System.out.println("--------------------------------");
        }
    // scan.close();
}
}
