package Heap_or_Priority_queue;

import java.util.PriorityQueue;

public class Minimum_sum_pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,3,2,4};
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int sum = 0;
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			int pairSum = a + b;
            sum += pairSum;

            pq.add(pairSum);
		}
		System.out.println(sum);
	}

}
