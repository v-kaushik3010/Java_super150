package Binary_search;

public class binary_search {

	public static void main(String[] args) {
//		Can apply only sorted array
		int [] arr = {2, 3 , 4, 9, 11,13, 15, 19, 20,21, 25, 26, 27, 29, 32};
		int item = 9;
		System.out.println(Binary_search(arr, item));
}
	public static int Binary_search(int[] arr, int item){
		int low = 0;
		int high = arr.length-1;
		while(low <= high) {
			int mid = (int)(high + low)/ 2;
			if(arr[mid] == item) {
				return mid;
			}else if(arr[mid]>item) {
				high = mid -1;
				continue;
			}else {
				low = mid +1;
				continue;
			}
		}return -1;
		
	}
}