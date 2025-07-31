package CodeForces_1;
import java.util.*;


public class Cool_Partition {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt(); // number of test cases

	        while (t-- > 0) {
	            int n = sc.nextInt();
	            int[] a = new int[n];

	            for (int i = 0; i < n; i++) {
	                a[i] = sc.nextInt();
	            }

	            System.out.println(maxCoolSegments(a));
	        }
	    }

	    public static int maxCoolSegments(int[] a) {
	        int n = a.length;
	        Map<Integer, Integer> first = new HashMap<>();
	        Map<Integer, Integer> last = new HashMap<>();

	        // Fill first and last occurrence maps
	        for (int i = 0; i < n; i++) {
	            int val = a[i];
	            if (!first.containsKey(val)) {
	                first.put(val, i);
	            }
	            last.put(val, i); // always update last
	        }

	        int segments = 0;
	        int end = 0;
	        int start = 0;

	        for (int i = 0; i < n; i++) {
	            end = Math.max(end, last.get(a[i]));

	            if (i == end) {
	                segments++;
	                start = i + 1;
	            }
	        }

	        return segments;
	    }
