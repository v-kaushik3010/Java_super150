package CodeForces_1;

//6
//6 2
//000000
//2 1
//01
//4 1
//1011
//10 2
//1101011001
//10 1
//1101011001
//2 1
//11

//NO
//NO
//YES
//NO
//YES
//YES


import java.util.Scanner;
public class NotQuitePalindromicString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            
            int count0 = 0, count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') count0++;
                else count1++;
            }
            
            int totalPairs = n / 2;
            
            int nonMatchingPairs = totalPairs - k;
            
            if (count0 < nonMatchingPairs || count1 < nonMatchingPairs) {
                System.out.println("NO");
                continue;
            }
            
            int remaining0 = count0 - nonMatchingPairs;
            int remaining1 = count1 - nonMatchingPairs;
            
            int maxMatchingPairs = remaining0 / 2 + remaining1 / 2;
            
            if (maxMatchingPairs >= k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
	}

