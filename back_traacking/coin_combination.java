package back_traacking;

public class coin_combination {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 5};
        int amount = 5;
        permutation(coins, amount, "", 0);
    }

    public static void permutation(int[] coins, int amount, String ans, int idx) {
        // Base case: if amount is exactly zero, print the answer
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            // Only proceed if the remaining amount is non-negative
            if (amount - coins[i] >= 0) {
                permutation(coins, amount - coins[i], ans + coins[i] + " ", i); /// infinite coins so only i is passed
            }
        }
    }
}
