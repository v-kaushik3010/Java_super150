package lecture_5;

public class inverse_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 32145;
		 int sum = 0;
		 int pos = 1;
		 while(n>0) {
			 int rem = n%10;
			 sum = (int)(sum+pos*Math.pow(10, rem-1));
			 pos++;
			 n=n/10;
		 }
		 System.out.println(sum);
		

	}

}
