package back_traacking;

public class Partition_in_Array {

	public static void main(String[] args) {
	int [] arr = {5, 7, 2, 1, 8, 3, 4};
	System.out.println(Partition(arr, 0, arr.length-1));

	}

	public static int Partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

}
