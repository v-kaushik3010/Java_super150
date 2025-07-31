package CodeForces_1;

import java.util.*;

public class This_is_the_lst_time {
  

	    static class Casino {
	        int l, r, real;

	        Casino(int l, int r, int real) {
	            this.l = l;
	            this.r = r;
	            this.real = real;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt(); // number of test cases

	        while (t-- > 0) {
	            int n = sc.nextInt();
	            int k = sc.nextInt();
	            Casino[] casinos = new Casino[n];

	            for (int i = 0; i < n; i++) {
	                int l = sc.nextInt();
	                int r = sc.nextInt();
	                int real = sc.nextInt();
	                casinos[i] = new Casino(l, r, real);
	            }

	            // Sort by minimum l to process casinos in increasing access order
	            Arrays.sort(casinos, Comparator.comparingInt(c -> c.l));

	            int currentCoins = k;
	            boolean changed = true;

	            while (changed) {
	                changed = false;
	                for (int i = 0; i < n; i++) {
	                    Casino c = casinos[i];
	                    if (c != null && c.l <= currentCoins && currentCoins <= c.r) {
	                        currentCoins = Math.max(currentCoins, c.real);
	                        casinos[i] = null; // mark casino as visited
	                        changed = true;
	                    }
	                }
	            }

	            System.out.println(currentCoins);
	        }
	        sc.close();
	    }
	}

