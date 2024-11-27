package question;

public class containerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {8, 7, 2, 1};
		System.out.println(maxArea(height));
	}

		public static int maxArea(int[] height) {
	        int maxArea =0;
	        int leftwala = 0;
	        int rightwala = height.length - 1;

	        while (leftwala < rightwala){
	            maxArea = Math.max(maxArea,(rightwala - leftwala)*Math.min(height[leftwala],height[rightwala]));

	            if (height[leftwala] < height[rightwala]) leftwala++;
	            else rightwala--;
	        }return maxArea;
	        
	    
	}

}
