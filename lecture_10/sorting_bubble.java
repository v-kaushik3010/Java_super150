package lecture_10;

//bubble, Selection, Insertion, Counting, Cycle, DNF, Heap

public class sorting_bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4,5,3,2,1};
		Sort(arr);
		for(int j = 0; j <arr.length ; j++) {
			System.out.print(arr[j]+" ");
			
		}
		
	}
	public static void Sort(int[] arr) {
		for(int turn =1; turn <arr.length; turn++) {
			for (int i = 0; i < (arr.length - turn) ; i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]= temp;
				}
			}
		}
	}

}
