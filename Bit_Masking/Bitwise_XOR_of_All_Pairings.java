package Bit_Masking;

public class Bitwise_XOR_of_All_Pairings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums1 = {2,1,3};
		int []nums2 = {10,2,5,0};
		System.out.prinltn(xorAllNums(nums1, nums2));

	}
	public static int xorAllNums(int[] nums1, int[] nums2) {
        int c1 = nums1.length;
        int c2 = nums2.length;
        int x1 = 0, x2 = 0;

        if (c1 % 2 != 0) {
            for (int num : nums2) {
                x2 ^= num;
            }
        }
        if (c2 % 2 != 0) {
            for (int num : nums1) {
                x1 ^= num;
            }
        }
        return x1 ^ x2;
    }

}
