package CodeForces_1;
import java.util.*;
//GIVING TLE

public class Kirei_Attacks_the_Estate {
	 static List<List<Integer>> adj;
	    static long[] a;
	    static long[] threat;
	    static int[] parent;
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while (t-- > 0) {
	            int n = sc.nextInt();
	            a = new long[n + 1];
	            threat = new long[n + 1];
	            parent = new int[n + 1];
	            adj = new ArrayList<>();
	            
	            for (int i = 0; i <= n; i++) {
	                adj.add(new ArrayList<>());
	            }
	            
	            for (int i = 1; i <= n; i++) {
	                a[i] = sc.nextLong();
	            }
	            
	            for (int i = 0; i < n - 1; i++) {
	                int u = sc.nextInt();
	                int v = sc.nextInt();
	                adj.get(u).add(v);
	                adj.get(v).add(u);
	            }
	            
	            // Build the tree with root at 1
	            buildTree(1, -1);
	            
	            // Calculate threat for each vertex
	            for (int i = 1; i <= n; i++) {
	                threat[i] = calculateMaxAlternatingSum(i);
	            }
	            
	            // Output results
	            for (int i = 1; i <= n; i++) {
	                System.out.print(threat[i]);
	                if (i < n) System.out.print(" ");
	            }
	            System.out.println();
	        }
	        
	        sc.close();
	    }
	    
	    static void buildTree(int v, int p) {
	        parent[v] = p;
	        for (int u : adj.get(v)) {
	            if (u != p) {
	                buildTree(u, v);
	            }
	        }
	    }
	    
	    static long calculateMaxAlternatingSum(int start) {
	        long maxSum = a[start]; // Just the single vertex
	        
	        // Try paths of different lengths
	        int current = start;
	        long currentSum = a[start];
	        boolean subtract = true; // Next operation should be subtraction
	        
	        while (parent[current] != -1) {
	            current = parent[current];
	            
	            if (subtract) {
	                currentSum -= a[current];
	            } else {
	                currentSum += a[current];
	            }
	            
	            maxSum = Math.max(maxSum, currentSum);
	            subtract = !subtract;
	        }
	        
	        return maxSum;
	    }

}

//Once, Kirei stealthily infiltrated the trap-filled estate of the Ainzbern family but was discovered by Kiritugu's familiar. Assessing his strength, Kirei decided to retreat. The estate is represented as a tree with nn vertices, with the root at vertex 11. Each vertex of the tree has a number aiai recorded, which represents the danger of vertex ii. Recall that a tree is a connected undirected graph without cycles.
//For a successful retreat, Kirei must compute the threat value for each vertex. The threat of a vertex is equal to the maximum alternating sum along the vertical path starting from that vertex. The alternating sum along the vertical path starting from vertex ii is defined as ai−api+appi−…ai−api+appi−…, where pipi is the parent of vertex ii on the path to the root (to vertex 11).
//For example, in the tree below, vertex 44 has the following vertical paths:
//* [4][4] with an alternating sum of a4=6a4=6;
//* [4,3][4,3] with an alternating sum of a4−a3=6−2=4a4−a3=6−2=4;
//* [4,3,2][4,3,2] with an alternating sum of a4−a3+a2=6−2+5=9a4−a3+a2=6−2+5=9;
//* [4,3,2,1][4,3,2,1] with an alternating sum of a4−a3+a2−a1=6−2+5−4=5a4−a3+a2−a1=6−2+5−4=5.
//The dangers of the vertices are indicated in red.
//Help Kirei compute the threat values for all vertices and escape the estate.
//Input
//The first line contains an integer tt (1≤t≤1041≤t≤104) — the number of test cases.
//The following describes the test cases.
//The first line contains an integer nn (2≤n≤2⋅1052≤n≤2⋅105) — the number of vertices in the tree.
//The second line contains nn integers a1,a2,…,ana1,a2,…,an (1≤ai≤1091≤ai≤109) — the dangers of the vertices.
//The next n−1n−1 lines contain the numbers v,uv,u (1≤v,u≤n1≤v,u≤n, v≠uv≠u) — the description of the edges of the tree.
//It is guaranteed that the sum of nn across all test cases does not exceed 2⋅1052⋅105. It is also guaranteed that the given set of edges forms a tree.
//Output
//For each test case, output nn integers — the threat of each vertex.
//Example
//Input
//
//2
//5
//4 5 2 6 7
//1 2
//3 2
//4 3
//5 1
//6
//1000000000 500500500 900900900 9 404 800800800
//3 4
//5 1
//2 5
//1 6
//6 4
//Output
//
//4 5 2 9 7 
//1000000000 1500500096 1701701691 199199209 404 800800800
//Note
//The tree from the first test case is depicted in the statement, and the maximum variable-sign sums are achieved as follows:
//1. a1=4a1=4;
//2. a2=5a2=5;
//3. a3=2a3=2;
//4. a4−a3+a2=6−2+5=9a4−a3+a2=6−2+5=9;
//5. a5=7a5=7. java  code
