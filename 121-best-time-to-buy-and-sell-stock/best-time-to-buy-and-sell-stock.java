class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;  // consistent naming

        for (int price : prices) {
            // update minimum price
            if (price < minPrice) {
                minPrice = price;
            }

            // calculate profit if sold today
            int profit = price - minPrice;

            // update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
