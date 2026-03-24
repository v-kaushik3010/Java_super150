package Bit_Masking;

public class Minimize_XOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1 = 3;
		int nums2 = 5;
		System.out.println(find_x(nums1, nums2));
	}
	public static int find_x(int num1, int num2 ) {
		int setbit =0;
		while(num2>0) {
			num2 = (num2&(num2-1));
			setbit++;
		}
		int x = 0;
		for(int i=30; i >=0; i--) {
			int mask = (1<<i);
			if((num1 & mask) !=0) {
				x |= mask; // x = x|mask;
				setbit--;
				if(setbit==0) {
					return x;
				}
			}
		}
		for(int i =0; i <=30; i++) {
			int mask = (1<<i);
			if((num1 & mask) ==0) {
				x |= mask; // x = x|mask;
				setbit--;
				if(setbit==0) {
					return x;
				}
			}
		}
		// If we reach here return x (covers edge cases)
		return x;
	}
	
	// ANOTHER METHOD (kept as alternative). Made static and fixed bit tests to use != 0 so sign bit is handled correctly.
	public static int minimizeXor(int num1, int num2) {
	    int a = Integer.bitCount(num1);
	    int b = Integer.bitCount(num2);
	    int res = num1;
	    for (int i = 0; i < 32; i++) {
	        if (a > b && (((1 << i) & num1) != 0)) {
	            res ^= 1 << i;
	            a--;
	        }
	        if (a < b && (((1 << i) & num1) == 0)) {
	            res ^= 1 << i;
	            a++;
	        }
	    }
	    return res;
	}

}