package challenge.y2021_week14;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Best Time to Buy and Sell Stock with Transaction Fee

public class Q03 {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1, len = prices.length; i < len; i++) {
            int price = prices[i];
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, price - fee + buy);
        }

        return sell;
    }
}
