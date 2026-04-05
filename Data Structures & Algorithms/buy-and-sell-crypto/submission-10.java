class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      int minimumBuy = prices[0];

      for(int x : prices){
        minimumBuy = Math.min(minimumBuy, x);
        maxProfit = Math.max(maxProfit, x - minimumBuy);
        
      }

      return maxProfit;
}
}
