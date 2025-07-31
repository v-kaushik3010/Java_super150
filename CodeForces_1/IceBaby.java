package CodeForces_1;

//The longest non-decreasing subsequence of an array of integers a1,a2,…,an
//is the longest sequence of indices 1≤i1<i2<…<ik≤n
//such that ai1≤ai2≤…≤aik
//. The length of the sequence is defined as the number of elements in the sequence. For example, the length of the longest non-decreasing subsequence of the array a=[3,1,4,1,2]
//is 3
//.
//
//You are given two arrays of integers l1,l2,…,ln
//and r1,r2,…,rn
//. For each 1≤k≤n
//, solve the following problem:
//
//Consider all arrays of integers a
//of length k
//, such that for each 1≤i≤k
//, it holds that li≤ai≤ri
//. Find the maximum length of the longest non-decreasing subsequence among all such arrays.
//Input
//Each test consists of multiple test cases. The first line contains a single integer t
//(1≤t≤104
//) — the number of test cases. The description of the test cases follows.
//
//The first line of each test case contains a single integer n
//(1≤n≤2⋅105
//) — the length of the arrays l
//and r
//.
//
//The next n
//lines of each test case contain two integers li
//and ri
//(1≤li≤ri≤109
//).
//
//It is guaranteed that the sum of n
//across all test cases does not exceed 2⋅105
//.
//
//Output
//For each test case, output n
//integers: for each k
//from 1
//to n
//, output the maximum length of the longest non-decreasing subsequence among all suitable arrays.
//
//Example
//InputCopy
//6
//1
//1 1
//2
//3 4
//1 2
//4
//4 5
//3 4
//1 3
//3 3
//8
//6 8
//4 6
//3 5
//5 5
//3 4
//1 3
//2 4
//3 3
//5
//1 2
//6 8
//4 5
//2 3
//3 3
//11
//35 120
//66 229
//41 266
//98 164
//55 153
//125 174
//139 237
//30 72
//138 212
//109 123
//174 196
//OutputCopy
//1 
//1 1 
//1 2 2 3 
//1 2 2 3 3 3 4 5 
//1 2 2 2 3 
//1 2 3 4 5 6 7 7 8 8 9 

import java.io.*;
import java.util.*;

public class IceBaby {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] l = new int[n];
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().split(" ");
                l[i] = Integer.parseInt(parts[0]);
                r[i] = Integer.parseInt(parts[1]);
            }

            ArrayList<Integer> active = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int val = r[i];
                int pos = upperBound(active, val);
                if (pos == active.size()) {
                    active.add(l[i]);
                } else {
                    active.set(pos, Math.max(active.get(pos), l[i]));
                }
                output.append(active.size()).append(" ");
            }
            output.append("\n");
        }

        System.out.print(output);
    }

    // upperBound: first index where element > value
    private static int upperBound(ArrayList<Integer> list, int val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}

