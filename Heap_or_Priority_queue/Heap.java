package Heap_or_Priority_queue;
import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> ll = new ArrayList<>();
	
	public void add(int item) {
		ll.add(item);
		upheapify(ll.size()-1);
	}
	
	private void upheapify(int ci) {
		int pi  = (ci - 1)/2;
		if(ll.get(pi)> ll.get(ci)) {
			swap(pi,ci);
			upheapify(pi);
		}
		
		
	}
	private void swap(int pi, int ci) {
		int pith = ll.get(pi);
		int cith = ll.get(ci);
		ll.set(pi, cith);
		ll.set(ci, pith);
	}
	
	public int remove() {
	//	return ll.remove(0);  // O(n)  ho jayega satyanas
		
		swap(0, ll.size() -1);
		int val = ll.remove(ll.size() -1);
		downheapify(0);
		return val;
		
	}
	
	private void downheapify(int pi) {
		int lci = 2+pi +1;
		int rci = 2+pi+2;
		int mini = pi;
		
		if(lci < ll.size() && ll.get(mini) >ll.get(lci)) {
			mini = lci;
		}
		if(rci < ll.size() && ll.get(mini) >ll.get(rci)) {
			mini = rci;
		}
		if(mini != pi) {
			swap(mini, pi);
			downheapify(mini);
			
		}
	}
	
	public int get() {
		return ll.get(0);
		}
	
	public int size() {
		return ll.size();
	}
	
	public void Display() {
		System.out.println(ll);
	}

}
