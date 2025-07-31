package Stack;

import java.util.Stack;

public class Largest_Rectangle_IN_Histogram {
        public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle is " + largestHistogram(arr));
    }

    public static int largestHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int height = arr[stack.pop()];
                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = rightBoundary - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Process remaining bars in stack
        while (!stack.isEmpty()) {
            int height = arr[stack.pop()];
            int rightBoundary = n;
            int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
            int width = rightBoundary - leftBoundary - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

}
