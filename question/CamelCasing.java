package question;

public class CamelCasing {  

    public static void main(String[] args) {  
        String s = "IAmACompetitiveProgrammer";  
        Read(s);  
    }  

    public static void Read(String s) {  
        StringBuilder ans = new StringBuilder();  
        
        for (int i = 0; i < s.length(); i++) {  
            if (Character.isUpperCase(s.charAt(i))) {  
                if (ans.length() > 0) {  
                    System.out.println(ans);  
                }  
                ans.setLength(0);  
                ans.append(s.charAt(i));  
            } else {  
                ans.append(s.charAt(i));  
            }  
        }  
        if (ans.length() > 0) {  
            System.out.println(ans);  
        }  
    }  
}