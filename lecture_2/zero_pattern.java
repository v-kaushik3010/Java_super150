package lecture_2;
import java.util.*;

public class zero_pattern {
	

	    public static void main(String args[]) {

	 Scanner scanner = new Scanner(System.in);
	        int N = scanner.nextInt();
	        scanner.close();

	       //row
	        int i = 1;
	        while (i <= N) {
	            int j = 1; 

	            while (j <= i) {
	             //zero
	                if (j == 1 || j == i) {
	                    System.out.print(i);
	                } else {
	                    System.out.print(0); 
	                }

	              
	                if (j < i) {
	                    System.out.print("\t");
	                }

	                j++; 
	            }

	//next row
	            System.out.println(); 
	            i++; 
	        }
	    }
	}


