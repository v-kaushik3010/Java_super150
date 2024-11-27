package question;

public class majority_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,2,3};
		System.out.println(Moure_Voting(nums));
		

	}
	public static int Moure_Voting(int[] nums) {
		int e = nums[0];
		int v= 1;
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] ==e) {
				v++;
			}
			else {
				v--;
				if(v==0) {
					e = nums[i];
					v=1;
					
				}
			}
		}return e;
	}

}
