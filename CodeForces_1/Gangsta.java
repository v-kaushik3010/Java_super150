package CodeForces_1;


//You are given a binary string s1s2…sn
//of length n
//. A string s
//is called binary if it consists only of zeros and ones.
//
//For a string p
//, we define the function f(p)
//as the maximum number of occurrences of any character in the string p
//. For example, f(00110)=3
//, f(01)=1
//.
//
//You need to find the sum f(slsl+1…sr)
//for all pairs 1≤l≤r≤n
//.
//
//Input
//Each test consists of multiple test cases. The first line contains a single integer t
//(1≤t≤104
//) — the number of test cases. Then follows their descriptions.
//
//The first line of each test case contains a single integer n
//(1≤n≤2⋅105
//) — the length of the binary string.
//
//The second line of each test case contains a string of length n
//, consisting of 0
//s and 1
//s — the binary string s
//.
//
//It is guaranteed that the sum of n
//across all test cases does not exceed 2⋅105
//.
//
//Output
//For each test case, output the sum f(slsl+1…sr)
//for all pairs 1≤l≤r≤n
//.
//
//Example
//InputCopy
//6
//1
//0
//2
//01
//4
//0110
//6
//110001
//8
//10011100
//11
//01011011100
//OutputCopy
//1
//3
//14
//40
//78
//190
//Note
//In the first test case, the string s
//has one substring, and the value f(0)=1
//.
//
//In the second test case, all substrings of the string s
//are 0
//, 01
//, 1
//. And the answer is 1+1+1=3
//, respectively.
//
//In the third test case, all substrings of the string s
//are 0
//, 01
//, 011
//, 0110
//, 1
//, 11
//, 110
//, 1
//, 10
//, 0
//. And the answer is 1+1+2+2+1+2+2+1+1+1=14
//, respectively.


import java.util.*;

public class Gangsta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            long totalSum = 0;
            
            // For each starting position l
            for (int l = 0; l < n; l++) {
                int count0 = 0;
                int count1 = 0;
                
                // For each ending position r starting from l
                for (int r = l; r < n; r++) {
                    // Add the character at position r to our counts
                    if (s.charAt(r) == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                    
                    // f(substring from l to r) = max(count0, count1)
                    int f_value = Math.max(count0, count1);
                    totalSum += f_value;
                }
            }
            
            System.out.println(totalSum);
        }
        
        sc.close();
    }
}
