package CodeForces_1;
import java.util.*;

public class SkibidusAndSlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of vertices
            int[] a = new int[n + 1]; // Values on vertices (1-indexed)
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            
            // Build the tree using adjacency list
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            // Result array
            StringBuilder result = new StringBuilder("0".repeat(n));
            boolean[] visited = new boolean[n + 1];

            // Check for each vertex
            for (int i = 1; i <= n; i++) {
                // Reset visited for each DFS
                Arrays.fill(visited, false);
                visited[i] = true; // Mark the current vertex as visited

                // Count occurrences of values in the path
                Map<Integer, Integer> countMap = new HashMap<>();
                countMap.put(a[i], 1); // Start with the current vertex's value

                // Perform DFS from vertex i
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    for (int neighbor : tree.get(current)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            stack.push(neighbor);
                            countMap.put(a[neighbor], countMap.getOrDefault(a[neighbor], 0) + 1);
                        }
                    }
                }

                // Check if the current vertex's value can be a majority
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    int value = entry.getKey();
                    int count = entry.getValue();
                    if (value == a[i] && count > (countMap.size() / 2)) {
                        result.setCharAt(i - 1, '1'); // Set the result for vertex i
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println(result);
        }
        
        sc.close();
    }
}
