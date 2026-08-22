/*
 * Approach:
 * Use sliding window of size k. Maintain the current sum,
 * update it by removing the old element and adding the new one,
 * and track the maximum sum.
 *
 * Time: O(n)
 * Space: O(1)
 */
 class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        double ans=0;
        for(int i=0;i<k;i++){
           sum+=nums[i];
        }
        ans=sum;
        for(int i=k;i<n;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            ans=Math.max(ans,sum);
        }
        return ans/k;
    }
}