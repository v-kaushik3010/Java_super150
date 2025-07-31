package back_traacking;
// sieve of eratosthenes: find all primes smaller than n,	// O(nlog(logn))
//prime sieve
public class count_primes {

	public static void main(String[] args) {
		int n = 37;
		System.out.println(isPrime(n));

	}

	public static boolean isPrime(int n) {
		int div= 2;
		while(div*div <= n){
			if(n%div == 0){
				return false;
			}div++;
		}return true;
	}
}
