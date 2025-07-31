package CodeForces_1;

import java.io.*;
import java.util.*;

public class Free_Tree {


	    static class Edge {
	        int to;
	        int w;
	        Edge(int _to, int _w) {
	            to = _to; w = _w;
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder out = new StringBuilder();
	        
	        int t = Integer.parseInt(br.readLine().trim());
	        // Threshold for heavy vertices
	        final int B = 300;
	        
	        while (t-- > 0) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int q = Integer.parseInt(st.nextToken());
	            
	            int[] color = new int[n+1];
	            st = new StringTokenizer(br.readLine());
	            for (int i = 1; i <= n; i++) {
	                color[i] = Integer.parseInt(st.nextToken());
	            }
	            
	            // build adjacency
	            List<Edge>[] adj = new ArrayList[n+1];
	            for (int i = 1; i <= n; i++) {
	                adj[i] = new ArrayList<>();
	            }
	            long totalCost = 0;
	            long sumAllWeights = 0;
	            int[] deg = new int[n+1];
	            
	            for (int i = 0; i < n-1; i++) {
	                st = new StringTokenizer(br.readLine());
	                int u = Integer.parseInt(st.nextToken());
	                int v = Integer.parseInt(st.nextToken());
	                int c = Integer.parseInt(st.nextToken());
	                adj[u].add(new Edge(v, c));
	                adj[v].add(new Edge(u, c));
	                deg[u]++; deg[v]++;
	                sumAllWeights += c;
	                if (color[u] != color[v]) {
	                    totalCost += c;
	                }
	            }
	            
	            // identify heavy vertices
	            boolean[] isHeavy = new boolean[n+1];
	            for (int i = 1; i <= n; i++) {
	                if (deg[i] > B) {
	                    isHeavy[i] = true;
	                }
	            }
	            
	            // heavyNeighbors: for each v, list edges to heavy neighbors
	            List<Edge>[] heavyNeighbors = new ArrayList[n+1];
	            for (int i = 1; i <= n; i++) {
	                heavyNeighbors[i] = new ArrayList<>();
	                for (Edge e : adj[i]) {
	                    if (isHeavy[e.to]) {
	                        heavyNeighbors[i].add(e);
	                    }
	                }
	            }
	            
	            // heavyMap: for each heavy v, map color -> sum weights of edges to that color
	            @SuppressWarnings("unchecked")
	            HashMap<Integer, Long>[] heavyMap = new HashMap[n+1];
	            for (int i = 1; i <= n; i++) {
	                if (isHeavy[i]) {
	                    HashMap<Integer, Long> map = new HashMap<>();
	                    for (Edge e : adj[i]) {
	                        int col = color[e.to];
	                        map.put(col, map.getOrDefault(col, 0L) + e.w);
	                    }
	                    heavyMap[i] = map;
	                }
	            }
	            
	            // process queries
	            while (q-- > 0) {
	                st = new StringTokenizer(br.readLine());
	                int v = Integer.parseInt(st.nextToken());
	                int newCol = Integer.parseInt(st.nextToken());
	                
	                int oldCol = color[v];
	                if (oldCol != newCol) {
	                    long sameBefore = 0, sameAfter = 0;
	                    // compute sums of weights to neighbors with oldCol / newCol
	                    if (isHeavy[v]) {
	                        HashMap<Integer, Long> map = heavyMap[v];
	                        sameBefore = map.getOrDefault(oldCol, 0L);
	                        sameAfter  = map.getOrDefault(newCol, 0L);
	                    } else {
	                        for (Edge e : adj[v]) {
	                            int u = e.to, w = e.w;
	                            if (color[u] == oldCol) sameBefore += w;
	                            if (color[u] == newCol) sameAfter  += w;
	                        }
	                    }
	                    // delta in totalCost = removed sameBefore and add sameAfter
	                    // totalCost = totalCost + (sameBefore - sameAfter)
	                    totalCost += (sameBefore - sameAfter);
	                    
	                    // update neighbors' heavy maps
	                    for (Edge e : heavyNeighbors[v]) {
	                        int u = e.to, w = e.w;
	                        HashMap<Integer, Long> map = heavyMap[u];
	                        // subtract from oldCol
	                        long prevOld = map.getOrDefault(oldCol, 0L);
	                        long updOld  = prevOld - w;
	                        if (updOld > 0) {
	                            map.put(oldCol, updOld);
	                        } else {
	                            map.remove(oldCol);
	                        }
	                        // add to newCol
	                        map.put(newCol, map.getOrDefault(newCol, 0L) + w);
	                    }
	                    
	                    // finally recolor v
	                    color[v] = newCol;
	                }
	                
	                out.append(totalCost).append('\n');
	            }
	        }
	        
	        System.out.print(out);
	    }
	}

