package question;

public class maximum_sum { 
// kedanose algo

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Max_Sum(nums));
				

	}
	public static int Max_Sum(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i< nums.length; i++) {
			sum += nums[i];
			ans = Math.max(ans, sum);
			if(sum < 0) {
				sum = 0;			}
			
		}return sum;
	}
}
