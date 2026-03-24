package TrieOrPrefixTree;

public class Maximum_XOR_of_two_numbers_in_an_array {
	public static void main(String[] args) {
		int[] arr = {3, 10, 5, 25, 2, 8};
		Trie t = new Trie();
		for(int x : arr) {
			t.add(x);
		}
		int ans = 0;
		for(int x: arr) {
			ans = Math.max(t.getMaxXor(x), ans);
		}System.out.println(ans);
	}
	 
	}
}
