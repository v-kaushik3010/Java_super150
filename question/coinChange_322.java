package question;

public class coinChange_322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,3,5};
		int amount = 9;
		System.out.println(Solution(coins, amount));
		

	}
	
	public static int Solution(int[] coins, int amount) {
		int result =0;
		for (int i = coins.length-1; i >=0; i--) {
			int coin = coins[i];
			if (coin<=amount) {
			result+= amount / coin;
			amount  -= result*coin;}
						
			
		}
		 if (amount > 0) {
	            return -1;
	        }
		 return result;
	}

}
