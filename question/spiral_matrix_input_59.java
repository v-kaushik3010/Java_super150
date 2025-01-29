package question;
import java.util.*;

public class spiral_matrix_input_59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	     int n = sc.nextInt();
	     int[][] arr= generateMatrix(n);
	     Display(arr);
	     sc.close();
	     
	}
	
	public static int[][] generateMatrix(int n) {
        int[][] result = new int [n][n];  
        if (result.length == 0) return result;  

       	int minc= 0, maxc = result[0].length -1, minr=0, maxr = result.length-1;
		int c=0;
		int te = result.length * result[0].length;
		
		while(c <te) {
		for(int i = minc; i <= maxc && c <te; i++ ) {
			result[minr][i]= c+1;
			c++;
		}minr++;
		
		for(int i = minr; i <= maxr && c <te; i++ ) {
			result[i][maxc]= c+1;
			c++;
		}maxc--;
		
		for(int i = maxc; i >= minc && c <te; i-- ) {
			result[maxr][i]= c+1;
			c++;
		}maxr--;
		
		for(int i = maxr; i >= minr && c <te; i-- ) {
			result[i][minc]=c+1;
			c++;
		}minc++;
		}return result;
    }
	
	public static void Display(int [][] arr) {
		for(int i =0 ; i<arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}

}}
