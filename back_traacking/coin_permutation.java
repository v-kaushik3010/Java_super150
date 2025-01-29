package back_traacking;

public class coin_permutation {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 5};
        int amount = 5;
        permutation(coins, amount, "");
    }

    public static void permutation(int[] coins, int amount, String ans) {
        // Base case: if amount is exactly zero, print the answer
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            // Only proceed if the remaining amount is non-negative
            if (amount - coins[i] >= 0) {
                permutation(coins, amount - coins[i], ans + coins[i] + " ");
            }
        }
    }
}

