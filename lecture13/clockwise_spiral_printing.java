package lecture13;

public class clockwise_spiral_printing {
	public static void main(String[] args) {
		int [][] matrix= {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		Print(matrix);
	}
	
	public static void Print(int[][] arr) {
		int minc= 0, maxc = arr[0].length -1, minr=0, maxr = arr.length-1;
		int c=0;
		int te = arr.length * arr[0].length;
		
		while(c <te) {
		for(int i = minc; i <= maxc && c <te; i++ ) {
			System.out.print(arr[minr][i]+ " ");
			c++;
		}minr++;
		
		for(int i = minr; i <= maxr && c <te; i++ ) {
			System.out.print(arr[i][maxc]+ " ");
			c++;
		}maxc--;
		
		for(int i = maxc; i >= minc && c <te; i-- ) {
			System.out.print(arr[maxr][i]+ " ");
			c++;
		}maxr--;
		
		for(int i = maxr; i >= minr && c <te; i-- ) {
			System.out.print(arr[i][minc]+ " ");
			c++;
		}minc++;
		}
		
	}

}
