package back_traacking;

public class quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [] arr = {5, 7, 2, 1, 8, 3, 4};
			sort(arr, 0, arr.length-1);
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + " ");
			}
	}

	// sort code
	public static void sort(int [] arr, int s1, int e1){
		if(s1 >= e1){
			return;
		}
		int idx = Partition(arr, s1, e1);
		sort(arr, s1, idx-1);
		sort(arr, idx+1, e1);
	}

	//partition code
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
