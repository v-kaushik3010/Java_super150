package question;

public class prod_of_all_except_self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3,4};
		int [] a = Product(nums);
		for(int i = 0; i< nums.length; i++) {
			System.out.println(a[i]);
		}
				

	}
	public static int [] Product(int[] nums){
		int n = nums.length;
		int [] left = new int[n];
		int [] right = new int[n];
		left[0]= 1;
		for(int i = 1; i<n; i++) {
			left[i]= left[i-1] *nums[i -1];
		}
		right[n-1]=1;
		for(int i = n-2; i >=0; i--) {
			right[i] = right[i+1]*nums[i+1];
			
		}
		for(int i = 0; i<n; i++) {
			left[i] = left[i] * right[i];
		}return left;
		
	}

}
