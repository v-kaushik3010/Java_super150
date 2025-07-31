package CodeForces_1;


//Initially, the integers from 0
//to n−1
//are written on a blackboard.
//
//In one round,
//
//Alice chooses an integer a
//on the blackboard and erases it;
//then Bob chooses an integer b
//on the blackboard such that a+b≡3(mod4)
//∗
//and erases it.
//Rounds take place in succession until a player is unable to make a move — the first player who is unable to make a move loses. Determine who wins with optimal play.
//
//∗
//We define that x≡y(modm)
//whenever x−y
//is an integer multiple of m
//.
//
//Input
//The first line contains an integer t
//(1≤t≤100
//)  — the number of test cases.
//
//The only line of each test case contains an integer n
//(1≤n≤100
//) — the number of integers written on the blackboard.
//
//Output
//For each test case, output on a single line "Alice" if Alice wins with optimal play, and "Bob" if Bob wins with optimal play.
//
//You can output the answer in any case (upper or lower). For example, the strings "aLiCe", "alice", "ALICE", and "alICE" will be recognized as "Alice".
//
//Example
//InputCopy
//5
//2
//4
//5
//7
//100
//OutputCopy
//Alice
//Bob
//Alice
//Alice
//Bob
//Note
//In the first sample, suppose Alice chooses 0
//, then Bob cannot choose any number so Alice wins immediately.
//
//In the second sample, suppose Alice chooses 0
//, then Bob can choose 3
//. Then suppose Alice chooses 2
//, then Bob can choose 1
//. Then Alice has no numbers remaining, so Bob wins.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class Blackboard_Game {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t = Integer.parseInt(br.readLine().trim());
	        while (t-- > 0) {
	            int n = Integer.parseInt(br.readLine().trim());
	            
	            // If n is a multiple of 4, Bob wins; otherwise, Alice wins.
	            if (n % 4 == 0) {
	              System.out.println("Bob");
	            }else System.out.println("Alice");
	        }
	 }
}
