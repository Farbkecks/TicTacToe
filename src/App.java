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
    static boolean check_win(String[] board){
        for (int i=0; i<3;i++){
            if (board[0+i] == board[3+i] && board[3+i] == board[6+i]){
                return true;
            }
        }
        for (int i= 0; i<7; i+=3){
            if (board[0+i] == board[1+i] && board[1+i] == board[2+i]){
                return true;
            }
        }
        if (board[0] == board[4] && board[4] == board[8]){
            return true;
        }
        if (board[6] == board[4] && board[4] == board[2]){
            return true;
        } 
        
        return false;
    }
    static boolean check_even(String[] board){
        for( String i: board){
            if(i != "X" && i != "O"){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        Player player = Player.X;
        Scanner scan = new Scanner(System.in);
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        System.out.println(check_even(board));
        Boolean even = false;
        while(!check_win(board)){
            if (check_even(board)){
                even = true;
                break;
            }
            print_board(board);
            board = change_board(board, user_input(board, player, scan), player);
            player = change_player(player);
            System.out.println("--------------------------------");
        }
        print_board(board);
        if (!even){
            System.out.print("Spieler ");
            switch(player){
                case X:
                    System.out.print("O");
                case O:
                    System.out.print("X");
            System.out.println(" hatt gewonnen");
            }
        } else{
            System.out.println("Keiner hat gewonnen");
            }
        scan.close();
    }
}
