package recursion;

import java.util.*;

public class keypad {
    static String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new ArrayList<>();
        
        if (digits.length() > 0) { // Edge case check
            generateCombinations(digits, "", result);
        }
        
        System.out.println(result);
    }
    
    public static void generateCombinations(String ques, String ans, List<String> result) {
        if (ques.length() == 0) {
            result.add(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String getString = key[ch - '0'];
        
        for (int i = 0; i < getString.length(); i++) {
            generateCombinations(ques.substring(1), ans + getString.charAt(i), result);
        }
    }
}
