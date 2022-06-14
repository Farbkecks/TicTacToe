import java.util.Scanner;

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

    static int user_input(String[] board){
        Scanner scan = new Scanner(System.in);
        int input_int;
        while (true){
            System.out.print("Welche Position: ");
            String input = scan.nextLine();
            try{
                input_int = Integer.parseInt(input);
            }
            catch(Exception e){
                System.out.println("Nur Zahlen");
                continue;
            }
            if (input_int > 9 || input_int < 1){
                System.out.println("Nur Zahlen zwischen 1 und 9");
                continue;
            }
            if (board[input_int-1]== "X" || board[input_int-1]=="O"){
                System.out.println("Das Feld ist schon belegt");
                continue;
            }
            break;
        }
       scan.close();
       return input_int; 
    }
    public static void main(String[] args) throws Exception {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        print_board(board);
        System.out.println(user_input(board));
    }
}
