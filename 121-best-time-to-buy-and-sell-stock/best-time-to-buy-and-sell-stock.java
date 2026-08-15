/*
 * Find the maximum profit from buying and selling a stock once
 * Approach: Track the minimum buying price and maximum profit
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            ans=Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}