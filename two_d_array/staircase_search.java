package two_d_array;

public class staircase_search {

	public static void main(String[] args) {
		int item = 5;
		int [][] matrix= {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		// TODO Auto-generated method stub
		Search(matrix, item);

	}
	public static Boolean Search(int[][] matrix, int item) {
		int row = 0;
		int col = matrix[0].length -1;
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col]==item) {
				return true;
			}
			else if(matrix[row][col] < item) {
				row++;
			}
			else{
				col--;
			}
		}return false;
	}

}
