package lecture_1;

public class pattern12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=5;
		int star =1;
		int row=1;
		int space = n-1;
		while(row <= n) {
			//spaces
			int i = 1;
			while(i <= space) {
				System.out.print("  ");
				i++;
								
			}
			//star
			int j = 1;
			while(j <= star) {
				if(j%2!=0) {
				System.out.print("* ");}
				else {
					System.out.print("! ");
				}
				j++;

			}
			row++;
			System.out.println();
			space--;
			star+=2;
		}

	}

}
