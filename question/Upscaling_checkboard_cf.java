package question;
import java.util.*;
public class Upscaling_checkboard_cf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();  // Number of test cases

	        for (int test = 0; test < t; test++) {
	            int n = sc.nextInt();  // Size of the checkerboard
	            int size = 2 * n;      // 2n x 2n grid

	            // Generating the checkerboard
	            for (int i = 0; i < size; i++) {
	                StringBuilder row = new StringBuilder();
	                for (int j = 0; j < size; j++) {
	                    // Determine if the current cell should be # or .
	                    if ((i / 2 + j / 2) % 2 == 0) {
	                        row.append('#');
	                    } else {
	                        row.append('.');
	                    }
	                }
	                System.out.println(row.toString());
	            }
	        }
	        sc.close();

	}

}
