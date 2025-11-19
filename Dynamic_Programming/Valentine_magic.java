package Dynamic_Programming;

import java.util.Arrays;

//
//It's Valentine's Day in Russia today. as we all know number of girls in Russia is more than number of boys 😜  hence boys have an extra advantage while choosing girl for the valentine evening. Each boy has certain number of chocolates and each girl has certain number of candies. Now you being the anchor of evening wants to pair all the boys with girls such that the sum of absolute difference between boy's chocolate and girl's candy in a pair is minimized. Ofcourse some of the girls will remain unpaired but that's okay as we are in Russia 😜
//
//
//Input format
//
//The first line consists of two integers N and M.
//then follow N integers in second line.
//Then follow M integers in third line.
//M >= N
//
//
//Output format
//
//The only line which consists of required sum of absolute differences.
//
//
//Example 1
//
//Input
//
//2 5
//4 5
//1 2 3 4 5
//
//
//Output
//
//0
//
//
//Explanation
//
//we can pair boy numbered 1 with girl numbered 4 and boy numbered 2 with girl numbered 5
//
//
//Constraints
//
//1 <= N <= 5000 
//
//1 <= M <= 5000 
//
//M >= N 
//
//1 <= chocolates <= 1000000 
//
//1 <= candies <= 1000000

public class Valentine_magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] boys = {2, 11, 3};
		int [] girls = {5, 7, 3, 2};
		Arrays.sort(boys);
		Arrays.sort(girls);
		
		System.out.println(Valentine(boys, girls, 0, 0));

	}
	public static int Valentine(int [] boys, int [] girls, int i, int j) {
		if(i == boys.length) return 0;
		if(j == girls.length) return 9999999;
		
		int set = Math.abs(boys[i] - girls[j]) + Valentine(boys, girls, i+1, j+1);
		int rej = Valentine(boys, girls, i, j+1);
		return Math.min(set,  rej);
	}

}
