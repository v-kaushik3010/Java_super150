package lecture_3;

import java.util.Scanner;

public class rhombus_pattern {
	public static void  main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int star =1;
		int row=1;
		int space = n-1;
		int val =1;
		while(row <=  2*n-1) {
			//spaces
			int i = 1;
			while(i <= space) {
				System.out.print("  ");
				i++;								
			}
			//star
			int j = 1;
			int p = val;
			while(j <= star) {
				System.out.print(p+" ");
				if(j <= star / 2) {
					p++;
				}else {
					p--;
				}
				j++;
			}
			//mirror
			if(row<n) {
				star+=2;
				space--;
				val++;				
			}
			else {
				star-=2;
				space++;
				val--;
			}
			row++;
			System.out.println();
			
		}
		sc.close();
	}

}
