package Bit_Masking;

import java.util.*;
//formula used:
//u+v = (u^v) + 2(u&v)
public class Ehab_The_Xorcist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		int v  =sc.nextInt();
		if(u>v | u%2!= v%2 ) {
			System.out.println(-1);
		}else if(u==v) {
			if(u==0) System.out.println(0);
			else {
				System.out.println(1);
				System.out.println(u);
			}
		}else {
			long x = (v-u)/2;
			if((u&x) == 0) {
				System.out.println(2);
				System.out.println( u + x + " " +x);
			}else {
				System.out.println(3);
				System.out.println( u + " " + x + " " +x);
			}
		}
		
	}

}
