/*
 * Find the maximum sum of a contiguous subarray
 * Approach: Kadane's Algorithm
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(sum>max)
             max=sum;
            if(sum<0)
             sum=0;
        }
        return max;
    }
}