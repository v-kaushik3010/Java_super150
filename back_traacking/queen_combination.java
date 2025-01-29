package back_traacking;

public class queen_combination {
    public static void main(String[] args) {
        int n = 4;
        int tq = 2;
        boolean [] board = new boolean[n];
        combination(board, tq, "", 0, 0);
    }
    public static void combination(boolean[] board, int tq, String ans, int qpsf, int idx){
       if(qpsf == tq){
           System.out.println(ans);
           return;}
        
        for(int i = idx; i < board.length; i++){
            if(board[i] != true){
                board[i] = true;
                combination(board, tq, ans + "b" + i + "q" + qpsf, qpsf + 1, i+1); // limited queen so i+1 is passed
                board[i] = false;
                
            }
        }
    }
}
