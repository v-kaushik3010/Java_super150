package Heap_or_Priority_queue;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,3,1,2,4,5,5,6};
		int  k = 4;
		kth_Largest_Element(arr, k);

	}
	
	public static int kth_Largest_Element(int [] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();    
	}

}
