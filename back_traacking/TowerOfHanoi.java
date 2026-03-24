package back_traacking;

public class TowerOfHanoi {
	static int count = 1;
	public static void TOH(int n , char S, char H, char D) {
		//base case
		if(n==1) { 
		System.out.println("Transfer disk " +  n + " from " + S + " to " + D + " Count " + count);
		count +=1;
		return;}
		count +=1;
		
		//tranfer n-1 diskfrom source to helper using Des as helper 
		//3 step for n= 3
		TOH(n-1, S,D,H);
		//move the single largest disk from source to destination  1step
		System.out.println("tranfer disk " +  n + " from " + S + " to " + D + " Count " + count);
		//tranfer n-1 diskfrom Helper to Des using Source as helper
		//3 step for n = 3
		TOH(n-1, H,S,D);
//		count+=1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		
		TOH(n, 'S', 'H', 'D');
		

	}

}
