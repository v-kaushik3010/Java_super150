package lecture_2;
import java.util.*;

public class pattern18 {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
        

        int row = 1;
        int space = n / 2;
        int star = 1;
        
       
        while (row <= n) {
            //spaces
            int i = 1;
            while (i <= space) {
                System.out.print("	");
                i++;
            }
            
            //stars
            int j = 1;
            while (j <= star) {
                System.out.print("*	");
                j++;
            }
            
            // mirror
            if (row <= n / 2) {
                star += 2; 
                space--;  
            } else {
                star -= 2; 
                space++; 
            }
            
            row++;
            System.out.println();
        }
    }
}
