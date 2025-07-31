package back_traacking;

public class Merge_Two_Sorted_Array {

	public static void main(String[] args) {

		int[] arr1 = {2, 3, 5, 7,8};
		int[] arr2 = {1, 3, 5, 8, 9, 11, 13};
		int[] res = merge(arr1, arr2);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] res = new int[n + m];
		int i = 0, j = 0, k = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				res[k++] = arr1[i++];
				// res[k] = arr2[j];
				// k++;
				// j++;
			} else {
				res[k++] = arr2[j++];
			}
		}
		while (i < n) {
			res[k++] = arr1[i++];
		}
		while (j < m) {
			res[k++] = arr2[j++];
		}
		return res;
	}

}
