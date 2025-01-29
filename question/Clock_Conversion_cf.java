package question;
import java.util.Scanner; 
public class Clock_Conversion_cf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner scanner = new Scanner(System.in);  
		        int t = scanner.nextInt();  
		        scanner.nextLine();

		        for (int i = 0; i < t; i++) {  
		            String s = scanner.nextLine();  
		            System.out.println(convertTo12HourFormat(s));  
		        }scanner.close();  
		    }  
				

		    private static String convertTo12HourFormat(String time) {  
		        String[] parts = time.split(":");  
		        int hours = Integer.parseInt(parts[0]);  
		        String minutes = parts[1];  
		        String period;  

		        if (hours == 0) {  
		            hours = 12;  
		            period = "AM";  
		        } else if (hours < 12) {  
		            period = "AM";  
		        } else if (hours == 12) {  
		            period = "PM";  
		        } else {  
		            hours -= 12;  
		            period = "PM";  
		        }  

		        // Format hours with leading zeros if necessary  
		        String formattedHours = String.format("%02d", hours);  
		        return formattedHours + ":" + minutes + " " + period;  
		    

	}

}
