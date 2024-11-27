package lecture_9;

public class reverse_digit {

	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		int k = 3;
		Rotate(nums, k);

	}
	public static void Rotate(int[] arr, int k) {
		int n = arr.length;
		k = k%10;
		Reverse(arr, 0 , n-k-1);
		
		Reverse(arr, 0, n-1);
		
	}
	
	public static void Reverse(int[] arr, int i, int j ) {
		while(i<j) {
			int temp = arr[i];
			arr[i]= arr[j];
			arr[j] = temp;
			i++;
			
		}
	}

}
