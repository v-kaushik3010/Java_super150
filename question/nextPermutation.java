package question;

public class nextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        NextPermutation(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void NextPermutation(int[] arr) {
        int n = arr.length;
        int p = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                p = i;
                break;
            }
        }

        // If no such element is found, reverse the array (it means it's the last permutation)
        if (p == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find the smallest element on the right of p which is larger than arr[p]
        for (int i = n - 1; i > p; i--) {
            if (arr[i] > arr[p]) {
                // Step 3: Swap arr[p] and arr[i]
                swap(arr, p, i);
                break;
            }
        }

        // Step 4: Reverse the portion of the array after index p
        reverse(arr, p + 1, n - 1);
    }

    // Helper method to reverse part of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
