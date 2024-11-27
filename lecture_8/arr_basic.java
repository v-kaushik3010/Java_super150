package lecture_8;

public class arr_basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr= {2,3,4,1,7,9,8};
		System.out.println(arr.length);
		int item=4;
		System.out.println(Search(arr, item));
		
	}
	public static int Search(int [] arr, int item) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]==item) {
				return i;
			}
		}return -1;
	}

}
