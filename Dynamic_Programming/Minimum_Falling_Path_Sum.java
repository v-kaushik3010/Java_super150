package Dynamic_Programming;
import java.util.*;

public class Minimum_Falling_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		int ans= Integer.MAX_VALUE;
        int dp[][] = new int[3][3];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MIN_VALUE);
        }
		for(int col =0; col < matrix[0].length; col++) {
			ans = Math.max(ans, Minimum_Falling_Path(matrix, 0, col, dp));
		}
		System.out.println(ans);
		
		
	}
    private static int Minimum_Falling_Path(int[][] matrix, int row, int col, int[][] dp){
        if(row == 0){
            return matrix[row][col];
        }
        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }
        int same = Minimum_Falling_Path(matrix, row - 1, col, dp);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(col > 0){
            left =  Minimum_Falling_Path(matrix, row - 1, col - 1, dp);
        }
        if(col < matrix.length - 1){
            right = Minimum_Falling_Path(matrix, row - 1, col + 1, dp);
        }
        return dp[row][col] = matrix[row][col] + Math.min(same, Math.min(left, right));
    }
	

}
