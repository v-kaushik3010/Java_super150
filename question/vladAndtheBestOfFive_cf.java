package question;

import java.util.Scanner;  

public class vladAndtheBestOfFive_cf{  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline  

        for (int i = 0; i < t; i++) {  
            String s = scanner.nextLine(); // Read each string  
            int countA = 0;  
            int countB = 0;  

            // Count occurrences of 'A' and 'B'  
            for (char c : s.toCharArray()) {  
                if (c == 'A') {  
                    countA++;  
                } else {  
                    countB++;  
                }  
            }  

            if (countA > countB) {  
                System.out.println('A');  
            } else {  
                System.out.println('B');  
            }  
        }  

        scanner.close();  
    }  
}