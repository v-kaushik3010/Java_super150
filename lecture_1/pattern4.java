package lecture_1;

public class pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=5;
		int star =1;
		int row=1;
		int space = n-1;
		while(row<=n) {
			//spaces
			int i = 1;
			while(i<= space) {
				System.out.print("  ");
				i++;
								
			}
			//stars
			int j = 1;
			while(j<= star) {
				System.out.print("* ");
				j++;
				
			}
			row++;
			//next row li prep
			System.out.println("");
			space--;
			star++;
		}
	}

}
