package Dynamic_Programming;

//In this problem, you are given a set of items, each with a weight and a value, and we need to determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.
//NOTE: The items are indivisible, we can either take an item or not.
//
//
//Input format
//
//Input an integer n representing number of items.
//An array representing value of ith item.
//An array representing weight of ith item.
//An integer W which is the total weight.
//
//
//Output format
//
//An integer representing total value grabbed.
//
//
//Example 1
//
//Input
//
//6
//20 5 10 40 15 25
//1 2 3 8 7 4
//10
//
//
//Output
//
//60
//
//
//Explanation
//
//value = 20 + 40 = 60
//weight = 1 + 8 = 9 < W
//
//
//Constraints
//
//1<=n<=1000
//
//1<=weight[i]<=100
//
//1<=value[i]<=100
//
//1<=W<=1000

public class Knapsack_Zero_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cap = 4;
		int [] wt = {1, 2, 3, 2, 2};
		int [] val = {8, 4, 0, 5, 3};
		System.out.println(knapsack(wt, val, cap, 0));

	}
	
	public static int knapsack(int[] wt, int[] val, int cap, int i) {
		if(cap == 0 || i == wt.length) return 0;
		
		int inc =0, exc = 0;
		if(cap >= wt[i]) {
			
			inc = val[i]+ knapsack(wt, val, cap-wt[i], i+1 );
			
		}
		exc = knapsack(wt, val, cap, i + 1);
		return Math.max(inc , exc);
		
	}

}
