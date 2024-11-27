package two_d_array;
import java.util.*;

public class array2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//Hard Code
		int [][] arr1 = {{2,3,4,5},{5,6,7,8},{12,13,14,15}};
		
		int n= sc.nextInt();
		int m = sc.nextInt();
		int [][] arr = new int [n][m];
		for(int i=0 ; i <arr.length; i++) {
			for(int j=0 ; j <arr[0].length; j++) {
				arr[i][j] =sc.nextInt();
			}
			
		}Display(arr1);
		VerticalDisplay(arr);
		sc.close();
		}
	public static void Display(int [][] arr) {
		for(int i =0 ; i<arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
	
	public static void VerticalDisplay(int [][] arr) {
		
			for(int col = 0; col < arr[0].length; col++){
				if(col % 2 == 0){
					for(int row = 0; row < arr.length ; row++) {
						System.out.print(arr[row][col]);
					}
				}
				else {
					for(int row = arr.length-1; row >=0 ; row--) {
						System.out.print(arr[row][col]);
					}
					
				}
			}
				
				
	}


}
