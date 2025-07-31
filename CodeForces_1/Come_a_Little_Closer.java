package CodeForces_1;
import java.util.*;
public class Come_a_Little_Closer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long[][] monsters = new long[n][2];
            
            for (int i = 0; i < n; i++) {
                monsters[i][0] = sc.nextLong();
                monsters[i][1] = sc.nextLong();
            }
            
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            
            long minCost = calculateRectangleArea(monsters);
            
            // Try moving each monster
            for (int i = 0; i < n; i++) {
                Set<Long> xCoords = new HashSet<>();
                Set<Long> yCoords = new HashSet<>();
                
                // Collect all x and y coordinates except the monster we're moving
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        xCoords.add(monsters[j][0]);
                        yCoords.add(monsters[j][1]);
                    }
                }
                
                long origX = monsters[i][0];
                long origY = monsters[i][1];
                
                // Get bounds of other monsters
                long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
                long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
                
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        minX = Math.min(minX, monsters[j][0]);
                        maxX = Math.max(maxX, monsters[j][0]);
                        minY = Math.min(minY, monsters[j][1]);
                        maxY = Math.max(maxY, monsters[j][1]);
                    }
                }
                
                // Try strategic positions only
                Set<String> tried = new HashSet<>();
                List<long[]> candidatePositions = new ArrayList<>();
                
                // Helper function to add position if not tried
                Runnable addPos = new Runnable() {
                    void addPosition(long x, long y) {
                        String key = x + "," + y;
                        if (!tried.contains(key)) {
                            candidatePositions.add(new long[]{x, y});
                            tried.add(key);
                        }
                    }
                    public void run() {} // Required for Runnable interface
                };
                
                // Lambda to add positions safely
                java.util.function.BiConsumer<Long, Long> addPosition = (x, y) -> {
                    String key = x + "," + y;
                    if (!tried.contains(key)) {
                        candidatePositions.add(new long[]{x, y});
                        tried.add(key);
                    }
                };
                
                // 1. Try aligning with existing coordinates
                for (long x : xCoords) {
                    for (long y : yCoords) {
                        addPosition.accept(x, y);
                    }
                }
                
                // 2. Try positions on the boundary of current bounding box
                addPosition.accept(minX, minY);
                addPosition.accept(minX, maxY);
                addPosition.accept(maxX, minY);
                addPosition.accept(maxX, maxY);
                
                // 3. Try positions that could create straight lines
                for (long x : xCoords) {
                    addPosition.accept(x, minY);
                    addPosition.accept(x, maxY);
                    addPosition.accept(x, minY - 1);
                    addPosition.accept(x, maxY + 1);
                }
                
                for (long y : yCoords) {
                    addPosition.accept(minX, y);
                    addPosition.accept(maxX, y);
                    addPosition.accept(minX - 1, y);
                    addPosition.accept(maxX + 1, y);
                }
                
                // 4. Try positions adjacent to the bounding box
                addPosition.accept(minX - 1, minY);
                addPosition.accept(minX - 1, maxY);
                addPosition.accept(maxX + 1, minY);
                addPosition.accept(maxX + 1, maxY);
                addPosition.accept(minX, minY - 1);
                addPosition.accept(maxX, minY - 1);
                addPosition.accept(minX, maxY + 1);
                addPosition.accept(maxX, maxY + 1);
                
                for (long[] pos : candidatePositions) {
                    // Check if position is valid (not occupied by another monster)
                    boolean valid = true;
                    for (int j = 0; j < n; j++) {
                        if (j != i && monsters[j][0] == pos[0] && monsters[j][1] == pos[1]) {
                            valid = false;
                            break;
                        }
                    }
                    
                    if (!valid) continue;
                    
                    // Move monster temporarily
                    monsters[i][0] = pos[0];
                    monsters[i][1] = pos[1];
                    
                    long cost = calculateRectangleArea(monsters);
                    minCost = Math.min(minCost, cost);
                }
                
                // Restore original position
                monsters[i][0] = origX;
                monsters[i][1] = origY;
            }
            
            System.out.println(minCost);
        }
        
        sc.close();
    }
    
    private static long calculateRectangleArea(long[][] monsters) {
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        
        for (long[] monster : monsters) {
            minX = Math.min(minX, monster[0]);
            maxX = Math.max(maxX, monster[0]);
            minY = Math.min(minY, monster[1]);
            maxY = Math.max(maxY, monster[1]);
        }
        
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
	}

//	
//	The game field is a matrix of size 109×109
//	, with a cell at the intersection of the a
//	-th row and the b
//	-th column denoted as (a,b
//	).
//
//	There are n
//	 monsters on the game field, with the i
//	-th monster located in the cell (xi,yi
//	), while the other cells are empty. No more than one monster can occupy a single cell.
//
//	You can move one monster to any cell on the field that is not occupied by another monster at most once .
//
//	After that, you must select one rectangle on the field; all monsters within the selected rectangle will be destroyed. You must pay 1
//	 coin for each cell in the selected rectangle.
//
//	Your task is to find the minimum number of coins required to destroy all the monsters.
//
//	Input
//	The first line contains a single integer t
//	 (1≤t≤104
//	) — the number of test cases.
//
//	The first line of each test case contains a single integer n
//	 (1≤n≤2⋅105
//	) — the number of monsters on the field.
//
//	The following n
//	 lines contain two integers xi
//	 and yi
//	 (1≤xi,yi≤109
//	) — the coordinates of the cell with the i
//	-th monster. All pairs (xi,yi
//	) are distinct.
//
//	It is guaranteed that the sum of n
//	 across all test cases does not exceed 2⋅105
//	.
//
//	Output
//	For each test case, output a single integer — the minimum cost to destroy all n
//	 monsters.
//
//	Example
//	InputCopy
//	7
//	3
//	1 1
//	1 2
//	2 1
//	5
//	1 1
//	2 6
//	6 4
//	3 3
//	8 2
//	4
//	1 1
//	1 1000000000
//	1000000000 1
//	1000000000 1000000000
//	1
//	1 1
//	5
//	1 2
//	4 2
//	4 3
//	3 1
//	3 2
//	3
//	1 1
//	2 5
//	2 2
//	4
//	4 3
//	3 1
//	4 4
//	1 2
//	OutputCopy
//	3
//	32
//	1000000000000000000
//	1
//	6
//	4
//	8
//	Note
//	Below are examples of optimal moves, with the cells of the rectangle to be selected highlighted in green.

