package lecture_10;

public class selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {4, -1, 5, 3, 2, 1, 7};
		Sort(arr);
		for(int j = 0; j <arr.length ; j++) {
			System.out.print(arr[j]+" ");}

	}
	public static void Sort(int[] arr){
		for(int i = 0; i < arr.length; i++) {
			int idx = min_form_ith_index(arr, i);
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		
	}
	public static int min_form_ith_index(int[] arr, int i) {
		int mini = i;
		for(int j = i+1; j <arr.length; j++) {
			if( arr[j] <arr[mini]) {
				mini = j;
				
			}
		}return mini;
	}

}
