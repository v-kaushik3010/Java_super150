package lecture_3;

import java.util.Scanner;

public class Fibonacci_Pattern {

	public static void main(String[] args) {  
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int row = 1;
		int a = 0;
		int b = 1;
		
		
		while(row <= n) {
		for(int i =1; i <= row; i++) {
			int c = a + b;
			System.out.println(c);
			a= b;
			b= c;
			
			
		}row++;
		}sc.close();

	}

}
