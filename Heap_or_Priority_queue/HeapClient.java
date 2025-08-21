package Heap_or_Priority_queue;

import java.util.Collections;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap hp = new Heap();
		hp.add(5);
		hp.add(7);
		hp.add(9);
		hp.add(4);
		hp.add(2);
		hp.add(3);
		hp.add(1);
		hp.Display();
//		PriorityQueue<Integer> pq = new PriorityQueue<>();   //min heap : by default
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max heap
		
		
	}

}
