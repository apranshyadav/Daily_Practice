class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to a very large value and maxProfit to 0.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through the prices array.
        for (int i = 0; i < prices.length; i++) {
            // If the current price is lower than the minimum price we've seen, update it.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Otherwise, check if selling today would yield a higher profit than we've recorded.
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}