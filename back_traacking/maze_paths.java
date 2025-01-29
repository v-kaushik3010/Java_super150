package back_traacking;

public class maze_paths {
  public static void main(String[] args) {
     
    int m = 3; //row
    int n = 3;  //column
    print(0, 0, m-1, n-1, "");
}

// cr - current row
// cc - current column
// er - end row
// ec - end column

public static void print(int cr, int cc, int er, int ec, String ans) {
    if (cr == er && cc == ec) {
        System.out.println(ans);
        return;
    }
    if (cr > er || cc > ec) {
        return;
    }
    print(cr + 1, cc, er, ec, ans + "V");
    print(cr, cc + 1, er, ec, ans + "H");
  

}
}
