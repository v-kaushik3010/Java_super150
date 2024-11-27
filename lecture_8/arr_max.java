package lecture_8;

public class arr_max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {2,3,4,1,7,9,8};
		System.out.println(arr.length);
		System.out.println(Maximum(arr));
		

	}
	
	public static int Maximum(int [] arr) {
		int max =Integer.MIN_VALUE;// -2^31    // arr[0]
		for(int i =1; i< arr.length; i++) {
			if (arr[i] >max) {
				max = Math.max(max, arr[i]);    //arr[i];
			}
		}return max;
	}

}
