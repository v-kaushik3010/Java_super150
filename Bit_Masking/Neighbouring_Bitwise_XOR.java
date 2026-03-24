package Bit_Masking;

public class Neighbouring_Bitwise_XOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for (int x : derived) {
            res ^= x;
        }
        return res == 0;
    }

}
