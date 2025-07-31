package CodeForces_1;

// /*Skibidus is given a string s
//  that consists of lowercase Latin letters. If s
//  contains more than 1
//  letter, he can:

// Choose an index i
//  (1≤i≤|s|−1
// , |s|
//  denotes the current length of s
// ) such that si=si+1
// . Replace si
//  with any lowercase Latin letter of his choice. Remove si+1
//  from the string.
// Skibidus must determine the minimum possible length he can achieve through any number of operations.

// Input
// The first line contains an integer t
//  (1≤t≤100
// ) — the number of test cases.

// The only line of each test case contains a string s
//  (1≤|s|≤100
// ). It is guaranteed s
//  only contains lowercase Latin letters.

// Output
// For each test case, output an integer on the new line, the minimum achievable length of s
// .

// Example
// InputCopy
// 4
// baa
// skibidus
// cc
// ohio
// OutputCopy
// 1
// 8
// 1
// 4
// Note
// In the first test case, Skibidus can:

// Perform an operation on i=2
// . He replaces s2
//  with b and removes s3
//  from the string. Then, s
//  becomes bb.
// Perform an operation on i=1
// . He replaces s1
//  with b and removes s2
//  from the string. Then, s
//  becomes b.
// Because s
//  only contains 1
//  letter, Skibidus cannot perform any more operations.
// Therefore, the answer is 1
//  for the first test case.

// In the second test case, he cannot perform an operation on any index. Therefore, the answer is still the length of the initial string, 8
// . */

// import java.util.Scanner;

// public class Skibidus_and_Ohio {

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int t = sc.nextInt();
// 		while(t-->0) {
// 			String s = sc.next();
// 			int n = s.length();
// 			int count = 0;
// 			for(int i = 0; i < n-1; i++) {
// 				if(s.charAt(i) == s.charAt(i+1)) {
// 					count++;
// 					i++;
// 				}
// 			}
// 			System.out.println(n-count);
// 		}
// 	sc.close();

// 	}

// }




import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Skibidus_and_Ohio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read number of test cases
        while (t-- > 0) {
            String s = sc.next(); // Read the string for the current test case
            
            // Use a Set to track unique characters
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                uniqueChars.add(c); // Add each character to the set
            }
            
            // The minimum length is the number of unique characters
            System.out.println(uniqueChars.size());
        }
        sc.close();
    }
}

