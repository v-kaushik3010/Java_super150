package lecture_8;

public class rotate_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,4,5,6,7};
		int k = 3;
		Rotate(nums, k);
		for(int i = 0; i<nums.length; i++) {
			System.out.print(nums[i]+" ");
		}

	}
	public static void Rotate(int[] nums, int k) {
		int n = nums.length;
		k = k% n;
		while(k>0) {
			int item = nums[n-1];
			for(int i = n-2; i >= 0; i--) {
				nums[i+1] = nums[i];
				
			}
			nums[0]= item;
			k--;
			
		}
		
	}

}
