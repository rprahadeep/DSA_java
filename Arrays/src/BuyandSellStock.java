// leetcode 121
// best time to buy and sell stock

public class BuyandSellStock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int ans = 0;
        int l = 0;
        int r = 1;
        while (r != prices.length) {
            if (prices[l] < prices[r]) {
                int prof = prices[r] - prices[l];
                ans = Math.max(ans, prof);
            } else {
                l = r;
            }
            r++;
        }
        System.out.println(ans);
    }
}
