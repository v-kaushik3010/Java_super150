package back_traacking;

public class sieve_of_erathosthenes {

	public static void main(String[] args) {
	int n = 100;
	if(n<=2){
		System.out.println(0);
	}
	else{
		System.out.println(PrimeSieve(n));

	}
	}

	public static int PrimeSieve(int n){
		int[] ans = new int[n];
		ans[0] = ans[1] = 0;
		for(int i = 2; i*i <= ans.length; i++){
			if(ans[i] == 0){// i prime hai
				for(int j = 2; i*j < ans.length; j++){
					ans[i*j] = 1;
				}
			}
		}int c=0;
		for(int i = 2; i < ans.length; i++){
			if(ans[i] == 0){
				c++;
			}
		}return c;
	}
}
