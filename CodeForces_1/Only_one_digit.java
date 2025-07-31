package CodeForces_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Only_one_digit {

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t = Integer.parseInt(br.readLine().trim());
	        
	        while (t-- > 0) {
	            String x = br.readLine().trim();
	            
	            // Find the smallest digit in the string representation of x
	            char minDigit = '9';
	            for (char c : x.toCharArray()) {
	                if (c < minDigit) {
	                    minDigit = c;
	                }
	            }
	            System.out.println(minDigit - '0');
	        }
	    }
	}



////input
//5
//6
//96
//78
//122
//696

