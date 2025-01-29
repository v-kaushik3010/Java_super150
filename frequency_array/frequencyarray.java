package frequency_array;

public class frequencyarray {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		String s = "bsdbvdnfjdgwndsbdnghjsaydukyjadhmabsmdbmnasbdmhdkjyhkwdbwmbdmdnbvnvbnsbnvdhghdtshgdndbnmsbdmbdghjsadgdghdasggnsadbvdvsndsb";
		int [] freq = new int[26];
		for (int  i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int idx = ch-'a';
			freq[idx]++;
			
		}
	}

}
