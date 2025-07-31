package question;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] coin = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        combination(coin, target, li, ans, 0);
        System.out.println(ans);
    }

    public static void combination(int[] coin, int amount, List<Integer> li, List<List<Integer>> ans, int idx) {
        if (amount == 0) {
            ans.add(new ArrayList<>(li)); // Fix: Add a new list instead of referencing 'li'
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = idx; i < coin.length; i++) {
            if (amount >= coin[i]) {
                li.add(coin[i]);
                combination(coin, amount - coin[i], li, ans, i);
                li.remove(li.size() - 1);
            }
        }
    }
}
