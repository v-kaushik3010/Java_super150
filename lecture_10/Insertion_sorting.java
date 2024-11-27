package lecture_10;

public class Insertion_sorting {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 8, 9, 11, 4};
        Sort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
    public static void Sort(int[] arr) {
    	for(int i = 1; i <arr.length; i++) {
    		 int j = i - 1;
    	        int item = arr[i];

    	        // Shift elements of arr[0..i-1], that are greater than item, to one position ahead
    	        while (j >= 0 && arr[j] > item) {
    	            arr[j + 1] = arr[j];
    	            j--;
    	        }

    	        // Insert the item in its correct position
    	        arr[j + 1] = item;
    	}
    }

}