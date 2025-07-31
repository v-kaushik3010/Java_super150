package CodeForces_1;

import java.util.*;

public class skibidus_and_sigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<long[]> arrays = new ArrayList<>();
            List<Long> sums = new ArrayList<>();

            // Read and sort each array
            for (int i = 0; i < n; i++) {
                long[] arr = new long[m];
                long sum = 0;
                for (int j = 0; j < m; j++) {
                    arr[j] = sc.nextLong();
                    sum += arr[j];
                }
                Arrays.sort(arr); // Sort in ascending order
                arrays.add(arr);
                sums.add(sum);
            }

            // Sort the arrays based on their total sum in descending order
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < n; i++) indices.add(i);
            indices.sort((a, b) -> Long.compare(sums.get(b), sums.get(a)));

            // Create final concatenated array
            List<Long> finalArray = new ArrayList<>();
            for (int idx : indices) {
                for (long num : arrays.get(idx)) {
                    finalArray.add(num);
                }
            }

            // Compute the final score using prefix sums
            long score = 0, prefixSum = 0;
            for (long num : finalArray) {
                prefixSum += num;
                score += prefixSum;
            }

            System.out.println(score);
        }
        
        sc.close();
    }
}




