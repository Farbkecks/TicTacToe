public class App {
    static void print_board(String[] b){
        for (int i=0; i<7; i+=3){
            for (int y=0; y<3; y++){
                System.out.print(b[i+y]);
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
    public static void main(String[] args) throws Exception {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        print_board(board);
    }
}
