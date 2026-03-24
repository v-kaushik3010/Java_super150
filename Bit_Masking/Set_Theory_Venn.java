package Bit_Masking;

public class Set_Theory_Venn {

	public static void main(String[] args) {

				int[] arr = {2,3,5};
				int n = 1000;
				System.out.println(venn_Diagram(arr, n));
			}
			
			public static int venn_Diagram(int[] arr, int n) {
				int l = arr.length;
				int count = 0;
				for(int i=1; i<(1<<l); i++) {
					int ans = powerSet(arr, n, i);
					if (set_bit(i)%2 == 0) count-=ans;
					else count+=ans;
				}
				return count;
			}
			
			public static int powerSet(int[] arr, int n, int i) {
				int ans = 1;
				int idx = 0;
				while (i>0) {
					if ((i&1)!=0) {
						ans = ans*arr[idx];
					}
					idx++;
					i>>=1;
				}
				return n/ans;
			}
			
			public static int set_bit(int n) {
				int count = 0;
				while (n>0) {
					n = n&(n-1);
					count++;
				}
				return count;		
		
		
	}

}
