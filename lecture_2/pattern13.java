package lecture_2;

import java.util.*;

public class pattern13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
			
		int n=sc.nextInt();
		int star= 1;
		int row =1;
		
		while( row <=2*n-1){
			//star
			int j =1;
				while(j<= star) {
					System.out.print("* ");
					j++;
					
				}
				//mirror
				if(row<n) {
					star++;
				}
				else {
					star--;
				}
				System.out.println("");
				row++;
			}
	}

}