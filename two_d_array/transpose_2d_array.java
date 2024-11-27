package two_d_array;
import java.util.*;

public class transpose_2d_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int [][] arr = new int [n][m];
		for(int i=0 ; i <arr.length; i++) {
			for(int j=0 ; j <arr[0].length; j++) {
				arr[i][j] =sc.nextInt();
			}
			}
	Transpose_2d(arr);
	Display(arr);
	sc.close();

}

	public static void Transpose_2d(int [][] arr){
		for (int i = 0; i <arr.length; i++) {
			for ( int j = i+1; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j]= arr[j][i];
				arr[j][i]= temp;
			}
		}
	}
	
	public static void Display(int [][] arr) {
		for(int i =0 ; i<arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}