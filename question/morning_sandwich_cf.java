package question;
import java.util.*;

public class morning_sandwich_cf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		while(t-- > 0) {
			int br = sc.nextInt();
			int hm = sc.nextInt();
			int ch = sc.nextInt();
			if (br > hm+ch) {
				System.out.println((hm+ch)*2 +1);
				
			}else {
				System.out.println(br*2 -1);
			}
		}sc.close();
	}

}
